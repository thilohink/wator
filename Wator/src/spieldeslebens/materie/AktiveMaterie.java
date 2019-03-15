package spieldeslebens.materie;

import spieldeslebens.raumundzeit.OzeanZelle;

public abstract class AktiveMaterie extends Materie {

	static final int ANZAHL_RICHTUNGEN = 8;

	private int alter;

	protected int gibAlter() {
		return alter;
	}
	
	protected abstract int gibFortpflanzungsAlter();
	
	public AktiveMaterie() {
		alter = 0;
	}
	
	public void pflanzeDichFort() {
		if (gibAlter() >= gibFortpflanzungsAlter()) {
			
			// TODO
			
		}
	}
	
	public void schreiteInDerZeitVoran() {
		altere();
		nehmeAb();
		if(!istGestorben()) {
			OzeanZelle zielZelle = bestimmeBewegungsZiel();
			if (entscheideBewegungInsZiel(zielZelle)) {
				fresse(zielZelle.gibInhalt());
				bewegeDichZurOzeanZelle(zielZelle);
			}
			pflanzeDichFort();
		}
	}

	protected void altere() {
		alter++;
	}

	public void nehmeAb() {
		int altesGewicht = gibGewicht();
		int neuesGewicht = altesGewicht - 1;
		setzeGewicht(neuesGewicht);
		if (neuesGewicht == 0) {
			sterbe();
		}
	}
	
	public boolean istGestorben() {
		if (gibGewicht() == 0) {
			return true;
		} else {
			return false;
		}
	}

	protected abstract OzeanZelle bestimmeBewegungsZiel();

	protected abstract boolean entscheideBewegungInsZiel(OzeanZelle potentiellesZiel);
	
	public void fresse(Materie futter) {
		int altesGewicht = gibGewicht();
		int neuesGewicht = altesGewicht + futter.gibGewicht();
		setzeGewicht(neuesGewicht);
		futter.gibOzeanZelle().entferneInhalt();
		if (futter.gibArtDerMaterie().equals("fisch")) {
			((AktiveMaterie) futter).sterbe();
		}
	}

	protected void bewegeDichZurOzeanZelle(OzeanZelle neueZelle) {
		OzeanZelle alteZelle = gibOzeanZelle();
		setzeOzeanZelle(neueZelle);
		alteZelle.entferneInhalt();
	}

	public void sterbe() {
		gibOzeanZelle().entferneInhalt();
	}
	
}
