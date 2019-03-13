package spieldeslebens.inhalt;

import spieldeslebens.Teilnehmer;
import spieldeslebens.TeilnehmerFabrik;

public class HaiFabrik implements TeilnehmerFabrik {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Hai();
	}

}
