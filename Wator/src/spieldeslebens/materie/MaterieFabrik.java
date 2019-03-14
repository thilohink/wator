package spieldeslebens.materie;

public abstract class MaterieFabrik {

	public static Materie erzeugeMaterie(String artDerMaterie) {
		Materie materie = null;
		switch (artDerMaterie) {
		case "fels": {
			materie = new Fels();
			break;
		}
		case "fisch": {
			materie = new Fisch();
			break;
		}
		case "hai": {
			materie = new Hai();
			break;
		}
		case "plankton": {
			materie = new Plankton();
			break;
		}
		default: {
			materie = new Wasser();
			break;
		}
		}
		return materie;
	}
	
}
