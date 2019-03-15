package de.unilog.hkw.brennelemente;

import de.unilog.hkw.global.*;

/**
 * Das Brennelement Holz besitzt die Methode brennen(), die
 * von der Brennkammer des Ofens aufgerufen wird.
 *
 * @version 2.6.107 krg Sortierbare Brennelemente
 */
public class Holz implements Brennbar {
  
  /**
   * Anhand vom Holztyp kann der Brennwert definiertwerden.
   * Typen sind u.a. "Buche", "Eiche" usw.
   * protected damit die Kinder(z.B. Papier) darauf zugreifen k�nnen!
   */
  protected String typ;
  protected int brennwert = 1;

  /**
   * Der statische Block wird nur einmal aufgerufen, n�mlich
   * beim Laden der Klassendefinition in die JVM.
   * �bertragen: der Heizer geht in den Keller und holt ein
   * B�ndel Holz, dann wirft er Scheit f�r Scheit in den Ofen :-)
   */
  static {
    System.out.println("Holz und geladen");
  }

  /** 
   * Wir wollen mit Absicht *keinen* Default-Konstruktor, der
   * Compiler f�gt diesen nun auch nicht hinzu, da wir einen
   * speziellen Konstruktor angeben. F�r die Vererbung (Papier)
   * wird dies eine Rolle spielen.
   */
  public Holz(String typ) {
    this.typ = typ;
    if (typ.startsWith("Bruchholz")) brennwert = 3;
    else if (typ.startsWith("Fichte")) brennwert = 4;
    else if (typ.startsWith("Buche")) brennwert = 5;
    System.out.println("Holz " + typ + " erzeugt, brennwert=" + brennwert);
  }

/*
  public Holz() {
    this("Fichte");   
  } // Holz()
*/

  /**
   * Lediglich die Ausgabe, da� das Element verbrannt wird.
   * Eine Verbesserung w�re die R�ckgabe des Brennwertes und
   * somit dynamische Erh�hung der Temperatur des Ofens.
   */
  public int brennen() {
  	System.out.println(typ + " verbrennt");
    return brennwert;
  }
  
  protected void finalize() throws Throwable {
  	System.out.println("GC: " + this.typ + " aufger�umt.");
    super.finalize();
  }
  
  public String toString() {
  	return this.getClass().getSimpleName() + ": typ=" + this.typ
  			+ ", brennwert=" + this.brennwert;
  }

  /**
   * @return Returns the brennwert.
   */
  public int getBrennwert() {
  	return brennwert;
  }

  public int compareTo(Brennbar other) {
  		return this.brennwert - other.getBrennwert();
  }
  
}
