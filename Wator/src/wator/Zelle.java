package wator;

public class Zelle {

	int x;
	int y;
	ZellInhalt inhalt;
	
	Zelle(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		this.inhalt = new ZellInhalt();
	}
	
	public ZellInhalt gibInhalt() {
		return inhalt;
	}
	
}
