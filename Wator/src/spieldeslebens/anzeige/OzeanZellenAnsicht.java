package spieldeslebens.anzeige;

import java.awt.Color;
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
		this.setFont(new Font("Dialog", Font.PLAIN, 8));
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
			String anzeigeGewicht = String.valueOf(ozeanZelle.gibInhalt().gibGewicht()); 
			int anzeigeBreite = getFontMetrics(getFont()).stringWidth(anzeigeGewicht)+3;
			int anzeigeHoehe = getFontMetrics(getFont()).getHeight();
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 32-anzeigeHoehe, anzeigeBreite, anzeigeHoehe);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(0, 32-anzeigeHoehe, anzeigeBreite, anzeigeHoehe);
			
			g2d.setFont(getFont());
			g2d.drawString(anzeigeGewicht, 2, 30);
		}
	}
	
}
