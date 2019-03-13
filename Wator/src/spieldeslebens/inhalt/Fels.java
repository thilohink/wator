package spieldeslebens.inhalt;

import spieldeslebens.Teilnehmer;

public class Fels extends Teilnehmer {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Fels();
	}
	
	@Override
	public String gibArtDesInhalts() {
		return "fels";
	}
	
}
