package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class Grammar {

	private Hashtable<String,ArrayList<String>> grammar;
	
	public Grammar() {
		grammar= new Hashtable<>();
		
	}

	public Hashtable<String,ArrayList<String>> getGrammar() {
		return grammar;
	}
	
	
}
