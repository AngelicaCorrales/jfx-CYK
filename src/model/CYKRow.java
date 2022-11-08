package model;


import java.util.ArrayList;
import java.util.Arrays;

public class CYKRow {

	private ArrayList<String> XijRow;
	
	/*
	 * CYKRow es una fila de la tabla resultante al aplicar el algoritmo CYK con la cadena y gramatica dada
	 */
	public CYKRow(String[] row) {
		XijRow= new ArrayList<String> (Arrays.asList(row));
		for(int i=0;i<XijRow.size();i++) {
			if(XijRow.get(i)!=null && !XijRow.get(i).equals("{ }")) {
				String var="";
				for(int k=0;k<XijRow.get(i).length();k++) {
					if(k!=XijRow.get(i).length()-1) {
						var+=XijRow.get(i).charAt(k)+",";
					}else {
						var+=XijRow.get(i).charAt(k);
					}
				}
				XijRow.set(i, "{"+var+"}");
			}
		}
	}

	public ArrayList<String> getXijRow() {
		return XijRow;
	}

}
