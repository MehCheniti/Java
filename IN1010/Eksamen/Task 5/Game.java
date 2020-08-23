import java.util.ArrayList;

public class Game{

String fileItems;
String fileTerrain;
boolean isCircular;
int maxItemsInChest;
int maxTurns;
boolean randomStart;
int turns = 0;
ArrayList<Player> players = new ArrayList<Player>();
Terrain terrain;
Items items;

  public boolean newGame(String fileItems, String fileTerrain, boolean
  isCircular, int maxItemsInChest, int maxTurns, boolean randomStart, boolean
  multiple){
    players.clear();
    this.fileItems = fileItems;
    this.fileTerrain = fileTerrain;
    this.isCircular = isCircular;
    this.maxItemsInChest = maxItemsInChest;
    this.maxTurns = maxTurns;
    this.randomStart = randomStart;
    this.turns = 0;
    items = new Items();

    if (!items.start(fileItems)){
      System.out.println("The file " + fileItems + " is wrong.");
      return false;
    }

    if (multiple){
      terrain = new MultipleExitTerrain();
    } else{
      terrain = new Terrain();
    }

    if (!terrain.start(fileTerrain, items, isCircular, maxItemsInChest)){
      System.out.println("The file " + fileTerrain + " is wrong.");
      return false;
    }

    return true;
  }

  public void addPlayer(Player player){
    players.add(player);
  }

  public void start(){
    if (this.players.size() <= 0) {
      System.out.println("\n*** ERROR - PLEASE TRY AGAIN ***\n");
      return;
    }

    System.out.println("\n*** NEW GAME ***\n");
    System.out.println("Players: " + this.players.size() + ".");
    System.out.println("Circular: " + this.isCircular + ".");
    System.out.println("Max items: " + this.maxItemsInChest + ".");
    System.out.println("Max turns: " + this.maxTurns + ".");
    System.out.println("Random start: " + this.randomStart + ".\n");

    while (this.turns < this.maxTurns){
      for (Player player : players){
        System.out.println("\nPlayer " + player.getName() + " has to play.\n");
        player.newMove(turns, maxTurns);
      }
      this.turns++;
    }
  }

  public void end(){
    if (this.players.size() <= 0){
      return;
    }

    int winner = findWinner();
    System.out.println("The winner is " + players.get(winner).getName() + "!");
    System.out.println("Total fortune: " + players.get(winner).getFortune() +
    ".");
  }

  private int findWinner(){
    int winner = 0;
    int fortune = players.get(0).getFortune();
    int index = 0;

    for (Player player : players){
      if (player.getFortune() > fortune){
        winner = index;
        fortune = player.getFortune();
      }
      index++;
    }
    return winner;
  }

  public Terrain getTerrain(){
    return terrain;
  }

  public Items getItems(){
    return items;
  }

}
