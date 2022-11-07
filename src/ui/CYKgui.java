package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import model.ControllerCYK;

public class CYKgui {
	private ControllerCYK control;

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField stringW;

	@FXML
	private Spinner<Integer> variablesSpinner;
	
	@FXML
    private TableColumn<?, ?> colArrow;

    @FXML
    private TableColumn<?, ?> colProductions;

    @FXML
    private TableColumn<?, ?> colVariable;

    @FXML
    private TableView<?> tvGrammar;


	public CYKgui(ControllerCYK c) {
		control=c;
	}

	public void showWelcomeWindow() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/screen1.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/background.jpeg)");
		SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 26, 1);
		variablesSpinner.setValueFactory(valueFactory);
	}
	
	@FXML
	public void continueToScreen2(ActionEvent event) throws IOException {
		if(!stringW.getText().equals("")) {
			control = new ControllerCYK(stringW.getText(), variablesSpinner.getValue());

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/screen2.fxml"));
			fxmlLoader.setController(this);
			Parent menuPane = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(menuPane);
			mainPane.setStyle("-fx-background-image: url(/ui/background.jpeg)");
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Debe completar cada uno de los campos indicados para continuar.");
			alert.showAndWait();
		}
	}
	
	
    @FXML
    void getResult(ActionEvent event) {

    }
}
