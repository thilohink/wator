package spieldeslebens.inhalt;

import java.util.Random;

import spieldeslebens.Lebewesen;
import spieldeslebens.Ozean;
import spieldeslebens.OzeanZelle;

public class Fisch extends Lebewesen {

	int richtung;

	@Override
	public String gibArtDesInhalts() {
		return "fisch";
	}

	@Override
	public void timeStep() {
		richtung = new Random().nextInt(8);
		OzeanZelle neueZelle = Ozean.getInstance().gibZelle(richtung, gibZelle());
		String inhalt = neueZelle.gibInhalt().gibArtDesInhalts();
		if (inhalt.equals("wasser")) {
			neueZelle.anmelden(this);
			this.gibZelle().abmelden(this);
			this.setzeZelle(neueZelle);
		}
	}
	
}
