package spieldeslebens;

import spieldeslebens.inhalt.Wasser;

public class OzeanZelle {

	int x;
	int y;
	Inhalt inhalt;
	
	OzeanZelle(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		this.inhalt = new Wasser();
	}
	
	public void abmelden(Inhalt alterInhalt) {
		this.inhalt = new Wasser();
	}
	
	public void anmelden(Inhalt neuerInhalt) {
		this.inhalt = neuerInhalt;
	}
	
	public Inhalt gibInhalt() {
		return inhalt;
	}
	
}
