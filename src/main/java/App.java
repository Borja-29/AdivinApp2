import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private Label label;
	private Button button;
	private TextField textField;
	private VBox root;

	int aleatorio = (int) Math.floor(Math.random() * 100 + 1);
	int contador = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		label = new Label();
		label.setText("Introduce un número del 1 al 100");

		textField = new TextField();
		textField.setMaxWidth(100);
		textField.setAlignment(Pos.CENTER);

		button = new Button("Comprobar");
		button.setOnAction(e -> onComprobarAction(e));

		root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(label, textField, button);

		Scene scene = new Scene(root, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();
	}

	private void onComprobarAction(ActionEvent e) {
		contador++;
		try {
			int a = Integer.parseInt(textField.getText());
			if (a >= 1 && a <= 100) {
				if (a == aleatorio) {
					aleatorio = (int) Math.floor(Math.random() * 100 + 1);
					Alert aciertoAlerta = new Alert(AlertType.INFORMATION);
					aciertoAlerta.setTitle("AdivinApp");
					aciertoAlerta.setHeaderText("¡Has Ganado!");
					aciertoAlerta.setContentText(
							"Solo has necesitado " + contador + " intentos.\n\n Vuelve a jugar y hazlo mejor.");
					aciertoAlerta.showAndWait();
					contador = 0;

				} else {
					Alert falloAlerta = new Alert(AlertType.WARNING);
					falloAlerta.setTitle("AdivinApp");
					falloAlerta.setHeaderText("¡Has fallado!");
					if (a < aleatorio)
						falloAlerta.setContentText(
								"El número a adivinar es mayor que " + a + ".\n\n Vuelve a intentarlo.");
					else
						falloAlerta.setContentText(
								"El número a adivinar es menor que " + a + ".\n\n Vuelve a intentarlo.");
					falloAlerta.showAndWait();
				}
			} else {
				Alert errorAlerta = new Alert(AlertType.ERROR);
				errorAlerta.setTitle("AdivinApp");
				errorAlerta.setHeaderText("Error");
				errorAlerta.setContentText("El número introducido no es válido.");
				errorAlerta.showAndWait();
			}
		} catch (Exception f) {
			Alert errorAlerta = new Alert(AlertType.ERROR);
			errorAlerta.setTitle("AdivinApp");
			errorAlerta.setHeaderText("Error");
			errorAlerta.setContentText("El número introducido no es válido.");
			errorAlerta.showAndWait();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}