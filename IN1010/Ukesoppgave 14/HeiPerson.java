import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class HeiPerson extends Application {

    public TextField tekstfelt = null;

	@Override
	public void start (Stage stage) {
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);

        Label merkelapp = new Label("Fyll inn navn:");
		tekstfelt = new TextField("Navn");

        Button knapp = new Button("Si hei!");
        Knappebehandler behandler = new Knappebehandler();
		knapp.setOnAction(behandler);

		Label hilsen = new Label("");

		pane.getChildren().addAll(merkelapp, tekstfelt, knapp, hilsen);
		stage.setScene(new Scene(pane, 200, 100));
		stage.show();
	}

	public static void main(String[] args) {
		launch (args);
	}


    class Knappebehandler implements EventHandler <ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
           String hilsetekst = tekstfelt.getText();
           hilsen.setText(String.format("Hei paa deg, %s!", hilsetekst));

        }
    }
}
