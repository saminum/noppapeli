package noppapeli;

/**
 * <code>Noppa</code> luokkaa k‰ytet‰‰n luomaan Noppaa. Noppaa heitt‰m‰ll‰ arvotaan jokin 
 * satunnainen luku v‰lilt‰ 1-6.
 * 
 * @author Sami Nummela
 * @version 0.1
 */

	import java.util.Random;

	public class Noppa {
		private int silmaLuku;
		
		public Noppa(){ 
			heita();
		}
		
		// Heit‰ noppaa arpoo luvun v‰lilt‰ 1-6
		public void heita(){
			Random r = new Random();
			this.silmaLuku=r.nextInt(6)+1;
		}
		
		// Saadaan palautettua heitetty silm‰luku
		public int getSilmaluku(){
			return this.silmaLuku;
		}
	}

