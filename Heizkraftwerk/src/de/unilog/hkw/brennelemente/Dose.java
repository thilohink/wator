package de.unilog.hkw.brennelemente;


/**
 * Die Dose ist nichtht Brennbar, der Ofen wirft beim Versuch das
 * Element die Brennkammer zu verbrennen, eine ClassCastException
 *
 * Auch wenn die brennen()-Methode hinzugef�gt wird, kann die
 * Dose nicht verbrannt werden. 
 *
 * @version 1.4 krg 29.6.2004 (hkw02)
 */
public class Dose {
  
  protected String typ;
 
  static {
    System.out.println("Klasse Dose geladen");
  }
  
  public Dose(String typ) { 
    this.typ = typ;
  }

  public String toString() {
  	return this.typ + "-Dose: ";
  }

	public void finalize() throws Throwable {
		System.out.println("GC: " + this.typ + " aufger�umt.");
		super.finalize();
	}  
  
}
