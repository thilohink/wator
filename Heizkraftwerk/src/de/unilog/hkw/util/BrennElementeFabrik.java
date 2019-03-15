package de.unilog.hkw.util;

import java.lang.reflect.*;

/**
 * Die BrennElementeFabrik ist ein singleton
 * und für die Erzeugung von BrennElementen zuständig.
 */
public class BrennElementeFabrik {

	private static BrennElementeFabrik instanz;

	private BrennElementeFabrik() {
		System.out.println("BrennElementeFabrik erzeugt");
	}

	public static BrennElementeFabrik gibInstanz() {
		if (instanz == null) {
			instanz = new BrennElementeFabrik();
		}
		return instanz;
	}

	public Object erzeugeBrennElement(String brennElementKlasse) {
		if (brennElementKlasse == null) {
			return null;
		}
		try {
			return Class.forName(brennElementKlasse).newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println(e + ": not found");
			return new Object();
		} catch (InstantiationException e) {
			System.out.println(e + " object cannot be instantiated");
			return new Object();
		} catch (IllegalAccessException e) {
			System.out.println(e + ": <init> is not visible");
			return new Object();
		}
	}

	public Object erzeugeBrennElementMitTyp(String brennElementKlasse, String typ) {
		try {
			return Class.forName(brennElementKlasse).getConstructor(String.class).newInstance(typ);
		} catch (InvocationTargetException e) {
			System.out.println(
				e + " Exception during invocation: " + e.getTargetException());
			return new Object();
		} catch (ClassNotFoundException e) {
			System.out.println(e + " not found");
			return new Object();
		} catch (NoSuchMethodException e) {
			System.out.println(e + ": No constructor with parameter 'String' found");
			return new Object();
		} catch (InstantiationException e) {
			System.out.println(e + ": during <init>");
			return new Object();
		} catch (IllegalAccessException e) {
			System.out.println(e + ": <init> is not visible");
			return new Object();
		}
	}
}
