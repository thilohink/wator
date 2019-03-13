package spieldeslebens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.UIManager;

import spieldeslebens.inhalt.Fisch;
import spieldeslebens.view.SimulationView;

public class Simulation implements ActionListener {
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Simulation simulation = new Simulation();
		
		simulation.start();
		
	}

	Ozean ozean;
	List<Fisch> fische;
	Timer timer;
	SimulationView view;

	public Simulation() {
		this.ozean = Ozean.getInstance();
		this.fische = new ArrayList<>();
		this.fische.add(new Fisch());
		
		this.view = new SimulationView();
		this.timer = new Timer(100, this);
		this.timer.setRepeats(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		view.update(this);
		for(Fisch fisch: fische) {
			fisch.timeStep();
		}
		
	}
	
	public Ozean gibOzean() {
		return ozean;
	}
	
	void start() {
		ozean.besetzeZelle(fische.get(0), 2, 2);
		timer.start();
		view.open();
	}
	
}
