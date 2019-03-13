package spieldeslebens;

public abstract class Teilnehmer {

	OzeanZelle zelle;
	
	public abstract Teilnehmer erzeugeTeilnehmner();

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
