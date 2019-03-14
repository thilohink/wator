package spieldeslebens.raumundzeit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import spieldeslebens.materie.Materie;

public class Ozean {

	public static final int BREITE_DES_OZEAN_ZELL_RASTERS = 32;
	public static final int HOHE_DES_OZEAN_ZELL_RASTERS = 20;
	
	static Ozean instanz = new Ozean();
	
	public static Ozean gibInstanz() {
		return instanz;
	}
	
	private List<OzeanZelle> ozeanZellen;
	
	private Ozean() {
		this.ozeanZellen = new ArrayList<>();
		for (int zeile=0; zeile<HOHE_DES_OZEAN_ZELL_RASTERS; zeile++) {
			for(int spalte=0; spalte<BREITE_DES_OZEAN_ZELL_RASTERS; spalte++) {
				this.ozeanZellen.add(new OzeanZelle(spalte, zeile));
			}
		}
	}

	public void besetzeZelleMitMaterieAnSpalteUndZeile(Materie materie, int spalte, int zeile) {
		OzeanZelle zelle = ermittleOzeanZelleMitSpalteUndZeile(spalte, zeile);
		zelle.inhalt = materie;
		materie.setzeZelle(zelle);
	}

	public void besetzeZelleMitMaterieAnZufaelligerPosition(Materie materie) {
		Random generator = new Random();
		int spalteZufaellig = generator.nextInt(BREITE_DES_OZEAN_ZELL_RASTERS);
		int zeileZufaellig = generator.nextInt(HOHE_DES_OZEAN_ZELL_RASTERS);
		besetzeZelleMitMaterieAnSpalteUndZeile(materie, spalteZufaellig, zeileZufaellig);
		
	}
	
	/**
	 * 	  7 0 1
	 *    6 z 2
	 *    5 4 3
	 *    
	 * @param zelle
	 * @return
	 */
	List<OzeanZelle> ermittleAlleNachbarZellenEinerOzeanZelle(OzeanZelle zelle) {
		List<OzeanZelle> nachbarZellen = new ArrayList<>();
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x,   zelle.y-1));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x+1, zelle.y-1));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x+1, zelle.y));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x+1, zelle.y+1));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x,   zelle.y+1));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x-1, zelle.y+1));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x-1, zelle.y));
		nachbarZellen.add(ermittleOzeanZelleMitSpalteUndZeile(zelle.x-1, zelle.y-1));
		return nachbarZellen;
	}
	
	public OzeanZelle ermittleOzeanZelleMitSpalteUndZeile(int spalte, int zeile) {
		OzeanZelle ozeanZelle = null;
		if (spalte<0)                                spalte=BREITE_DES_OZEAN_ZELL_RASTERS-1;
		if (spalte>BREITE_DES_OZEAN_ZELL_RASTERS-1)  spalte=0;
		if (zeile<0)                                 zeile=HOHE_DES_OZEAN_ZELL_RASTERS-1;
		if (zeile>HOHE_DES_OZEAN_ZELL_RASTERS-1)     zeile=0;
		int index = BREITE_DES_OZEAN_ZELL_RASTERS * zeile + spalte;
		ozeanZelle = this.ozeanZellen.get(index);
		return ozeanZelle;
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
	public OzeanZelle ermittleNachbarZelleEinerOzeanZelleInRichtung(int richtung, OzeanZelle ozeanZelle) {
		OzeanZelle nachbarZelle = null;
		List<OzeanZelle> alleNachbarn = ermittleAlleNachbarZellenEinerOzeanZelle(ozeanZelle);
		nachbarZelle = alleNachbarn.get(richtung);
		return nachbarZelle;
	}
	
}
