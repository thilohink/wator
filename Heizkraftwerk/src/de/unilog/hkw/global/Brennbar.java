package de.unilog.hkw.global;

/**
 * Skalierbarkeit:
 * Das Interface Brennbar ist die Schnittstille zwischen Ofen-Bauer
 * und Brennelemente-Hersteller, schlie�lich soll der Generalarchitekt
 * des Heizkraftwerks verschiedene �fen und Brennelemte verwenden k�nnen.
 *
 * @version 2.6.107 krg Brennbare Objekte k�nnen nach Brennwert sortiert werden.
 */
public interface Brennbar extends Comparable<Brennbar> {
	public int brennen();
	public int getBrennwert();
}
