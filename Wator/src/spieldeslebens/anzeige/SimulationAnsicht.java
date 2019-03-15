package spieldeslebens.anzeige;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import spieldeslebens.raumundzeit.Simulation;

public class SimulationAnsicht {

	JFrame komponente;
	OzeanAnsicht ozeanAnsicht;
	
	public SimulationAnsicht() {
		komponente = new JFrame("Spiel des Lebens Simulation (aka Wator)");
		komponente.setSize(1280, 800);
		komponente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		komponente.setLocationRelativeTo(null);
		
		ozeanAnsicht = new OzeanAnsicht();
		JScrollPane scrollOzean = new JScrollPane(ozeanAnsicht.komponente);
		komponente.getContentPane().add(scrollOzean, BorderLayout.CENTER);
	}
	
	public void anzeigen() {
		komponente.setVisible(true);
	}
	
	public void aktualisiere(Simulation simulation) {
		ozeanAnsicht.aktualisiere(simulation.gibOzean());
	}
	
}
