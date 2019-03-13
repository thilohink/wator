package spieldeslebens.inhalt;

import spieldeslebens.Teilnehmer;

public class Plankton extends Teilnehmer {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Plankton();
	}
	
	@Override
	public String gibArtDesInhalts() {
		return "plankton";
	}
	
}
