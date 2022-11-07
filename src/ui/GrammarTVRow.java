package ui;

import javafx.scene.control.TextField;

public class GrammarTVRow {

	private TextField variable;
	private char arrow;
	private TextField productions;
	
	public GrammarTVRow(){
		variable= new TextField();
		arrow='→';
		productions= new TextField();
		
	}

	public TextField getVariable() {
		return variable;
	}

	public char getArrow() {
		return arrow;
	}

	public TextField getProductions() {
		return productions;
	}
	
}
