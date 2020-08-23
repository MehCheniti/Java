import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terrain{

private Place firstPlace;

  public boolean start(String file, Items items, boolean circular, int
  maxItemsInChest){
    this.firstPlace = null;

    try{
      // Temporary place that saves the last place to declare the algorithm.
      Place lastPlace = null;

      File f = new File(file);
      if (!f.exists()){
        return false;
      }
      Scanner scanner = new Scanner(f);
      String content = new String();
      while (scanner.hasNextLine()){
        content = scanner.nextLine();
        // Random value between 0.5 and 1.5.
        double ratio = (double)(Math.random()) + 0.5;
        // Creation of a new place.
        Place newPlace = new Place(content, maxItemsInChest, ratio);
        //Adds a new chest to the place.
        newPlace.setTreasureChest(new TreasureChest(maxItemsInChest));
        // Number of items between maxItemsInChest and 1.
        for (int nbItems = ((int)(Math.random() * ((maxItemsInChest - 0)))) + 1;
        nbItems > 0; nbItems--){
          // Item is random between 0 and the number of items in the list of
          // items of the object Items.
          int item = ((int)(Math.random() * ((items.getItems().size() - 0))));
          // Adds the item in a chest of the place.
          newPlace.getTreasureChest().addItem(items.getItems().get(item),
          ratio);
        }
        // If firstPlace hasn't been initialised, assign it directly to a new
        // place.
        if (this.firstPlace == null){
          this.firstPlace = newPlace;
          // If firstPlace hasn't been initialised.
        } else{
          // Sets nextPlace of the last place to the new place.
          lastPlace.setNextPlace(newPlace);
        }
        // Keeps a memory of the lastly declared last place.
        lastPlace = newPlace;
      }

      // At the end of the initialisation of all the places, if the circular
      // mode is activated, set nextPlace of the last place to the first place,
      // which creates a cycle.
      if (circular){
        lastPlace.setNextPlace(this.firstPlace);
      }

      scanner.close();
      return true;
    } catch (FileNotFoundException e){
      e.printStackTrace();
      return false;
    }
  }

  public Place getStart(boolean random){
    return firstPlace;
  }

}
