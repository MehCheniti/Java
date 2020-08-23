import java.util.Scanner;

public class FortuneGame{

  public static void main(String[] args) throws Exception{
    Game game = new Game();

    if (game.newGame("gjenstander.txt", "steder.txt", true, 5, 6, false) ==
    false){
      return;
    }

    // game.addPlayer(new Player(game.getTerrain().getStart(true), new
    // Terminal(new Scanner(System.in)), 5, "Meh"));
    game.addPlayer(new Player(game.getTerrain().getStart(true), new Robot(),
    5, "Robo-Meh"));
    game.start();
    game.end();
  }

}
