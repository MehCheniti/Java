import java.io.*;
import java.util.*;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class Oblig7 extends Application{

Labyrint labyrint = null;
GridPane gridpane;
int rader;
int kolonner;
int utveier;
ArrayList<Vei> krysset = new ArrayList<Vei>();
Lenkeliste<String> utvei = null;

  public static void main(String[] args){
    launch(args);
  }

  @Override public void start(Stage stage) throws Exception{
    // Gir muligheten til å velge en fil.
    File fil = new FileChooser().showOpenDialog(stage);
    try{
      Scanner f = new Scanner(fil);
      labyrint = Labyrint.lesFraFil(fil);
    } catch (FileNotFoundException e) {}

    // Henter brettet og går gjennom den for å bestemme hva rutene skal gjøre.
    Rute[][] rute = labyrint.hentToDArray();
    rader = rute.length;
    kolonner = rute[0].length;
    Trykk trykk = new Trykk();
    gridpane = new GridPane();
    gridpane.setGridLinesVisible(true);

    for (int i = 0; i < rader; i++){
      for (int j = 0; j < kolonner; j++){
        if (rute[i][j].tilTegn() == '.'){
          Vei ruter = new Vei(i, j);
          gridpane.add(ruter, j, i);
          ruter.setOnAction(trykk);
        } else{
          Rectangle rectangle = new Rectangle(17, 34);
          gridpane.add(rectangle, j, i);
        }
      }
    }

    // Setter tittelen til "Labyrint".
    stage.setTitle("Labyrint");

    // Lager en layout.
    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(gridpane);

    // Lager innholdet til interfacet og viser det.
    Scene scene = new Scene(stackPane, 340, 170);
    stage.setScene(scene);
    stage.show();
  }

  public void losning(int lab){
    boolean[][] losning = losningStringTilTabell(utvei.hent(lab), kolonner,
    rader);

    for (Vei i : krysset){
      i.clear();
    }

    krysset = new ArrayList<Vei>();

    for (int i = 0; i < rader; i++){
      for (int j = 0; j < kolonner; j++){
        if (losning[i][j]){
          Vei vei = (Vei)gridpane.getChildren().get(1 + kolonner * i + j);
          vei.kryss('X');
          krysset.add(vei);
        }
      }
    }
  }

  class Trykk implements EventHandler<ActionEvent>{
    // Gir tilgang til labyrinten.
    @Override public void handle(ActionEvent actionEvent){
      Vei vei = (Vei)actionEvent.getSource();
      int rad = vei.rad;
      int kolonne = vei.kolonne;
      utvei = labyrint.finnUtveiFra(vei.rad, vei.kolonne);
      utveier = utvei.stoerrelse();

      if (utveier == 0){
        for (Vei j : krysset){
          j.clear();
        }
        krysset = new ArrayList<Vei>();
      } else{
        losning(0);
      }
    }
  }

  /**
 * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
 * av losningstien.
 * @param losningString String-representasjon av utveien
 * @param bredde        bredde til labyrinten
 * @param hoyde         hoyde til labyrinten
 * @return              2D-representasjon av rutene der true indikerer at
 *                      ruten er en del av utveien.
 */
static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
    boolean[][] losning = new boolean[hoyde][bredde];
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
    java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
    while (m.find()) {
        int x = Integer.parseInt(m.group(1));
        int y = Integer.parseInt(m.group(2));
        losning[y][x] = true;
    }
    return losning;
}
}

class Vei extends Button{

char cha = ' ';
int rad;
int kolonne;

  public Vei(int kolonne, int rad){
    super(" ");
    this.kolonne = kolonne;
    this.rad = rad;
  }

  public void kryss(char c){
    cha = c;
    setText(" " + c);
  }

  public void clear(){
    cha = ' ';
    setText(" ");
  }

}
