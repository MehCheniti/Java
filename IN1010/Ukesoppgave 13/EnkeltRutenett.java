import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class EnkeltRutenett extends Application{

  public void start(Stage stage){
    GridPane pane = new GridPane();
    int teller = 1;

    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        Text text = new Text(""+teller);
        text.setFont(new Font(30));
        Rectangle rect = new Rectangle(40, 40, Color.SKYBLUE);
        rect.setStroke(Color.BLACK);
        StackPane cell = new StackPane();
        cell.getChildren().addAll(rect, text);
        pane.add(cell, j, i);
        teller++;
      }
    }

    Scene scene = new Scene(pane);
    stage.setScene(scene);
    stage.setTitle("Rutenett");
    stage.show();
    }

  public static void main(String[] args){
    Application.launch(args);
  }

}
