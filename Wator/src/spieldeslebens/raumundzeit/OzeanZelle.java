package spieldeslebens.raumundzeit;

import spieldeslebens.materie.Materie;
import spieldeslebens.materie.MaterieFabrik;

public class OzeanZelle {

	int spalte;
	int zeile;
	Materie inhalt;
	
	OzeanZelle(int spalte, int zeile) {
		this.spalte = spalte;
		this.zeile = zeile;
	}

	public void fluteMitWasser() {
		inhalt = MaterieFabrik.erzeugeMaterie("wasser");
		inhalt.setzeOzeanZelle(this);
	}
	
	public void entferneInhalt() {
		fluteMitWasser();
	}
	
	public Materie gibInhalt() {
		return inhalt;
	}

	public void setzeInhalt(Materie neuerInhalt) {
		inhalt = neuerInhalt;
	}
	
}
