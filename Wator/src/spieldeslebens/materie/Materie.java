package spieldeslebens.materie;

import spieldeslebens.raumundzeit.OzeanZelle;

public abstract class Materie {

	OzeanZelle ozeanZelle;
	
	public abstract String gibArtDerMaterie();
	
	public OzeanZelle gibOzeanZelle() {
		return ozeanZelle;
	}
	
	public void setzeZelle(OzeanZelle neueZelle) {
		this.ozeanZelle = neueZelle;
	}
	
	public void timeStep() {
		// TODO
	}
	
}
