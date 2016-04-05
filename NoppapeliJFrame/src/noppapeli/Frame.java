package noppapeli;

/**
* <code>Frame</code> luokka toimii NoppaPelin main luokkana. Luokasta kutsutaan NoppaPeli luokkaa.
* 
* @author Sami Nummela
* @version 0.1
*/

import javax.swing.*;

public class Frame {

	public static void main(String[] args) {
		
		// Luodaan uusi noppapeli
		NoppaPeli peli = new NoppaPeli();
		peli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		peli.setSize(400,300);
		peli.setVisible(true);
		peli.setResizable(false);
		
		
	}
	
}
