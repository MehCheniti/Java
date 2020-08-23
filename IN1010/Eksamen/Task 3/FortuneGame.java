import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

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
    cancel("Congratulations, you've won!");

    try{
      for (int i = 0; i < 5; i++){
        Thread.sleep(1000);
      }
    } catch (InterruptedException e){
      e.printStackTrace();
    }

    System.exit(0);
  }

  public static void cancel(String result){
    JFrame frame = new JFrame("Result window");
    JButton button = new JButton("Cancel");
    JTextField text = new JTextField(result);

    text.setBounds(100, 150, 300, 100);
    button.setBounds(150, 300, 150, 100);

    frame.add(button);
    frame.add(text);

    frame.setLocationRelativeTo(null);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setVisible(true);

    button.addActionListener(e -> {
      frame.dispose();
    });
  }

}
