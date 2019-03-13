package spieldeslebens;

import spieldeslebens.inhalt.Wasser;

public class OzeanZelle {

	int x;
	int y;
	Teilnehmer inhalt;
	
	OzeanZelle(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		this.inhalt = new Wasser();
	}
	
	public void abmelden(Teilnehmer alterInhalt) {
		this.inhalt = new Wasser();
	}
	
	public void anmelden(Teilnehmer neuerInhalt) {
		this.inhalt = neuerInhalt;
	}
	
	public Teilnehmer gibInhalt() {
		return inhalt;
	}
	
}
