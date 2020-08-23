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
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

public class Hovedprogram extends Application{
  GridPane gp = new GridPane();
  static Skattekart skattekart = null;
  Text statusinfo;

    public static void main(String[] args) {
        try {
            File fil = new File(args[0]);
            skattekart = Skattekart.lesInn(fil);

        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
            System.exit(-1);
        }
        launch();

      }


      @Override
      public void start(Stage stage){
        gp.setGridLinesVisible(true);

        //Oppretter klikkbare buttons av skattekartet
        Klikkbehandler klikk = new Klikkbehandler();
        int teljar = 0;
        for(int i = 0; i<skattekart.bredde; i++){
          for(int j = 0; j<skattekart.hoyde; j++){
            Rute r = new Rute();
            r.setOnAction(klikk);
            gp.add(r, i, j);
          }
        }

        //Legg til infotekst:
        statusinfo = new Text("Finn skatten ved å trykke på de forskjellige rutene");
        statusinfo.setX(10); statusinfo.setY(230);

        //Lager pane
        Pane pane = new Pane();
        pane.setPrefSize(400,300);
        pane.getChildren().add(gp);
        pane.getChildren().add(statusinfo);

        //lager scene og starter staget
        Scene scene = new Scene(pane);
        stage.setTitle("Finn skatten");
        stage.setScene(scene);
        stage.show();
      }


      class Rute extends Button{
        //Oppretter button, velger bakgrunnsfarge, størrelse og ramme
        Rute(){
          setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
          setPrefSize(50,50);
          setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }

      }

      //Klikkbehandler
      class Klikkbehandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){

          if(!skattekart.sjekk(gp.getColumnIndex((Rute)e.getSource()), gp.getRowIndex((Rute)e.getSource()))){
            statusinfo.setText("Skatten var ikke der!");

            //henter button'en som ble klikka på
            Rute rute = (Rute)e.getSource();

            //Endrer fargen til rød
            rute.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
          }else{
            statusinfo.setText("DU FANT DEN!");

            //henter button'en som ble klikka på
            Rute rute = (Rute)e.getSource();

            //Endrer fargen til grønn
            rute.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
          }
        }
      }
}
