/*
java de.unilog.hkw.JMain
*/
package de.unilog.hkw;

import de.unilog.hkw.ofen.*;

public class JMain {

	public static void main(String[] args) {
	
		System.out.println("HKW Simulation gestartet. Starte OfenController");
		OfenControllerImpl oc = new OfenControllerImpl();
		//oc.start();
		oc.startSorted();
	}

}
