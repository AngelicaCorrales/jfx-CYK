package model;


public class ControllerCYK {

	private Grammar grammar;
	private String[][] cykMatrix;
	private String stringW;
	
	private int numVariables;
	
	public ControllerCYK(String string, int integer) {
		grammar=new Grammar();
		stringW=string;
		
		numVariables=integer;
		
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
}

