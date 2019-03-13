package spieldeslebens.inhalt;

import spieldeslebens.Teilnehmer;
import spieldeslebens.TeilnehmerFabrik;

public class FischFabrik implements TeilnehmerFabrik {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Fisch();
	}

}
