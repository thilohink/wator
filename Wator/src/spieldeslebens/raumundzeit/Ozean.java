package spieldeslebens.raumundzeit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import spieldeslebens.materie.Materie;

/**
 * Der Ozean ist ein Singleton, da er von aktiver Materie
 * zur Ermittlung von OzeanZellen befragt wird. 
 *
 */
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
	}

	public void fluteMitWasser() {
		for (int zeile=0; zeile<HOHE_DES_OZEAN_ZELL_RASTERS; zeile++) {
			for(int spalte=0; spalte<BREITE_DES_OZEAN_ZELL_RASTERS; spalte++) {
				OzeanZelle ozeanZelle = new OzeanZelle(spalte, zeile);
				ozeanZelle.fluteMitWasser();
				this.ozeanZellen.add(ozeanZelle);
			}
		}
	}
	
	public void besetzeOzeanZelleMitMaterieAnZufaelligerPosition(Materie materie) {
		Random generator = new Random();
		int spalteZufaellig = generator.nextInt(BREITE_DES_OZEAN_ZELL_RASTERS);
		int zeileZufaellig = generator.nextInt(HOHE_DES_OZEAN_ZELL_RASTERS);

		OzeanZelle zelle = ermittleOzeanZelleMitKoordinaten(spalteZufaellig, zeileZufaellig);
		zelle.inhalt = materie;
		materie.setzeZelle(zelle);
	}

	/**
	 * 	  7 0 1
	 *    6 z 2
	 *    5 4 3
	 *    
	 * @param basisZelle
	 * @return
	 */
	private List<OzeanZelle> ermittleAlleNachbarZellenEinerOzeanZelle(OzeanZelle basisZelle) {
		List<OzeanZelle> nachbarZellen = new ArrayList<>();
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte,   basisZelle.zeile-1));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte+1, basisZelle.zeile-1));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte+1, basisZelle.zeile));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte+1, basisZelle.zeile+1));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte,   basisZelle.zeile+1));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte-1, basisZelle.zeile+1));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte-1, basisZelle.zeile));
		nachbarZellen.add(ermittleOzeanZelleMitKoordinaten(basisZelle.spalte-1, basisZelle.zeile-1));
		return nachbarZellen;
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
	public OzeanZelle ermittleNachbarZelleEinerOzeanZelleInEinerRichtung(OzeanZelle basisZelle, int richtung) {
		OzeanZelle nachbarZelle = null;
		List<OzeanZelle> alleNachbarn = ermittleAlleNachbarZellenEinerOzeanZelle(basisZelle);
		nachbarZelle = alleNachbarn.get(richtung);
		return nachbarZelle;
	}

	public OzeanZelle ermittleOzeanZelleMitKoordinaten(int spalte, int zeile) {
		OzeanZelle ozeanZelle = null;
		int ozeanZellenIndex = transformiereKoordinatenAufOzeanZellenIndex(spalte, zeile); 
		ozeanZelle = ozeanZellen.get(ozeanZellenIndex);
		return ozeanZelle;
	}
	
	public OzeanZelle sucheNachbarZelleMitInhalt(String artDesInhalts, OzeanZelle basisZelle) {
		OzeanZelle nachbarZelleMitInhalt = null;
		List<OzeanZelle> nachbarZellen = ermittleAlleNachbarZellenEinerOzeanZelle(basisZelle);
		for(OzeanZelle nachbar: nachbarZellen) {
			if(artDesInhalts.equals(nachbar.gibInhalt().gibArtDerMaterie())) {
				nachbarZelleMitInhalt = nachbar;
				break;
			}
		}
		return nachbarZelleMitInhalt;
	}
	
	private int transformiereKoordinatenAufOzeanZellenIndex(int spalte, int zeile) {
		spalte = transformiereSpalteAufTorusRaster(spalte);
		zeile = transformiereZeileAufTorusRaster(zeile);

		int index = BREITE_DES_OZEAN_ZELL_RASTERS * zeile + spalte;
		return index;
	}
	
	private int transformiereSpalteAufTorusRaster(int spalte) {
		if (spalte<0) {
			spalte=BREITE_DES_OZEAN_ZELL_RASTERS-1;
		}
		if (spalte>BREITE_DES_OZEAN_ZELL_RASTERS-1) {
			spalte=0;
		}
		return spalte;
	}
	
	private int transformiereZeileAufTorusRaster(int zeile) {
		if (zeile<0) {
			zeile=HOHE_DES_OZEAN_ZELL_RASTERS-1;
		}
		if (zeile>HOHE_DES_OZEAN_ZELL_RASTERS-1) {
			zeile=0;
		}
		return zeile;
	}
	
}
