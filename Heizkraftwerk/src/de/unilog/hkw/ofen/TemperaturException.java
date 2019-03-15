package de.unilog.hkw.ofen;

/**
 * Hier wird eine eigene sog. User-Exception definiert,
 * sie zeigt an, da� die istTemperatur des Ofens die
 * soll Temperatur �bersteigt.
 * 
 * Wir sorgen mit super() daf�r, da� der Benutzer mit
 * getMessage() auf die Fehlermeldung zugreifen kann, ohne
 * dass wir diese Methode �berschreiben.
 *
 * Wichtig ist die tats�chliche Temperatur in der Brennkammer,
 * falls die Temperatur viel zu hoch ist (Brennkammer bereits 
 * besch�digt) k�nnte ein von TemperaturException abgeleitete
 * VielZuHeissException geworfen werden.
 *
 * Um die Temperatur zu ermitteln wird die getTemperatur()-Methode
 * hinzugef�gt.
 * 
 * @version 1.3	krg 20.5.2005 (hkw02)
 */
public class TemperaturException extends Exception {
  
  private int temperatur;
  
  public TemperaturException(int temp) {
    super("Brennkammer zu heiss: Temperatur=" + temp + " Grad!");
    this.temperatur = temp;
  }
  
  public int getTemperatur() {
    return temperatur;
  }
  
}
