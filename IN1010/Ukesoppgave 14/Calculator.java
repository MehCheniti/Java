import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

public class Calculator extends Application {

	/* Trenger aa kunne hente ut disse i ButtonHandler */
	HBox textPane;
	TextField t1, t2;
	HBox buttonPane;
	TextField res;

	@Override
	public void start(Stage stage) {
		VBox rootPane = new VBox();

		textPane = new HBox();
		textPane.setAlignment(Pos.CENTER);

		t1 = new TextField("Number 1");
		t2 = new TextField("Number 2");

		textPane.getChildren().addAll(t1, t2);

		buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);

		Button plusB = new Button("+");
		Button minusB = new Button("-");
		Button multB = new Button("X");
		Button divB = new Button("/");

		buttonPane.getChildren().addAll(plusB, minusB, multB, divB);

		ButtonHandler btnH = new ButtonHandler();

		plusB.setOnAction(btnH);
		minusB.setOnAction(btnH);
		multB.setOnAction(btnH);
		divB.setOnAction(btnH);

		res = new TextField("Result");

		rootPane.getChildren().addAll(textPane, buttonPane, res);
		stage.setScene(new Scene(rootPane, 200, 100));
		stage.setTitle("My Calculator");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	// (Bedre?) alternativ -> 4 handlers
	class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			/* Finner ut hvilken knapp som har vært trykket */
			Button tmp = (Button) e.getSource();

			Double num1 = 0.0, num2 = 0.0;

			try {
				num1 = Double.parseDouble(t1.getText());
				num2 = Double.parseDouble(t2.getText());

			} catch (NumberFormatException nfe) {
				System.out.println("Those aren't numbers!");
				return;
			}

			String op = tmp.getText();

			double r = 0;

			switch (op) {
			case "+":
				r = num1 + num2;
				break;

			case "-":
				r = num1 - num2;
				break;

			case "X":
				r = num1 * num2;
				break;

			case "/":
				r = num1 / num2;
				break;

			}
			res.setText("" + r);
		}
	}
}
