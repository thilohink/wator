package de.unilog.hkw.ofen;

import de.unilog.hkw.util.*;
import java.util.*;

public class OfenController {
	
	private static final int STANDARD_IST_TEMPERATUR = 20;
	private static final int STANDARD_SOLL_TEMPERATUR = 100;
	private static final int STANDARD_KUEHL_TEMPERATUR = 30;

	protected int initSollTemperatur;
	protected int initIstTemperatur;
	protected int initKuehlTemperatur;

	private Ofen ofen;
	private Map<String, String> brennElementTypSpezifikationen;	

	public OfenController() {
		initialisiereTemperaturen();
		ofen = new Ofen(initIstTemperatur);
		ofen.setSollTemperatur(initSollTemperatur);
		ofen.setKuehlTemperatur(initKuehlTemperatur);
		brennElementTypSpezifikationen = leseBrennElementTypSpezifikationen();
	}

	public void starteVerbrennung() {
		int anzahl = 30;
		for (int i = 0; i < anzahl; i++) {
			String typDesBrennElements = ermittleZufaelligenBrennElementTyp();
			verbrenneBrennElementVomTyp(typDesBrennElements);
		}
	}
	
	private String ermittleZufaelligenBrennElementTyp() {
		String[] brennElementeNamen = this.leseBrennElementTypen();
		Random zufallsZahlenGenerator = new Random();
		int zufallsZahl = zufallsZahlenGenerator.nextInt(brennElementeNamen.length);
		return (String) brennElementeNamen[zufallsZahl];
	}
	
	public void starteVerbrennungSortiert() {
		List<Object> objListe = new ArrayList<Object>();
		String[] keyArray = this.leseBrennElementTypen();
		for (int i = 0; i < keyArray.length; i++) {
			String  beInfo = (String)brennElementTypSpezifikationen.get(keyArray[i]);
			System.out.println("unsorted beInfo=" + beInfo);
			objListe.add(erzeugeBrennElement(beInfo));
		}
		
		System.out.println("\n==== Unsortierte Objektliste");
		List<Object> objListe2 = new ArrayList<Object>();
		// Liste über einen Iterator ausgeben
		for (int i = 0; i < objListe.size(); i++) {
			Object o = objListe.get(i);
			System.out.println(o);
			objListe2.add(o);
		}

		System.out.println("\n==== Sortierte Objektliste über Iterator");
		Collections.sort((List)objListe2);
		Iterator<Object> it = objListe2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	
	/*
	 * Getter
	 */
	public int getIstTemperatur() {
		return ofen.getIstTemperatur();
	}

	public int getSollTemperatur() {
		return ofen.getSollTemperatur();
	}

	public int getKuehlTemperatur() {
		return ofen.getKuehlTemperatur();
	}

	protected void initialisiereTemperaturen() {
		initSollTemperatur = STANDARD_SOLL_TEMPERATUR;
		initIstTemperatur = STANDARD_IST_TEMPERATUR;
		initKuehlTemperatur = STANDARD_KUEHL_TEMPERATUR;
	}

	public String[] leseBrennElementTypen() {
		int anzahlDerBrennElemente = brennElementTypSpezifikationen.size(); 
		Collection<String> typenListe = brennElementTypSpezifikationen.keySet();
		String[] typen = new String[anzahlDerBrennElemente];
		typen = (String[]) typenListe.toArray(typen);
		return typen;
	}

	protected HashMap<String, String> leseBrennElementTypSpezifikationen() {
		HashMap<String, String> spezifikationen = new HashMap<>();
		spezifikationen.put("Holz", "de.unilog.hkw.brennelemente.Holz; Buche");
		spezifikationen.put("Holz2", "de.unilog.hkw.brennelemente.Holz; Fichte");
		spezifikationen.put("Papier", "de.unilog.hkw.brennelemente.Papier; Zeitung");
		//hm.put("Sofa", "de.unilog.hkw.moebel.Sofa; Stoff");
		//hm.put("Dose1", "de.unilog.hkw.brennelemente.Dose; Aluminium");
		//hm.put("Schrank", "de.unilog.hkw.moebel.MetallSchrank; Blech");
		//hm.put("Sofa2", "de.unilog.hkw.moebel.Sofa"); // nicht erzeugbar
		return spezifikationen;
	}

	public void verbrenneBrennElementVomTyp(String brennElementTyp) {
		String brennElementSpezifikation = (String)brennElementTypSpezifikationen.get(brennElementTyp);
		System.out.println("Belade " + brennElementTyp + "=" + brennElementSpezifikation);
		Object brennElement = erzeugeBrennElement(brennElementSpezifikation);
		ofen.beladen(brennElement);
	}

	protected Object erzeugeBrennElement(String brennElemenSpezifikation) {
		StringTokenizer tok = new StringTokenizer(brennElemenSpezifikation, ";");
		String brennElementKlasse;
		String brennElementTyp;
		Object brennElement = null;

		if (tok.countTokens() == 1) {
			brennElementKlasse = brennElemenSpezifikation;
			brennElement = BrennElementeFabrik.gibInstanz().erzeugeBrennElement(brennElementKlasse);
		} else {
			brennElementKlasse = tok.nextToken();
			brennElementTyp = tok.nextToken().trim();
			brennElement = BrennElementeFabrik.gibInstanz().erzeugeBrennElementMitTyp(brennElementKlasse, brennElementTyp);
		}
		return brennElement;
	}
}
