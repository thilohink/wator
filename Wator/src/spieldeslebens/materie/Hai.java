package spieldeslebens.materie;

import java.util.Random;

import spieldeslebens.raumundzeit.Ozean;
import spieldeslebens.raumundzeit.OzeanZelle;

public class Hai extends AktiveMaterie {

	static final int ALTER_FUER_FORTPFLANZUNG = 20;
	static final int GEWICHT_BEI_GEBURT = 200;

	Hai() {
		setzeGewicht(GEWICHT_BEI_GEBURT);
	}
	
	@Override
	public String gibArtDerMaterie() {
		return "hai";
	}
	
	@Override
	protected OzeanZelle bestimmeBewegungsZiel() {
		OzeanZelle zielZelle = Ozean.gibInstanz().sucheNachbarZelleMitInhalt("fisch", gibOzeanZelle());
		if (zielZelle == null) {
			zielZelle = Ozean.gibInstanz().ermittleNachbarZelleEinerOzeanZelleInEinerRichtung(
					gibOzeanZelle(), 
					new Random().nextInt(ANZAHL_RICHTUNGEN));
		}
		return zielZelle;
	}
	
	@Override
	protected boolean entscheideBewegungInsZiel(OzeanZelle potentiellesZiel) {
		if (potentiellesZiel.gibInhalt().gibArtDerMaterie().equals("wasser")
		 || potentiellesZiel.gibInhalt().gibArtDerMaterie().equals("plankton")
		 || potentiellesZiel.gibInhalt().gibArtDerMaterie().equals("fisch")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected int gibFortpflanzungsAlter() {
		return ALTER_FUER_FORTPFLANZUNG;
	}

	@Override
	public void fresse(Materie futter) {
		// TODO Auto-generated method stub
		super.fresse(futter);
	}
	
}
