import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Minesveiper extends Application{

private final int STORRELSE = 10;

  public void start(Stage stage){
    GridPane root = new GridPane();
    Scene scene = new Scene(root);
    Rute[][] ruter = settOppBrett();

    for (int i = 0; i < STORRELSE; i++){
      for (int j = 0; j < STORRELSE; j++){
        root.add(ruter[i][j], j, i);
      }
    }

    stage.setScene(scene);
    stage.setTitle("Minesveiper");
    stage.show();
  }

  private Rute[][] settOppBrett(){
    Rute[][] ruter = new Rute[STORRELSE][STORRELSE];

    for (int i = 0; i < STORRELSE; i++){
      for (int j = 0; j < STORRELSE; j++){
        ruter[i][j] = new Rute();
      }
    }

    for (int i = 0; i < STORRELSE; i++){
      for (int j = 0; j < STORRELSE; j++){
        ArrayList<Rute> naboer = hentNaboer(i, j, ruter);
        ruter[i][j].settNaboer(naboer);
      }
    }

    return ruter;
  }

  private ArrayList<Rute> hentNaboer(int rad, int kol, Rute[][] ruter){
    ArrayList<Rute> naboer = new ArrayList<>();

    for (int i = rad - 1; i <= rad + 1; i++){
      for (int j = kol; j <= kol + 1; j++){
        boolean gyldig = true;
        if (i == rad && j == kol) gyldig = false;
        if (i < 0 || j < 0) gyldig = false;
        if (i >= STORRELSE || j >= STORRELSE) gyldig = false;
        if (gyldig) naboer.add(ruter[i][j]);
      }
    }

    return naboer;
  }

}
