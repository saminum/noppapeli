package noppapeli;



/**
* <code>NoppaPeli</code> luokka määrittää JFframe sisältöjen paikat ikkunassa ja tuo NoppaPeliin 
* toiminnollisuuden. Noppa haetaan Noppa luokasta.
* 
* @author Sami Nummela
* @version 0.1
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NoppaPeli extends JFrame implements ActionListener  {
	//Luodaan kaksi noppaa
	private Noppa noppa1 = new Noppa();
	private Noppa noppa2 = new Noppa();
	
	
	
	private static final long serialVersionUID = 1L;
	
	//Määritellään ikkunaan tulevat sisällöt
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JTextField text;
	private JButton button;
	
	
	public NoppaPeli() {
		super("Noppapeli");
		setLayout(null);
		text = new JTextField(20);
		text.setBounds(10, 50, 50,35);

		//Otsikko / peliohje
		label1 = new JLabel("");
		label1.setBounds(10, 10,400,35);
		label1.setText("Arvaa kahden nopan yhteenlaskettu silmäluku (2-12)");
		
		//Arvausnappula
		button = new JButton("Arvaa");
		button.setBounds(70, 50,120,35);
		
		//Arvasiko pelaaja oikein tai antoiko hän virheellisen vastauksen
		label2 = new JLabel("");
		label2.setBounds(10, 85,400,35);
		
		//Pelaajan vastaus
		label3 = new JLabel("");
		label3.setBounds(10, 120,400,35);
		
		//Heitettyjen noppien yhteistulos
		label4 = new JLabel("");
		label4.setBounds(10, 155,400,35);
		
		//Nopan 1 tulos
		label5 = new JLabel("");
		label5.setBounds(10, 190,400,35);
		
		//Nopan 2 tulos
		label6 = new JLabel("");
		label6.setBounds(10, 225,400,35);
		
		//Määritetään napille actionlistener
		button.addActionListener(this);
		
		//Lisätään sisällöt ikkunaan
		add(label1);
		add(text);
		add(button);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Luetaan syötetty teksti muuttujaan
		String input = text.getText();
		int vastaus;
		String virheIlmoitus = "Arvon tulee olla numero väliltä 2-12";
		HashMap<String, Integer> tulokset;
		
		// Tehdään erinäiset tarkistukset kuten: onko syötetty arvo numero ja oikealta väliltä
		try {
			vastaus = Integer.parseInt(input);
			if(vastaus>=2 && vastaus<=12){
				tulokset = pelaa();
				if(tulokset.get("yhteensa") == vastaus){
					input = "Arvasit oikein!";
				}else{
					input = "Arvasit väärin.";
				}
				label3.setText("Viimeisin arvauksesi: " + vastaus);
				label4.setText("Viimeksi heitettyjen noppien yhteistulos: " + tulokset.get("yhteensa"));
				label5.setText("Nopan 1 tulos: " + tulokset.get("noppa1"));
				label6.setText("Nopan 2 tulos: " + tulokset.get("noppa2"));
			}else{
				input = virheIlmoitus;
			}
		} catch (Exception e2) {
			input = virheIlmoitus;
		}
		label2.setText(input);
	
	}
	
	// Heitetään noppaa ja palautetaan tiedot HashMapissa
	private HashMap<String, Integer> pelaa() {
			noppa1.heita();
			noppa2.heita();
			
			HashMap<String,Integer> tulokset = new HashMap <String, Integer>();
			
			int noppienYhteistulos = noppa1.getSilmaluku() + noppa2.getSilmaluku();
			
			tulokset.put("noppa1",noppa1.getSilmaluku());
			tulokset.put("noppa2",noppa2.getSilmaluku());
			tulokset.put("yhteensa", noppienYhteistulos);
			
			return tulokset;
		}	
	}