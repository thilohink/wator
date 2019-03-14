package spieldeslebens.raumundzeit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Ist ein Adapter für den ActionListener, den der Zeitgeber benötigt. 
 *
 */
public class ZeitAblauf implements ActionListener {

	static final int ZEIT_SCHRITT_IN_MILLISEKUNDEN = 1000;

	Simulation simulation;
	Timer zeitGeber;
	
	public ZeitAblauf(Simulation simulation) {
		this.simulation = simulation;
		this.zeitGeber = new Timer(ZEIT_SCHRITT_IN_MILLISEKUNDEN, this);
		this.zeitGeber.setRepeats(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		simulation.schreiteInDerZeitVoran();
	}
	
	public void starteZeitAblauf() {
		zeitGeber.start();
	}
	
}
