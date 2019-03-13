package spieldeslebens.inhalt;

import spieldeslebens.Teilnehmer;
import spieldeslebens.TeilnehmerFabrik;

public class PlanktonFabrik implements TeilnehmerFabrik {

	@Override
	public Teilnehmer erzeugeTeilnehmner() {
		return new Plankton();
	}

}
