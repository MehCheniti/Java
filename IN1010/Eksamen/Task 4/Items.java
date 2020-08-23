import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Items{

private ArrayList<Item> items = new ArrayList<Item>();

  public boolean start(String file){
    try{
      items.clear();
      File f = new File(file);
      if (!f.exists()){
        return false;
      }
      Scanner scanner = new Scanner(f);
      String content = new String();
      while (scanner.hasNextLine()){
        content = scanner.nextLine();
        // Adds in the name and value of the item.
        items.add(new Item(content.substring(0, content.indexOf(" ")),
        Integer.valueOf(content.substring(content.indexOf(" ") + 1))));
      }
      scanner.close();
      return true;
    } catch (FileNotFoundException e){
      e.printStackTrace();
      return false;
    }
  }

  public ArrayList<Item> getItems(){
    return items;
  }

}
