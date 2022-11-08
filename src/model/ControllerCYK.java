package model;

import java.util.ArrayList;

public class ControllerCYK {

	private Grammar grammar; //gramatica G en FNC
	private String[][] cykMatrix; // matrix para la tabla resultante de aplicar el algoritmo cyk
	private String stringW; // cadena w
	
	private int numVariables; //numero de variables de la gramatica G
	
	private ArrayList<CYKRow> cykRows; //filas para la tabla cyk
	
	public ControllerCYK(String string, int integer) {
		grammar=new Grammar();
		stringW=string;
		
		numVariables=integer;
		cykRows= new ArrayList<>();
		
	}
	
	public int getNumVariables() {
		return numVariables;
	}
	
	public ArrayList<CYKRow> getCykRows() {
		return cykRows;
	}

	public void setGrammarInitilVariable(String var) {
		grammar.setInitialVariable(var);
	}
	
	/*
	 * addToGrammar permite agregar cada variable con sus producciones en la gramatica G
	 */
	public void addToGrammar(String variable, String productions) {
		grammar.addToGrammar(variable, productions);
	}
	
	/* 
	 * cykAlgorithm devuelve un mensaje que indica si la cadena w
	 * pertenece al lenguaje de la gramatica L(G) o no
	 */
	public String cykAlgorithm() {
		
		//INICIALIZAR
		String message="";
		initializeMatrix();
		
		
		//REPETIR HASTA j=n
		repeatCYKAlgorithm();
		
		
		//SALIDA
		if(cykMatrix[0][stringW.length()-1].contains(grammar.getInitialVariable())) {
			message="La cadena "+stringW+" pertenece a L(G)";
		}else {
			message="La cadena "+stringW+" NO pertenece a L(G)";
		}
		
		return message;
	}
	
	/*  
	 * initializeMatrix realiza el paso de INICIALIZAR del algortimo CYK
	 */
	public void initializeMatrix() {
		int sl= stringW.length();
		cykMatrix= new String[sl][sl];
		String keys="";
		for(int i=0;i<stringW.length();i++) { //j = 1: Para cada i; 1<= i<= n
			keys=grammar.SearchInGrammar(stringW.charAt(i)+"");
			cykMatrix[i][0]=keys; //Xij = Xi1 := conjunto de variables A tales que A-> ai
		}
	}
	
	/*
	 * repeatCYKAlgorithm realiza el paso de REPETIR del algortimo CYK
	 */
	public void repeatCYKAlgorithm() {
		for(int j=1;j<stringW.length();j++) { //j := j + 1:
			for(int i=0;i<stringW.length()-j;i++) {//Para cada i, 1 <=i <= n-j + 1
				String aux1="";
				String aux2="";
				cykMatrix[i][j]="";
				for(int k=0;k<j;k++) {//1 <= k < j - 1
					for(int l=0;l<cykMatrix[i][k].length();l++) {
						for(int m=0;m<cykMatrix[i+k+1][j-k-1].length();m++) {
							aux1=cykMatrix[i][k].charAt(l)+""+cykMatrix[i+k+1][j-k-1].charAt(m);// Xik Xi+k,j-k
							aux2=grammar.SearchInGrammar(aux1);  //se busca en la gramatica la produccion 
							for(int n=0;n<aux2.length();n++) {
								if(!cykMatrix[i][j].contains(aux2.charAt(n)+"")) {
									cykMatrix[i][j]+=aux2.charAt(n);//Xij := conjunto de variables A tales que A-> BC es una produccion de G, con B perteneciente a Xik y C perteneciente a Xi+k,j-k, considerando todos los k
								}
							}
						}
					}
				}
				if(cykMatrix[i][j].isEmpty()) {
					cykMatrix[i][j]="{ }";
				}
			}
		}
	}
	
	/* 
	 * createCYKRows permite crear la lista de las filas de la tabla resultante del algoritmo CYK
	 */
	public void createCYKRows() {
		for(int i=0; i<cykMatrix.length;i++) {
			CYKRow row= new CYKRow(cykMatrix[i]);
			
			cykRows.add(row);
		}
		
	}
}

