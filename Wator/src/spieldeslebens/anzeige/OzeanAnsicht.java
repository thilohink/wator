package spieldeslebens.anzeige;

import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	
	JLabel erzeugeOzeanZellenAnsicht(Ozean ozean, int spalte, int zeile) {
		ImageIcon bildchen = ladeBildchen(ozean.ermittleOzeanZelleMitKoordinaten(spalte, zeile));
		return new JLabel(bildchen);
	}
	
	ImageIcon ladeBildchen(OzeanZelle zelle) {
		String ressource = zelle.gibInhalt().gibArtDerMaterie() + ".png";
		URL url = this.getClass().getResource(ressource);
		return new ImageIcon(url);
	}
	
	public void aktualisieren(Ozean ozean) {
		komponente.removeAll();
		for(int zeile=0; zeile<Ozean.HOHE_DES_OZEAN_ZELL_RASTERS; zeile++) {
			for(int spalte=0; spalte<Ozean.BREITE_DES_OZEAN_ZELL_RASTERS; spalte++) {
				komponente.add(erzeugeOzeanZellenAnsicht(ozean, spalte, zeile));
			}
		}
		komponente.revalidate();
	}
	
}
