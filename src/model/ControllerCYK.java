package model;

import java.util.ArrayList;

public class ControllerCYK {

	private Grammar grammar;
	private String[][] cykMatrix;
	private String stringW;
	
	private int numVariables;
	
	private ArrayList<CYKRow> cykRows;
	
	public ControllerCYK(String string, int integer) {
		grammar=new Grammar();
		stringW=string;
		
		numVariables=integer;
		cykRows= new ArrayList<>();
		
	}
	
	public ArrayList<CYKRow> getCykRows() {
		return cykRows;
	}

	public void initializeMatrix() {
		int sl= stringW.length();
		cykMatrix= new String[sl][sl];
		
		
		
	}
	
	public void setGrammarInitilVariable(String var) {
		grammar.setInitialVariable(var);
	}
	public void addToGrammar(String variable, String productions) {
		grammar.addToGrammar(variable, productions);
	}
	
	
	public void cykAlgorithm() {
		initializeMatrix();
		
		/*
		 * 
		 */
		
	}

	public int getNumVariables() {
		return numVariables;
	}
	
	public void createCYKRows() {
		for(int i=0; i<cykMatrix.length;i++) {
			CYKRow row= new CYKRow(cykMatrix[i]);
			
			cykRows.add(row);
		}
		
	}
}

