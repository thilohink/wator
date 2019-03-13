package spieldeslebens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.UIManager;

import spieldeslebens.inhalt.FischFabrik;
import spieldeslebens.inhalt.HaiFabrik;
import spieldeslebens.inhalt.PlanktonFabrik;
import spieldeslebens.view.SimulationView;

public class Simulation implements ActionListener {
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Simulation simulation = new Simulation();
		
		simulation.start();
		
	}

	Ozean ozean;
	List<Teilnehmer> inhalte;
	Timer timer;
	SimulationView view;

	public Simulation() {
		this.ozean = Ozean.getInstance();
		this.inhalte = new ArrayList<>();
		
		this.view = new SimulationView();
		this.timer = new Timer(100, this);
		this.timer.setRepeats(true);
	}
	
	List<Teilnehmer> erzeugeTeilnehmerImOzean(int anzahl, TeilnehmerFabrik fabrik) {
		List<Teilnehmer> result = new ArrayList<>();
		for(int zahl=0; zahl<anzahl; zahl++) {
			Teilnehmer teilnehmer = fabrik.erzeugeTeilnehmner();
			result.add(teilnehmer);
			ozean.besetzeZelleZufaellig(teilnehmer);
		}
		return result;
	}
	
	void initialisiereInhalte() {
		this.inhalte.addAll(erzeugeTeilnehmerImOzean(25, new PlanktonFabrik()));
		this.inhalte.addAll(erzeugeTeilnehmerImOzean(8,  new FischFabrik()));
		this.inhalte.addAll(erzeugeTeilnehmerImOzean(4,  new HaiFabrik()));
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		view.update(this);
		for(Teilnehmer inhalt: inhalte) {
			inhalt.timeStep();
		}
		
	}
	
	public Ozean gibOzean() {
		return ozean;
	}
	
	void start() {
		initialisiereInhalte();
		timer.start();
		view.open();
	}
	
}
