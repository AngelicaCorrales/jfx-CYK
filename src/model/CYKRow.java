package model;


import java.util.ArrayList;
import java.util.Arrays;

public class CYKRow {

	ArrayList<String> variables;
	
	public CYKRow(String[] row) {
		
		variables= (ArrayList<String>) Arrays.asList(row);
	}

	public ArrayList<String> getVariables() {
		return variables;
	}

	
}
