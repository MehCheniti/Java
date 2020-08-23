import java.util.Scanner;

public class FortuneGame{

  public static void main(String[] args) throws Exception{
    String contain = new String();
    Scanner scanner = new Scanner(System.in);
    boolean multiple = false;
    boolean circular = false;
    boolean randomStart = false;
    int maxItemsInChest = 5;
    int maxTurns = 5;

    System.out.println("\nWelcome to FortuneGame!");

    while (true){
      System.out.print("\n? NEW GAME ?\n> yes\n> exit\n\n>> ");
      contain = scanner.nextLine();
      if (!contain.contains("yes")){
        break;
      }
      System.out.println("");

      System.out.print("? SINGLE OR MULTI ?\n> single\n> multi\n\n>> ");
      contain = scanner.nextLine();
      if (contain.contains("multi")){
        multiple = true;
      }
      System.out.println("");

      System.out.print("? CIRCULAR GAME ?\n> yes\n> no\n\n>> ");
      contain = scanner.nextLine();
      if (contain.contains("yes")){
        circular = true;
      }
      System.out.println("");

      System.out.print("? MAX ITEMS IN CHEST ?\n\n>> ");
      contain = scanner.nextLine();
      maxItemsInChest = Integer.parseInt(contain);
      System.out.println("");

      System.out.print("? MAX TURNS ?\n\n>> ");
      contain = scanner.nextLine();
      maxTurns = Integer.parseInt(contain);
      System.out.println("");

      System.out.print("? RANDOM START ?\n> yes\n> no\n\n>> ");
      contain = scanner.nextLine();
      if (contain.contains("yes")){
        randomStart = true;
      }
      System.out.println("");

      Game game = new Game();

      if (game.newGame("gjenstander.txt", "steder.txt", circular,
      maxItemsInChest, maxTurns, randomStart, multiple) == false){
        return;
      }

      while (true){
        System.out.print(
        "? PLAYER OR ROBOT ?\n> player\n> robot\n> ready\n\n>> ");
        contain = scanner.nextLine();
        if (contain.contains("player")){
          System.out.print(
          "\nPlease input your name. Select 'ready' to play.\n\n>> ");
          contain = scanner.nextLine();
          if (multiple){
            game.addPlayer(new MultipleExitPlayer(
            game.getTerrain().getStart(randomStart), new
            Terminal(new Scanner(System.in)), maxItemsInChest, contain));
          } else{
            game.addPlayer(new Player(game.getTerrain().getStart(randomStart),
            new Terminal(new Scanner(System.in)), maxItemsInChest, contain));
          }
        } else if (contain.contains("robot")){
          System.out.print(
          "\nPlease input the robot's name. Select 'ready' to watch.\n\n>> ");
          contain = scanner.nextLine();
          if (multiple){
            game.addPlayer(new MultipleExitPlayer(
            game.getTerrain().getStart(randomStart), new Robot(),
            maxItemsInChest, contain));
          } else{
            game.addPlayer(new Player(game.getTerrain().getStart(randomStart),
            new Robot(), maxItemsInChest, contain));
          }
        } else{
          break;
        }
        System.out.println("");
      }
      game.start();
      game.end();
    }
  }

}
