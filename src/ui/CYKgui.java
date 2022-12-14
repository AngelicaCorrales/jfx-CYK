package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import model.CYKRow;
import model.ControllerCYK;

public class CYKgui {

	private ControllerCYK control;
	private ArrayList<GrammarTVRow> grammarRows;
	
	@FXML
	private BorderPane mainPane;
	
	//---Screen 1 -----------
	@FXML
	private TextField stringW;

	@FXML
	private Spinner<Integer> variablesSpinner;
	
	//---Screen 2 -----------
	@FXML
    private TableColumn<GrammarTVRow, Character> colArrow;

    @FXML
    private TableColumn<GrammarTVRow, TextField> colProductions;

    @FXML
    private TableColumn<GrammarTVRow, TextField> colVariable;

    @FXML
    private TableView<GrammarTVRow> tvGrammar;
	
	//---Screen 3 -----------
	@FXML
	private Label message;

	@FXML
	private TableView<CYKRow> tvResults;

	
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
			
			initializeTableViewGrammar();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Debe completar cada uno de los campos indicados para continuar.");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void startAgain(ActionEvent event) throws IOException {
		showWelcomeWindow();
	}	

    @FXML
    void getResult(ActionEvent event) throws IOException {
    	if(valuesMissingGrammar()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de validacion");
			alert.setHeaderText(null);
			alert.setContentText("Por favor, llene todos los campos de la gramatica");
			alert.showAndWait();
		}else {
			createGrammar();
			String m=control.cykAlgorithm();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/screen3.fxml"));
			fxmlLoader.setController(this);
			Parent menuPane = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(menuPane);
			mainPane.setStyle("-fx-background-image: url(/ui/background.jpeg)");
			
			message.setText(m);
			initializeTableViewCYK();
		}

    }
    
    
    
    public void initializeTableViewGrammar() {
    	initializeRowsTableViewGrammar();
    	
    	ObservableList<GrammarTVRow> observableList= FXCollections.observableArrayList(grammarRows);
    	tvGrammar.setItems(observableList);
    	
    	colVariable.setCellValueFactory(new PropertyValueFactory<GrammarTVRow, TextField>("Variable"));
    	colArrow.setCellValueFactory(new PropertyValueFactory<GrammarTVRow, Character>("Arrow"));
    	colProductions.setCellValueFactory(new PropertyValueFactory<GrammarTVRow, TextField>("Productions"));
    }
    
    public void initializeRowsTableViewGrammar() {
    	grammarRows= new ArrayList<GrammarTVRow>();
		for(int i=0; i<control.getNumVariables();i++) {
			GrammarTVRow row=new GrammarTVRow();			
			grammarRows.add(row);		
		}
	}
    
    public boolean valuesMissingGrammar() {
		boolean exit=false;
		for(int i=0;i<grammarRows.size() && !exit;i++) {
			if(grammarRows.get(i).getVariable().getText().isEmpty()) {
				exit=true; //salir si el valor de la variable es vacio
			}
			
			if(grammarRows.get(i).getProductions().getText().isEmpty()) {
				exit=true; //salir si el valor de las producciones es vacio
			}
			
		}

		return exit;
	}
  
    /*
     *  createGrammar permite crear la gramatica G en FNC con:
     *  las variables dadas y sus producciones
     */
    public void createGrammar() {
    	for(int i=0; i<grammarRows.size();i++) {
    		if (i==0) {
    			control.setGrammarInitilVariable(grammarRows.get(i).getVariable().getText());
    		}
    		
    		control.addToGrammar(grammarRows.get(i).getVariable().getText(), grammarRows.get(i).getProductions().getText());
    	}
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void initializeTableViewCYK() {
    	control.createCYKRows();
    	addColumnsCYK();
    	
    	ObservableList<CYKRow> observableList= FXCollections.observableArrayList(control.getCykRows());
    	tvResults.setItems(observableList);
    	
    	int j=0;
    	
    	for(int i=0; i<tvResults.getColumns().size();i++) {
			final int  num=j;
			tvResults.getColumns().get(i).setCellValueFactory(cellData -> new SimpleObjectProperty((cellData.getValue().getXijRow().get(num))));			
			j++;
		}
    	
    }
    
    public void addColumnsCYK() {	

    	for(int i=0; i<control.getCykRows().size();i++) {
    		tvResults.getColumns().add(new TableColumn<CYKRow, String>("j="+(i+1)));
    	}
    }

}
