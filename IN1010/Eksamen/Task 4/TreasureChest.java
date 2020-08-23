import java.util.ArrayList;

public class TreasureChest{

private int maxItems;
private ArrayList<Item> items = new ArrayList<Item>();

  public TreasureChest(int maxItems){
    this.maxItems = maxItems;
  }

  public ArrayList<Item> getItems(){
    return items;
  }

  public int maxItems(){
    return maxItems;
  }

  public Item removeItem(){
    int rdm = ((int)(Math.random() * ((items.size() - 0))));
    Item item = items.get(rdm);
    items.remove(rdm);
    return item;
  }

  // Adds an item to the list and returns the price multiplied with the ratio.
  public int addItem(Item item, double ratio){
    if (items.size() >= maxItems){
      return 0;
    }
    items.add(item);
    int value = (int)(item.getValue() * ratio);
    return value;
  }

}
