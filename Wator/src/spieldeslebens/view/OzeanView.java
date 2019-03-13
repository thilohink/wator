package spieldeslebens.view;

import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import spieldeslebens.Ozean;
import spieldeslebens.OzeanZelle;

public class OzeanView {

	JPanel component;
	
	public OzeanView() {
		component = new JPanel(
				new GridLayout(
						Ozean.HEIGHT, 
						Ozean.WIDTH,
						1,1));
	}
	
	ImageIcon loadIcon(OzeanZelle zelle) {
		String name = zelle.gibInhalt().gibArtDesInhalts() + ".png";
		URL url = this.getClass().getResource(name);
		return new ImageIcon(url);
	}
	
	public void update(Ozean ozean) {
		component.removeAll();
		for(int y=0; y<Ozean.HEIGHT; y++) {
			for(int x=0; x<Ozean.WIDTH; x++) {
				ImageIcon icon = loadIcon(ozean.gibZelle(x, y));
				component.add(new JLabel(icon));
			}
		}
		component.revalidate();
	}
	
}
