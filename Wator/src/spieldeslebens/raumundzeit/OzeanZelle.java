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
		inhalt.setzeZelle(this);
	}
	
	public void entferneInhalt() {
		fluteMitWasser();
	}
	
	public void aendereInhalt(Materie neuerInhalt) {
		inhalt = neuerInhalt;
	}
	
	public Materie gibInhalt() {
		return inhalt;
	}
	
}
