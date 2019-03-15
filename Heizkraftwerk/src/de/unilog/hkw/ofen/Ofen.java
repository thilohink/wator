package de.unilog.hkw.ofen;

import de.unilog.hkw.global.Brennbar;

/**
 * Der Ofen beschreibt das Modell unser Heizkraftwerksanwendung,
 * das heisst, hier ist der Gesch�ftsprozess abgebildet,
 * der Ofen wird beladen, Brennelemente werden verbrannt und
 * erh�hen die Temperatur des Ofens. Wird der Ofen zu heiss
 * wird automatisch gek�hlt.
 *
 * Als Programmiertechniken werden benutzt:
 * - Casting der brennbaren Elemente
 * - Garbage Collection der Brennelemente
 * - innere Klasse
 * - packages f�r Rollenverteilung
 * - Exception Handling
 * - Verwendung von User-Exceptions
 *
 * @version 1.2 krg 2.5.2003 (hkw02)
 */
public class Ofen  {
  
  private int istTemperatur = 20; 
  private int sollTemperatur;
  private int kuehlTemperatur = 30;
  private Brennkammer bk = null;
  
  /**
   * Der Ofen ist lediglich der Beh�lter f�r die Brennelemente
   * und die Brennkammer, die Erw�rmung von Wasser und
   * Erzeugung des Stroms �ber Turbinen verbleibt als �bung :-)
   *
   * Die Brennkammer ist jetzt als innere Klasse implementiert, da sie
   * in Wirklichkeit ebenfalls innerer Bestandteil des Ofens ist.
   * Wir k�nnen mit inneren Klassn die Aggregation/Komposition realisieren.
   */
  public Ofen(int sollTemperatur) {
    this.sollTemperatur  = sollTemperatur;
    //die Brennkammer hat jetzt einen parameterlosen Konstruktor
    bk = new Brennkammer();	
  }
  
  /*
   * Getter und Setter f�r Properties
   */
  public int getIstTemperatur() { return this.istTemperatur; }
  public int getSollTemperatur() { return this.sollTemperatur; }
  public int getKuehlTemperatur() { return this.kuehlTemperatur; }
  public void setSollTemperatur(int i) { this.sollTemperatur = i; }  
  public void setKuehlTemperatur(int i) { this.kuehlTemperatur = i; }
  private void setIstTemperatur(int i) { this.istTemperatur = i; }
  
  /**
   * Diese Methode ist jetzt private, weil nur die Brennkammer
   * die Temperatur des Ofens erh�hen darf
   */  
  private void erh�heTemperatur(int brennwert) {
    setIstTemperatur(this.istTemperatur + brennwert);
  }
  
  private void k�hlen() {
    setIstTemperatur(istTemperatur - kuehlTemperatur);
  }
  

  /**
   * In den Ofen k�nnen beliebige Objekte gegeben werden.
   * Die Elemente, die nicht Brennbar sind f�hren in der
   * ersten Fassung zum Programmabbruch
   *
   * Die Exceptions werden nun abgefangen.
   * Falls die Temperatur in der Brennkammer zu hoch ist
   * wird eine Exception abgefangen und der Ofen wird
   * automatisch gek�hlt
   */
  public void beladen(Object o) {
  	if (o == null) {
  		System.out.println("null-Objekt hat keinen Heizwert");
  	}
  	else {
	    try {
	      bk.verbrennen((Brennbar)o);
	    }
	    catch(ClassCastException cce) {
	    	System.out.println(cce + ": " + o.getClass().getName() + " nicht brennbar");
	    }
	    catch(TemperaturException te) {
	    	System.out.println(te.toString());
	      k�hlen();
	    }  
		}
	}


	//=========================================================================
  /**
   * Die Brennkammer als member inner class:
   * Kein Konstruktor mit Referenz auf Ofen mehr n�tig
   * Direkter Zugriff auf private Attribute von Ofen oder mit Ofen.this.attr
   */
  private class Brennkammer {
  	
    /** wird bei einer inner class nicht ben�tigt
    public Brennkammer(Ofen o) {
      super();
    } // Brennkammer()
    */
    
    /**
     * Diese Methode nimmt Elemente entgegen, die Brennbar sind
     * zun�chst Holz, dann alle brennbaren Elemente. Die
     * Brennkammer erh�ht die Temperatur des Ofens. 
     *
     * Polymorphie:
     * zur Laufzeit wird die richtige brennen()-Methode des Brennelements
     * aufgerufen(Holz, Papier, Gas), da der Ofen lt. Signatur nicht
     * weiss was f�r ein Objekt er bekommt!
     * 
     * Gezeigt werden die verschiedenen M�glichkeiten auf Methoden, 
     * Attribute der �u�eren Klasse zuzugreifen, diese k�nnen sogar
     * private sein!
     */
    public void verbrennen(Brennbar b) throws TemperaturException {
      int heizleistung = b.brennen();
      Ofen.this.erh�heTemperatur(heizleistung); // Mit Namen der �u�eren Klasse
      System.out.println("Temperatur: ist=" + istTemperatur + ", soll=" + sollTemperatur);
          
      if (istTemperatur >= sollTemperatur) {
        throw new TemperaturException(istTemperatur);
      }
    }
  } // inner class Brennkammer
	//====================================================================
  
}
