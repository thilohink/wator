package wator.view;

import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import wator.Ozean;
import wator.Zelle;

public class OzeanView {

	JPanel component;
	
	public OzeanView() {
		component = new JPanel(
				new GridLayout(
						Ozean.HEIGHT, 
						Ozean.WIDTH,
						1,1));
	}
	
	ImageIcon loadIcon(Zelle zelle) {
		String name = zelle.gibInhalt().getTyp() + ".png";
		URL url = this.getClass().getResource(name);
		if (url == null) {
			System.out.println("[WARN] OzeanView.loadIcon( " + name + " ) not found!");
		}
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
