public class MultipleExitPlayer extends Player{

private MultipleExitPlace multiExitPlace;

  public MultipleExitPlayer(Place place, UserInterface interf, int
  maxItemsInChest, String name){
    super(place, interf, maxItemsInChest, name);
    this.multiExitPlace = (MultipleExitPlace) place;
  }

  protected void askMove(){
    int ret = interf.askForCommand("Choose your destination.\n",
    multiExitPlace.getDescriptions().toArray(new String[0]));
    multiExitPlace = multiExitPlace.getNextPlaces().get(ret);
  }

  protected void askBuyitem(){
    String items = new String();

    for (Item item : multiExitPlace.getTreasureChest().getItems()){
      items += item.getName() + " [" + item.getValue() + "]\n";
    }

    String[] options = {"yes", "no"};
    int ret = interf.askForCommand(
    "Do you want to pick up an item from the place? [" +
    backpack.getItems().size() + "/ " + backpack.maxItems() + "]\n\n" + items,
    options);

    if (options[ret] == "yes"){
      Item item = multiExitPlace.getTreasureChest().removeItem();
      backpack.addItem(item, multiExitPlace.getRatio());
      interf.giveStatus("You picked up " + item.getName() + " [" +
      item.getValue() + "].");
    } else{
      interf.giveStatus("You decided not to pick up any items.");
    }
  }

  protected void askSellItem(){
    if (backpack.getItems().size() <= 0){
      interf.giveStatus("There are no items in your backpack.");
      return;
    }

    String[] options = {"yes", "backpack", "no"};
    int ret = interf.askForCommand(
    "Do you want to sell an item to the place? [FORTUNE: " + this.fortune +
    "] [SELL RATIO: " + String.format("%.0f", multiExitPlace.getRatio() * 100)
    + "%]\n", options);

    if (options[ret] == "yes"){
      int fortune = this.fortune;
      Item item = backpack.removeItem();
      int price = multiExitPlace.getTreasureChest().addItem(item,
      multiExitPlace.getRatio());
      this.fortune += price;
      interf.giveStatus("You sold " + item.getName() + " [" + item.getValue() +
      "] for [" + price + "] (" + String.format("%.0f",
      multiExitPlace.getRatio() * 100)
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

  public void newMove(int turns, int maxTurns){
    interf.giveStatus(multiExitPlace.getDescription() + "[TURN " + turns + "/ "
    + maxTurns + "]");
    askSellItem();
    askBuyitem();
    askMove();
  }

}
