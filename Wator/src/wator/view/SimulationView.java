package wator.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import wator.Simulation;

public class SimulationView {

	JFrame component;
	OzeanView ozeanView;
	
	public SimulationView() {
		component = new JFrame("Wator Simulation");
		component.setSize(800, 400);
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
