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
		this.inhalt = MaterieFabrik.erzeugeMaterie("wasser");
	}
	
	public void abmelden(Materie alterInhalt) {
		this.inhalt = MaterieFabrik.erzeugeMaterie("wasser");
	}
	
	public void anmelden(Materie neuerInhalt) {
		this.inhalt = neuerInhalt;
	}
	
	public Materie gibInhalt() {
		return inhalt;
	}
	
}
