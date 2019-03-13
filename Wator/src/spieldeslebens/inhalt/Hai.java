package spieldeslebens.inhalt;

import spieldeslebens.Lebewesen;
import spieldeslebens.Teilnehmer;

public class Hai extends Lebewesen {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Hai();
	}
	
	@Override
	public String gibArtDesInhalts() {
		return "hai";
	}
	
}
