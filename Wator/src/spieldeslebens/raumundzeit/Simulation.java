package spieldeslebens.raumundzeit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.UIManager;

import spieldeslebens.anzeige.SimulationAnsicht;
import spieldeslebens.materie.AktiveMaterie;
import spieldeslebens.materie.Materie;
import spieldeslebens.materie.MaterieFabrik;

public class Simulation implements ActionListener {
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Simulation simulation = new Simulation();
		
		simulation.start();
		
	}

	Ozean ozean;
	List<AktiveMaterie> aktiveMaterie;
	Timer zeitAblauf;
	SimulationAnsicht anzeige;

	public Simulation() {
		this.ozean = Ozean.gibInstanz();
		this.aktiveMaterie = new ArrayList<>();
		
		this.anzeige = new SimulationAnsicht();
		this.zeitAblauf = new Timer(100, this);
		this.zeitAblauf.setRepeats(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		anzeige.aktualisieren(this);
		for(AktiveMaterie materie: aktiveMaterie) {
			materie.timeStep();
		}
		
	}
	
	List<AktiveMaterie> erzeugeAktiveMaterieImOzeanMitAnzahlUndArt(int anzahl, String artDerMaterie) {
		List<AktiveMaterie> result = new ArrayList<>();
		for(int zahl=0; zahl<anzahl; zahl++) {
			AktiveMaterie materie = (AktiveMaterie) MaterieFabrik.erzeugeMaterie(artDerMaterie);
			result.add(materie);
			ozean.besetzeZelleMitMaterieAnZufaelligerPosition(materie);
		}
		return result;
	}
	
	void erzeugeMaterie() {
		this.erzeugeMaterieImOzeanMitAnzahlUndArt(10, "fels");
		this.erzeugeMaterieImOzeanMitAnzahlUndArt(25, "plankton");
		this.aktiveMaterie.addAll(erzeugeAktiveMaterieImOzeanMitAnzahlUndArt(8,  "fisch"));
		this.aktiveMaterie.addAll(erzeugeAktiveMaterieImOzeanMitAnzahlUndArt(4,  "hai"));
	}
	
	
	void erzeugeMaterieImOzeanMitAnzahlUndArt(int anzahl, String artDerMaterie) {
		for(int zahl=0; zahl<anzahl; zahl++) {
			Materie materie = MaterieFabrik.erzeugeMaterie(artDerMaterie);
			ozean.besetzeZelleMitMaterieAnZufaelligerPosition(materie);
		}
	}
	
	public Ozean gibOzean() {
		return ozean;
	}
	
	void start() {
		erzeugeMaterie();
		zeitAblauf.start();
		anzeige.anzeigen();
	}
	
}
