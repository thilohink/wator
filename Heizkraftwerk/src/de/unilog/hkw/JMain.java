/*
java de.unilog.hkw.JMain
*/
package de.unilog.hkw;

import de.unilog.hkw.ofen.*;

public class JMain {

	public static void main(String[] args) {
	
		System.out.println("HKW Simulation gestartet. Starte OfenController");
		OfenController ofenController = new OfenController();
		ofenController.starteVerbrennung();
//		ofenController.starteVerbrennungSortiert();
	}

}
