package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.ControllerCYK;

public class Main extends Application{

	private ControllerCYK control;
	private CYKgui gui;

	public Main() {
		gui= new CYKgui(control);	
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPane.fxml"));

		fxmlLoader.setController(gui);
		Parent root= fxmlLoader.load();

		Scene scene= new Scene(root);

		primaryStage.setScene(scene);
		//primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ui/iconexe.png")));
		primaryStage.setTitle("!Algoritmo CYK!");
		primaryStage.show();
		gui.showWelcomeWindow();
	}

}


