package spieldeslebens.anzeige;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import spieldeslebens.materie.AktiveMaterie;
import spieldeslebens.raumundzeit.OzeanZelle;

public class OzeanZellenAnsicht extends JLabel {

	private static final long serialVersionUID = -2828352238572083554L;

	private OzeanZelle ozeanZelle;
	
	public OzeanZellenAnsicht() {
	}

	ImageIcon ladeBildchen(OzeanZelle zelle) {
		String ressource = zelle.gibInhalt().gibArtDerMaterie() + ".png";
		URL url = this.getClass().getResource(ressource);
		return new ImageIcon(url);
	}
	

	public void aktualisiere(OzeanZelle ozeanZelle) {
		this.ozeanZelle = ozeanZelle;
		ImageIcon bildchen = ladeBildchen(ozeanZelle);
		setIcon(bildchen);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (ozeanZelle.gibInhalt() instanceof AktiveMaterie) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(new Font("Dialog", Font.PLAIN, 8));
			g2d.drawString(String.valueOf(ozeanZelle.gibInhalt().gibGewicht()), 2, 32);
		}
	}
	
}
