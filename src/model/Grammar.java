package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Grammar {

	private Hashtable<String,ArrayList<String>> grammarHT;
	private String initialVariable;
	private ArrayList<String> keys;
	
	public Grammar() {
		grammarHT= new Hashtable<>();
		keys= new ArrayList<String>();
	}
	
	public void addToGrammar(String variable, String productions) {
		ArrayList<String> p= new ArrayList<String> (Arrays.asList( productions.split("\\|")));
		keys.add(variable);
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
	
	public String SearchInGrammar(String value) {
		String key="";
		ArrayList<String> prod = new ArrayList<String>();
		for(int i=0;i<keys.size();i++) {
			prod=grammarHT.get(keys.get(i));
			for(int j=0;j<prod.size();j++) {
				if(value.equals(prod.get(j))) {
					key+=keys.get(i);
				}
			}
		}
		return key;
	}
}
