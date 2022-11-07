package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.ControllerCYK;

public class CYKgui {
	private ControllerCYK control;

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField inputSymbols;

	@FXML
	private Spinner<Integer> statesSpinner;
	
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
		statesSpinner.setValueFactory(valueFactory);
	}
	
	@FXML
	void continueToScreen2(ActionEvent event) {

	}
	
	
    @FXML
    void getResult(ActionEvent event) {

    }
}
