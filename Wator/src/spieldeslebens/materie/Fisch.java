package spieldeslebens.materie;

import java.util.Random;

import spieldeslebens.raumundzeit.Ozean;
import spieldeslebens.raumundzeit.OzeanZelle;

public class Fisch extends AktiveMaterie {

	int bevorzugteBewegungsRichtung;
	int gewicht;
	
	Fisch() {
	}
	
	@Override
	public String gibArtDerMaterie() {
		return "fisch";
	}

	@Override
	public void timeStep() {
		bevorzugteBewegungsRichtung = new Random().nextInt(8);
		OzeanZelle neueZelle = Ozean.gibInstanz().ermittleNachbarZelleEinerOzeanZelleInRichtung(
				bevorzugteBewegungsRichtung, 
				gibOzeanZelle());
		String inhalt = neueZelle.gibInhalt().gibArtDerMaterie();
		if (inhalt.equals("wasser")) {
			neueZelle.anmelden(this);
			this.gibOzeanZelle().abmelden(this);
			this.setzeZelle(neueZelle);
		}
		if (inhalt.equals("plankton")) {
			//TODO
		}
	}
	
}
