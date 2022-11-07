package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Grammar {

	private Hashtable<String,ArrayList<String>> grammarHT;
	private String initialVariable;
	
	public Grammar() {
		grammarHT= new Hashtable<>();
		
	}
	
	public void addToGrammar(String variable, String productions) {
		ArrayList<String> p= (ArrayList<String>) Arrays.asList( productions.split("|"));
		
		grammarHT.put(variable, p);
	}

	public Hashtable<String,ArrayList<String>> getGrammar() {
		return grammarHT;
	}

	public String getInitialVariable() {
		return initialVariable;
	}

	public void setInitialVariable(String initialVariable) {
		this.initialVariable = initialVariable;
	}
	
	
}
