import java.awt.event.KeyEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusListener;



public class KeyboardListener implements KeyListener, FocusListener{

public boolean[] keys = new boolean[120];
private Game game;

  public KeyboardListener(Game game){
    this.game = game;
  }

  public void keyPressed(KeyEvent event){
    int keyCode = event.getKeyCode();

    if (keyCode < keys.length){
      keys[keyCode] = true;
    }

    if (keys[KeyEvent.VK_CONTROL]){
      game.handleCTRL(keys);
    }
  }

  public void keyReleased(KeyEvent event){
    int keyCode = event.getKeyCode();

    if (keyCode < keys.length){
      keys[keyCode] = false;
    }
  }

  public void focusLost(FocusEvent event){
    for (int i = 0; i < keys.length; i++){
      keys[i] = false;
    }
  }

  public boolean up(){
    return keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
  }

  public boolean left(){
    return keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
  }

  public boolean down(){
    return keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
  }

  public boolean right(){
    return keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
  }

  public void keyTyped(KeyEvent event) {}

  public void focusGained(FocusEvent event) {}

}
