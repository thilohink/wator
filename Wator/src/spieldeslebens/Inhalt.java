package spieldeslebens;

public abstract class Inhalt {

	OzeanZelle zelle;
	
	public abstract String gibArtDesInhalts();
	
	public OzeanZelle gibZelle() {
		return zelle;
	}
	
	public void setzeZelle(OzeanZelle neueZelle) {
		this.zelle = neueZelle;
	}
	
	public void timeStep() {
		// TODO
	}
	
}
