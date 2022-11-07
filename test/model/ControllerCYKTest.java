package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ControllerCYKTest {
	
	private ControllerCYK control;
	
	public void setupScenary1() {
		String w="bbab";
		control= new ControllerCYK(w,4);
		control.setGrammarInitilVariable("S");
		control.addToGrammar("S", "BA|AC");
		control.addToGrammar("A", "CC|b");
		control.addToGrammar("B", "AB|a");
		control.addToGrammar("C", "BA|a");
	}
	
	public void setupScenary2() {
		String w="aab";
		control= new ControllerCYK(w,3);
		control.setGrammarInitilVariable("S");
		control.addToGrammar("S", "AB");
		control.addToGrammar("A", "AA|a");
		control.addToGrammar("B", "b");
	}
	
	public void setupScenary3() {
		String w="bca";
		control= new ControllerCYK(w,4);
		control.setGrammarInitilVariable("S");
		control.addToGrammar("S", "AB|BA");
		control.addToGrammar("A", "CA|a");
		control.addToGrammar("B", "BB|b");
		control.addToGrammar("C", "BA|c");
	}
	
	public void setupScenary4() {
		String w="aabb";
		control= new ControllerCYK(w,3);
		control.setGrammarInitilVariable("S");
		control.addToGrammar("S", "AB");
		control.addToGrammar("A", "AA|a");
		control.addToGrammar("B", "b");
	}
	
	public void setupScenary5() {
		String w="aaaa";
		control= new ControllerCYK(w,4);
		control.setGrammarInitilVariable("S");
		control.addToGrammar("S", "BA|AC");
		control.addToGrammar("A", "CC|b");
		control.addToGrammar("B", "AB|a");
		control.addToGrammar("C", "BA|a");
	}

	@Test
	public void test1() {
		setupScenary1();
		String message= "la cadena bbab pertenece a L(G)";
		String output=control.cykAlgorithm();
		assertEquals(message, output);
	}
	
	@Test
	public void test2() {
		setupScenary2();
		String message= "la cadena aab pertenece a L(G)";
		String output=control.cykAlgorithm();
		assertEquals(message, output);
	}

	@Test
	public void test3() {
		setupScenary3();
		String message= "la cadena bca pertenece a L(G)";
		String output=control.cykAlgorithm();
		assertEquals(message, output);
	}
	
	@Test
	public void test4() {
		setupScenary4();
		String message= "la cadena aabb NO pertenece a L(G)";
		String output=control.cykAlgorithm();
		assertEquals(message, output);
	}
	
	@Test
	public void test5() {
		setupScenary5();
		String message= "la cadena aaaa NO pertenece a L(G)";
		String output=control.cykAlgorithm();
		assertEquals(message, output);
	}
}
