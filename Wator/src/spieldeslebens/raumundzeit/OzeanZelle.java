package spieldeslebens.raumundzeit;

import spieldeslebens.materie.Materie;
import spieldeslebens.materie.MaterieFabrik;

public class OzeanZelle {

	int x;
	int y;
	Materie inhalt;
	
	OzeanZelle(int newX, int newY) {
		this.x = newX;
		this.y = newY;
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
