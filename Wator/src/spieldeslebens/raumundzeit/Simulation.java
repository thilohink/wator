package spieldeslebens.raumundzeit;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import spieldeslebens.anzeige.SimulationAnsicht;
import spieldeslebens.materie.AktiveMaterie;
import spieldeslebens.materie.Materie;
import spieldeslebens.materie.MaterieFabrik;

public class Simulation {
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Simulation simulation = new Simulation();
		
		simulation.start();
		
	}
	
	List<AktiveMaterie> aktiveMaterie;
	SimulationAnsicht anzeige;
	Ozean ozean;
	ZeitAblauf zeitAblauf;

	Simulation() {
		this.ozean = Ozean.gibInstanz();
		this.aktiveMaterie = new ArrayList<>();
		this.anzeige = new SimulationAnsicht();
		this.zeitAblauf = new ZeitAblauf(this);
	}
	
	List<AktiveMaterie> erzeugeAktiveMaterieZufaelligImOzeanMitAnzahlUndArt(int anzahl, String artDerMaterie) {
		List<AktiveMaterie> result = new ArrayList<>();
		for(int zahl=0; zahl<anzahl; zahl++) {
			AktiveMaterie materie = (AktiveMaterie) MaterieFabrik.erzeugeMaterie(artDerMaterie);
			result.add(materie);
			ozean.besetzeOzeanZelleMitMaterieAnZufaelligerPosition(materie);
		}
		return result;
	}
	
	void erzeugeMaterieZufaelligImOzeanMitAnzahlUndArt(int anzahl, String artDerMaterie) {
		for(int zahl=0; zahl<anzahl; zahl++) {
			Materie materie = MaterieFabrik.erzeugeMaterie(artDerMaterie);
			ozean.besetzeOzeanZelleMitMaterieAnZufaelligerPosition(materie);
		}
	}
	
	void erzeugeOzean() {
		ozean.fluteMitWasser();

		erzeugeMaterieZufaelligImOzeanMitAnzahlUndArt(40, "fels");
		erzeugeMaterieZufaelligImOzeanMitAnzahlUndArt(25, "plankton");
		
		aktiveMaterie.addAll(erzeugeAktiveMaterieZufaelligImOzeanMitAnzahlUndArt(8,  "fisch"));
		aktiveMaterie.addAll(erzeugeAktiveMaterieZufaelligImOzeanMitAnzahlUndArt(4,  "hai"));

	}
	
	public Ozean gibOzean() {
		return ozean;
	}
	
	void schreiteInDerZeitVoran() {
		erzeugeMaterieZufaelligImOzeanMitAnzahlUndArt(5, "plankton");

		for(AktiveMaterie lebewesen: new ArrayList<>(aktiveMaterie)) {
			lebewesen.schreiteInDerZeitVoran();
			if (lebewesen.istGestorben()) {
				aktiveMaterie.remove(lebewesen);
			}
		}
		
		anzeige.aktualisiere(this);
	}
	
	void start() {
		erzeugeOzean();
		anzeige.aktualisiere(this);
		anzeige.anzeigen();
		zeitAblauf.starteZeitAblauf();
	}
	
}
