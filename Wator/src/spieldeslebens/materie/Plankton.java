package spieldeslebens.materie;

public class Plankton extends Materie {

	static final int GEWICHT_BEI_GEBURT = 5;
	
	Plankton() {
		setzeGewicht(GEWICHT_BEI_GEBURT);
	}
	
	@Override
	public String gibArtDerMaterie() {
		return "plankton";
	}
	
}
