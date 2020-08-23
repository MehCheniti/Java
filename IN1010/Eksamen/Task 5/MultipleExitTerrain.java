import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleExitTerrain extends Terrain{

  private MultipleExitPlace firstPlace;

  public boolean start(String file, Items items, boolean circular, int
  maxItemsInChest){
    this.firstPlace = null;

    try{
      ArrayList<MultipleExitPlace> tempPlaces = new
      ArrayList<MultipleExitPlace>();
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

        ArrayList<String> descriptions = new ArrayList<String>();
        descriptions.add("left");
        descriptions.add("forward");
        descriptions.add("right");

        // Creation of a new place.
        MultipleExitPlace newPlace = new MultipleExitPlace(content,
        maxItemsInChest, ratio, descriptions);

        // Adds a new treasure chest in the place.
        newPlace.setTreasureChest(new TreasureChest(maxItemsInChest));

        // nbItems is a random value between maxItemsInChest and 1.
        for (int nbItems = ((int)(Math.random() * ((maxItemsInChest - 0)))) + 1;
        nbItems > 0; nbItems--){
          // Item is random between 0 and the number of items in the list of
          // items of the object Items.
          int item = ((int)(Math.random() * ((items.getItems().size() - 0))));
          // Adds the item in the chest of the place.
          newPlace.getTreasureChest().addItem(items.getItems().get(item),
          ratio);
        }

        // If the firstPlace hasn't been initialised, it is assigned directly
        // to a new place.
        if (this.firstPlace == null){
          this.firstPlace = newPlace;
        }
        tempPlaces.add(newPlace);
      }

      for (int i = 0; i < tempPlaces.size(); i++){
        ArrayList<MultipleExitPlace> places = new
        ArrayList<MultipleExitPlace>();
        for (int y = 0; y < 3; y++){
          int coord = (int)(Math.random() * tempPlaces.size());
          if (coord == i){
            y--;
            continue;
          }
          places.add(tempPlaces.get(coord));
        }
        tempPlaces.get(i).setNextPlaces(places);
      }
      scanner.close();
      return true;
    } catch (FileNotFoundException e){
      e.printStackTrace();
      return false;
    }
  }

  public MultipleExitPlace getStart(boolean random){
    return firstPlace;
  }

}
