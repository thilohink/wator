package wator;

import javax.swing.UIManager;

import wator.view.SimulationView;

public class Simulation {
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Simulation simulation = new Simulation();
		
		simulation.ozean.gibZelle(2, 2).inhalt = new Fisch();
		
		SimulationView simulationView = new SimulationView();
		simulationView.update(simulation);
		simulationView.open();
		
	}

	Ozean ozean = Ozean.getInstance();
	
	public Ozean gibOzean() {
		return ozean;
	}
	
}
