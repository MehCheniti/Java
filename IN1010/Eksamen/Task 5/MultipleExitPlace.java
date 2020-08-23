import java.util.ArrayList;

public class MultipleExitPlace extends Place{

ArrayList<String> descriptions;
ArrayList<MultipleExitPlace> nextPlaces;

  public MultipleExitPlace(String description, int maxItemsInChest, double
  ratio, ArrayList<String> descriptions){
    super(description, maxItemsInChest, ratio);
    this.descriptions = descriptions;
  }

  public ArrayList<String> getDescriptions(){
    return descriptions;
  }

  public ArrayList<MultipleExitPlace> getNextPlaces(){
    return nextPlaces;
  }

  public void setNextPlaces(ArrayList<MultipleExitPlace> nextPlaces){
    this.nextPlaces = nextPlaces;
  }

}
