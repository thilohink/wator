package spieldeslebens.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import spieldeslebens.Simulation;

public class SimulationView {

	JFrame component;
	OzeanView ozeanView;
	
	public SimulationView() {
		component = new JFrame("Spiel des Lebens Simulation (aka Wator)");
		component.setSize(1280, 800);
		component.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		component.setLocationRelativeTo(null);
		
		ozeanView = new OzeanView();
		JScrollPane scrollOzean = new JScrollPane(ozeanView.component);
		component.getContentPane().add(scrollOzean, BorderLayout.CENTER);
	}
	
	public void open() {
		component.setVisible(true);
	}
	
	public void update(Simulation simulation) {
		ozeanView.update(simulation.gibOzean());
	}
	
}
