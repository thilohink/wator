package wator;

import java.util.ArrayList;
import java.util.List;

public class Ozean {

	public static final int WIDTH = 40;
	public static final int HEIGHT = 25;
	
	static Ozean instance = new Ozean();
	
	public static Ozean getInstance() {
		return instance;
	}
	
	private List<Zelle> zellen;
	
	private Ozean() {
		this.zellen = new ArrayList<>(WIDTH*HEIGHT);
		for (int y=0; y<HEIGHT; y++) {
			for(int x=0; x<WIDTH; x++) {
				this.zellen.add(new Zelle(x,y));
			}
		}
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
	public Zelle gibZelle(int richtung, Zelle zelle) {
		Zelle result = null;
		List<Zelle> nachbarn = gibNachbarZellen(zelle);
		result = nachbarn.get(richtung);
		return result;
	}
	
	public Zelle gibZelle(int x, int y) {
		Zelle result = null;
		if (x<0)        x=WIDTH-1;
		if (x>WIDTH-1)  x=0;
		if (y<0)        y=HEIGHT-1;
		if (y>HEIGHT-1) y=0;
		int index = WIDTH * y + x;
		result = this.zellen.get(index);
		return result;
	}
	
	/**
	 * 	  7 0 1
	 *    6 z 2
	 *    5 4 3
	 *    
	 * @param zelle
	 * @return
	 */
	List<Zelle> gibNachbarZellen(Zelle zelle) {
		List<Zelle> result = new ArrayList<>();
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
	
}
