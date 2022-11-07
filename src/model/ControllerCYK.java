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
		String keys="";
		for(int i=0;i<stringW.length();i++) {
			keys=grammar.SearchInGrammar(stringW.charAt(i)+"");
			cykMatrix[i][0]=keys;
		}
	}
	
	public void setGrammarInitilVariable(String var) {
		grammar.setInitialVariable(var);
	}
	public void addToGrammar(String variable, String productions) {
		grammar.addToGrammar(variable, productions);
	}
	
	
	public String cykAlgorithm() {
		
		//INICIALIZAR
		String message="";
		initializeMatrix();
		
		
		//REPETIR HASTA j=n(StringW.length())
		repeatCYKAlgorithm();
		
		
		//SALIDA
		if(cykMatrix[1][stringW.length()-1].contains(grammar.getInitialVariable())) {
			message="la cadena"+stringW+"pertenece a L(G)";
		}else {
			message="la cadena"+stringW+"NO pertenece a L(G)";
		}
		
		return message;
	}
	
	public void repeatCYKAlgorithm() {
		for(int j=1;j<stringW.length();j++) {
			for(int i=0;i<stringW.length()-j;i++) {
				String aux1="";
				String aux2="";
				cykMatrix[i][j]="";
				for(int k=0;k<j;k++) {
					for(int l=0;l<cykMatrix[i][k].length();l++) {
						for(int m=0;m<cykMatrix[i+k][j-k].length();m++) {
							aux1=cykMatrix[i][k].charAt(l)+""+cykMatrix[i+k][j-k].charAt(m);
							aux2=grammar.SearchInGrammar(aux1);
							if(!cykMatrix[i][j].contains(aux2)) {
								cykMatrix[i][j]+=aux2;
							}
						}
					}
				}
				
			}
		}
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

