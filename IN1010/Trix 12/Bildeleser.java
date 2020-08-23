import java.io.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.FileChooser.*;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.event.*;
import java.io.*;
import java.util.*;
import javafx.geometry.*;
import javafx.stage.FileChooser.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.input.*;


public class Bildeleser extends Application{
  static Pane pane = new Pane();
  final static int PADDINGY = 50; //padding fra toppen slik at det er plass til filvelger

  Button velgFilKnapp;
  Button lastInnKnapp;

  public static void main(String[] args) {
          launch();
    }

    public static void lesInn(File fil) throws FileNotFoundException{
      Scanner sc = new Scanner(fil);
      String[] figur = sc.nextLine().split(" ");
      while(sc.hasNextLine()){

        //Oppretter rektangler:
        if(figur[1].equals("Rectangles")){
          while(sc.hasNextLine()){
            figur = sc.nextLine().split(" ");
            if(figur[0].equals("#")){
              break;
            }

            //lagrer verdiene i fila:
            int x = Integer.parseInt(figur[0]);
            int y = Integer.parseInt(figur[1]);
            int width = Integer.parseInt(figur[2]);
            int height = Integer.parseInt(figur[3]);


            //Oppretter retangel:
            Rectangle s = new Rectangle();
            s.setX(x);
            s.setY(y+PADDINGY);
            s.setWidth(width);
            s.setHeight(height);

            //bestemmer bakgrunnsfarge:
            if(figur.length == 5){
              if(figur[4].compareToIgnoreCase("red") == 0){
                s.setFill(Color.RED);
              }else if(figur[4].compareToIgnoreCase("blue") == 0){
                s.setFill(Color.BLUE);
              }else{
                s.setFill(Color.BLACK);
              }
            }else{
              s.setFill(Color.BLACK);
            }

            //legger til i pane'et
            pane.getChildren().add(s);
          }
        }

        //Oppretter sirkler:
        if(figur[1].equals("Circles")){

          while(sc.hasNextLine()){
            figur = sc.nextLine().split(" ");
            if(figur[0].equals("#")){
              break;
            }
            //lagrer verdier
            int x = Integer.parseInt(figur[0]);
            int y = Integer.parseInt(figur[1]);
            int radius = Integer.parseInt(figur[2]);

            //oppretter sirkler
            Circle s = new Circle();
            s.setCenterX((double)x);
            s.setCenterY((double)y + (double)PADDINGY);
            s.setRadius(radius);

            //bestemmer farge:
            if(figur.length == 4){
              if(figur[3].equalsIgnoreCase("red")){
                s.setFill(Color.RED);
              }else if(figur[3].equalsIgnoreCase("blue")){
                s.setFill(Color.BLUE);
              }else{
                s.setFill(Color.BLACK);
              }
            }else{
              s.setFill(Color.BLACK);
            }

            //lagrer sirkelen i pane'et
            pane.getChildren().add(s);
          }
        }
      }
    }

    //Lager ein horisontal boks med filvelger, filfelt og last inn-knapp
  private HBox lagToppBoks() {
        TextField filFelt = new TextField();
        velgFilKnapp = new Button("Velg fil...");
        Klikkbehandler klikk = new Klikkbehandler(filFelt);
        velgFilKnapp.setOnAction(klikk);
        lastInnKnapp = new Button("Last inn");
        lastInnKnapp.setOnAction(klikk);
        HBox returBoks = new HBox(50, velgFilKnapp, filFelt, lastInnKnapp);
        return returBoks;
      }


  @Override
  public void start(Stage stage){
    pane.getChildren().add(lagToppBoks());
    pane.setPrefSize(500,500);
    Scene scene = new Scene(pane);
    stage.setTitle("Bildeleser");
    stage.setScene(scene);
    stage.show();
  }


  //Klikkbehandler-klasse:
  class Klikkbehandler implements EventHandler<ActionEvent>{
    TextField filFelt;

    public Klikkbehandler(TextField filfelt){
      this.filFelt = filfelt;
    }
    public void handle(ActionEvent e){

      //Viss det er velgFilkKnapp som blir trykka på:
      if((Button)e.getSource() == velgFilKnapp){

        //lager ny filvelger:
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
              new ExtensionFilter("Text Files", "*.txt", "*.in"));
        fileChooser.setTitle("Velg tekstfil");
        File selectedFile = fileChooser.showOpenDialog(null);

        //Setter path'en til valgt fil inn i tekstfeltet
        if(selectedFile != null) {
            filFelt.setText(selectedFile.getPath());

          }
      }
      //Viss det er lastInnKnapp som blir trykka på:
      else if((Button)e.getSource() == lastInnKnapp){
        try{
          lesInn(new File(filFelt.getText()));
        }
        catch(FileNotFoundException fne){}
      }
      }
    }
}
