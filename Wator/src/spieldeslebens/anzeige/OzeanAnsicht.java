package spieldeslebens.anzeige;

import java.awt.GridLayout;
import javax.swing.JPanel;

import spieldeslebens.raumundzeit.Ozean;
import spieldeslebens.raumundzeit.OzeanZelle;

public class OzeanAnsicht {

	JPanel komponente;
	
	public OzeanAnsicht() {
		komponente = new JPanel(
				new GridLayout(
						Ozean.HOHE_DES_OZEAN_ZELL_RASTERS, 
						Ozean.BREITE_DES_OZEAN_ZELL_RASTERS,
						1,1));
	}
	
	public void aktualisiere(Ozean ozean) {
		komponente.removeAll();
		for(int zeile=0; zeile<Ozean.HOHE_DES_OZEAN_ZELL_RASTERS; zeile++) {
			for(int spalte=0; spalte<Ozean.BREITE_DES_OZEAN_ZELL_RASTERS; spalte++) {
				OzeanZelle ozeanZelle = ozean.ermittleOzeanZelleMitKoordinaten(spalte, zeile);
				OzeanZellenAnsicht ozeanZellenAnsicht = new OzeanZellenAnsicht();
				ozeanZellenAnsicht.aktualisiere(ozeanZelle);
				komponente.add(ozeanZellenAnsicht);
			}
		}
		komponente.revalidate();
	}
	
}
