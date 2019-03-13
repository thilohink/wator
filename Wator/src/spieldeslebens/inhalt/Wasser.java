package spieldeslebens.inhalt;

import spieldeslebens.Teilnehmer;

public class Wasser extends Teilnehmer {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Wasser();
	}
	
	@Override
	public String gibArtDesInhalts() {
		return "wasser";
	}

}
