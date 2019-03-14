package spieldeslebens.materie;

import java.util.Random;

import spieldeslebens.raumundzeit.Ozean;
import spieldeslebens.raumundzeit.OzeanZelle;

public class Fisch extends AktiveMaterie {

	static final int ALTER_FUER_FORTPFLANZUNG = 10;
	static final int GEWICHT_BEI_GEBURT = 100;
	
	int richtungsGen;
	
	Fisch() {
		setzeGewicht(GEWICHT_BEI_GEBURT);
		bestimmeRichtungsGen();
	}
	
	void bestimmeRichtungsGen() {
		richtungsGen = new Random().nextInt(ANZAHL_RICHTUNGEN);
	}
	
	@Override
	public String gibArtDerMaterie() {
		return "fisch";
	}
	
	@Override
	protected int gibFortpflanzungsAlter() {
		return ALTER_FUER_FORTPFLANZUNG;
	}

	@Override
	protected OzeanZelle bestimmeBewegungsZiel() {
		int zufaelligeRichtung = bestimmeZufaelligeRichtung();
		
		return Ozean.gibInstanz().ermittleNachbarZelleEinerOzeanZelleInEinerRichtung(
				gibOzeanZelle(),
				zufaelligeRichtung);
	}
	
	int bestimmeZufaelligeRichtung() {
		int zufaelligeRichtung = new Random().nextInt(ANZAHL_RICHTUNGEN);
		int wuerfel = new Random().nextInt(2);
		if (wuerfel == 0) {
			zufaelligeRichtung = richtungsGen;
		}
		return zufaelligeRichtung;
	}
	
	@Override
	protected boolean entscheideBewegungInsZiel(OzeanZelle potentiellesZiel) {
		if (potentiellesZiel.gibInhalt().gibArtDerMaterie().equals("wasser")
		 || potentiellesZiel.gibInhalt().gibArtDerMaterie().equals("plankton")) {
			return true;
		} else {
			return false;
		}
	}
	
}
