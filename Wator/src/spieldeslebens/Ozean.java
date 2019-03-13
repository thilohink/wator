package spieldeslebens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ozean {

	public static final int WIDTH = 32;
	public static final int HEIGHT = 20;
	
	static Ozean instance = new Ozean();
	
	public static Ozean getInstance() {
		return instance;
	}
	
	private List<OzeanZelle> zellen;
	
	private Ozean() {
		this.zellen = new ArrayList<>(WIDTH*HEIGHT);
		for (int y=0; y<HEIGHT; y++) {
			for(int x=0; x<WIDTH; x++) {
				this.zellen.add(new OzeanZelle(x,y));
			}
		}
	}

	public void besetzeZelle(Teilnehmer typ, int x, int y) {
		OzeanZelle zelle = gibZelle(x, y);
		zelle.inhalt = typ;
		typ.setzeZelle(zelle);
	}

	public void besetzeZelleZufaellig(Teilnehmer typ) {
		Random generator = new Random();
		int zufallX = generator.nextInt(WIDTH);
		int zufallY = generator.nextInt(HEIGHT);
		besetzeZelle(typ, zufallX, zufallY);
		
	}
	
	/**
	 * 	  7 0 1
	 *    6 z 2
	 *    5 4 3
	 *    
	 * @param zelle
	 * @return
	 */
	List<OzeanZelle> gibNachbarZellen(OzeanZelle zelle) {
		List<OzeanZelle> result = new ArrayList<>();
		result.add(gibZelle(zelle.x,   zelle.y-1));
		result.add(gibZelle(zelle.x+1, zelle.y-1));
		result.add(gibZelle(zelle.x+1, zelle.y));
		result.add(gibZelle(zelle.x+1, zelle.y+1));
		result.add(gibZelle(zelle.x,   zelle.y+1));
		result.add(gibZelle(zelle.x-1, zelle.y+1));
		result.add(gibZelle(zelle.x-1, zelle.y));
		result.add(gibZelle(zelle.x-1, zelle.y-1));
		return result;
	}
	
	public OzeanZelle gibZelle(int x, int y) {
		OzeanZelle result = null;
		if (x<0)        x=WIDTH-1;
		if (x>WIDTH-1)  x=0;
		if (y<0)        y=HEIGHT-1;
		if (y>HEIGHT-1) y=0;
		int index = WIDTH * y + x;
		result = this.zellen.get(index);
		return result;
	}
	
	/**
	 * Die richtung ist zwar ein Winkel, geht aber so
	 * 
	 *    7 0 1
	 *    6 z 2
	 *    5 4 3
	 * 
	 * wobei z in der Mitte die gegebene Zelle ist.
	 *    
	 * @param richtung
	 * @param zelle
	 * @return
	 */
	public OzeanZelle gibZelle(int richtung, OzeanZelle zelle) {
		OzeanZelle result = null;
		List<OzeanZelle> nachbarn = gibNachbarZellen(zelle);
		result = nachbarn.get(richtung);
		return result;
	}
	
}
