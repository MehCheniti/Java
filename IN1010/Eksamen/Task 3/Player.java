public class Player{

private int fortune = 0;
private TreasureChest backpack;
private Place place;
private UserInterface interf;
private String name;

  public Player(Place place, UserInterface interf, int maxItemsInChest,
  String name){
    this.place = place;
    this.interf = interf;
    this.backpack = new TreasureChest(maxItemsInChest);
    this.name = name;
  }

  public Place getPlace(){
    return place;
  }

  public TreasureChest getBackpack(){
    return backpack;
  }

  public int getFortune(){
    return fortune;
  }

  public void newMove(int turns, int maxTurns){
    interf.giveStatus(place.getDescription() + "[TURN " + turns + "/ " +
    maxTurns + "]");

    askSellItem();
    askBuyitem();
    askMove();
  }

  private void askSellItem(){
    if (backpack.getItems().size() <= 0){
      interf.giveStatus("There are no items in your backpack.");
      return;
    }

    String[] options = {"yes", "backpack", "no"};
    int ret = interf.askForCommand(
    "Do you want to sell an item to the place? [FORTUNE: " + this.fortune +
    "] [SELL RATIO: " + String.format("%.0f", place.getRatio() * 100) + "%]\n",
    options);

    if (options[ret] == "yes"){
      int fortune = this.fortune;
      Item item = backpack.removeItem();
      int price = place.getTreasureChest().addItem(item, place.getRatio());
      this.fortune += price;
      interf.giveStatus("You sold " + item.getName() + " [" + item.getValue() +
      "] for [" + price + "] (" + String.format("%.0f", place.getRatio() * 100)
      + "%).\n\tYour fortune went from [" + fortune + "] to [" + this.fortune +
      "].");
    } else if (options[ret] == "backpack"){
      String res = new String();
      for (Item item : backpack.getItems()){
        res += item.getName() + " [" + item.getValue() + "]\n";
      }
      interf.giveStatus("Items in your backpack: \n\n" + res);
      askSellItem();
      return;
    } else{
      interf.giveStatus("You decided not to sell any items.");
    }
  }

  private void askBuyitem(){
    String items = new String();

    for (Item item : place.getTreasureChest().getItems()){
      items += item.getName() + " [" + item.getValue() + "]\n";
    }

    String[] options = {"yes", "no"};
    int ret = interf.askForCommand(
    "Do you want to pick up an item from the place? [" +
    backpack.getItems().size() + "/ " + backpack.maxItems() + "]\n\n" + items,
    options);

    if (options[ret] == "yes"){
      Item item = place.getTreasureChest().removeItem();
      backpack.addItem(item, place.getRatio());
      interf.giveStatus("You picked up " + item.getName() + " [" +
      item.getValue() + "].");
    } else{
      interf.giveStatus("You decided not to pick up any items.");
    }
  }

  private void askMove(){
    String[] options = {"yes", "no"};
    int ret = interf.askForCommand("Do you want to move to the next place?\n",
    options);

    if (options[ret] == "yes"){
      place = place.getNextPlace();
    }
  }

  public String getName(){
    return name;
  }

}
