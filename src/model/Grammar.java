package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Grammar {

	private Hashtable<String,ArrayList<String>> grammarHT; // estructura que almacena las producciones (value) de acuerdo con su variable asociada (key)
	private String initialVariable; //variable inicial de la gramatica
	private ArrayList<String> keys; // conjunto de variables de la gramatica
	
	public Grammar() {
		grammarHT= new Hashtable<>();
		keys= new ArrayList<String>();
	}
	
	public String getInitialVariable() {
		return initialVariable;
	}

	public void setInitialVariable(String initialVariable) {
		this.initialVariable = initialVariable;
	}
	
	/*
	 * addToGrammar permite agregar cada variable con sus producciones en la gramatica G
	 */
	public void addToGrammar(String variable, String productions) {
		ArrayList<String> p= new ArrayList<String> (Arrays.asList( productions.split("\\|")));
		keys.add(variable);
		grammarHT.put(variable, p);
	}
	
	/*
	 * SearchInGrammar permite buscar en las producciones de la gramatica para el algoritmo CYK
	 */
	public String SearchInGrammar(String value) {
		String key="";
		ArrayList<String> prod = new ArrayList<String>();
		for(int i=0;i<keys.size();i++) {
			prod=grammarHT.get(keys.get(i));
			for(int j=0;j<prod.size();j++) {
				if(value.equals(prod.get(j))) { //si encuentra el valor dentro de las producciones...
					key+=keys.get(i); //se agarra la(s) variable(s) que lo contiene
				}
			}
		}
		return key;
	}
}
