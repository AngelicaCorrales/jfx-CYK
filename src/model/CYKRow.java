package model;


import java.util.ArrayList;
import java.util.Arrays;

public class CYKRow {

	ArrayList<String> variables;
	
	public CYKRow(String[] row) {
		variables= new ArrayList<String> (Arrays.asList(row));
		for(int i=0;i<variables.size();i++) {
			if(variables.get(i)!=null && !variables.get(i).equals("{ }")) {
				String var="";
				for(int k=0;k<variables.get(i).length();k++) {
					if(k!=variables.get(i).length()-1) {
						var+=variables.get(i).charAt(k)+",";
					}else {
						var+=variables.get(i).charAt(k);
					}
				}
				variables.set(i, "{"+var+"}");
			}
		}
	}

	public ArrayList<String> getVariables() {
		return variables;
	}

}
