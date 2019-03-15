package spieldeslebens.materie;

import spieldeslebens.raumundzeit.OzeanZelle;

public abstract class Materie {

	private int gewicht;
	private OzeanZelle ozeanZelle;
	
	public abstract String gibArtDerMaterie();
	
	public int gibGewicht() {
		return gewicht;
	}
	
	public OzeanZelle gibOzeanZelle() {
		return ozeanZelle;
	}
	
	public void setzeGewicht(int neuesGewicht) {
		gewicht = neuesGewicht;
	}
	
	public void setzeOzeanZelle(OzeanZelle neueZelle) {
		ozeanZelle = neueZelle;
		ozeanZelle.setzeInhalt(this);
	}
	
}
