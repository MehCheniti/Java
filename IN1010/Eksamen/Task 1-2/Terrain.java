import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terrain{

private Place firstPlace;

  public boolean start(String file, Items items, boolean circular, int
  maxItemsInChest){
    this.firstPlace = null;

    try{
      Place actualPlace = null;
      File f = new File(file);
      if (!f.exists()){
        return false;
      }
      Scanner scanner = new Scanner(f);
      String content = new String();
      while (scanner.hasNextLine()){
        content = scanner.nextLine();
        double ratio = (double)(Math.random()) + 0.5;
        Place place = new Place(content, maxItemsInChest, ratio);
        place.setTreasureChest(new TreasureChest(maxItemsInChest));
        for (int nbItems = ((int)(Math.random() * ((maxItemsInChest - 0)))) + 1;
        nbItems > 0; nbItems--){
          int item = ((int)(Math.random() * ((items.getItems().size() - 0))));
          place.getTreasureChest().addItem(items.getItems().get(item), ratio);
        }
        if (firstPlace == null){
          firstPlace = place;
        } else{
          actualPlace.setNextPlace(place);
        }
        actualPlace = place;
      }
      if (circular){
        actualPlace.setNextPlace(firstPlace);
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

  public int getPlaceCount(){
    boolean turn = false;
    Place actualPlace = firstPlace;
    int count = 0;

    while (true){
      if ((turn == true && actualPlace == firstPlace) || actualPlace == null){
        break;
      }
      if (!turn){
        turn = !turn;
      }
      count++;
      actualPlace = actualPlace.getNextPlace();
    }
    return count;
  }

}
