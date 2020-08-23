public class Place{

private String description;
private TreasureChest treasureChest;
private double ratio;
private Place nextPlace = null;

  public Place(String description, int maxItemsInChest, double ratio){
    this.description = description;
    this.treasureChest = new TreasureChest(maxItemsInChest);
    this.ratio = ratio;
  }

  public Place(String description, Place nextPlace){
    this.description = description;
    this.nextPlace = nextPlace;
  }

  public Place getNextPlace(){
    return nextPlace;
  }

  public String getDescription(){
    return description;
  }

  public TreasureChest getTreasureChest(){
    return treasureChest;
  }

  public double getRatio(){
    return ratio;
  }

  public void setNextPlace(Place nextPlace){
    this.nextPlace = nextPlace;
  }

  public void setTreasureChest(TreasureChest treasureChest){
    this.treasureChest = treasureChest;
  }

}
