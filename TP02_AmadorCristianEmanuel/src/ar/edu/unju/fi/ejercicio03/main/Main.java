package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {

		Provincia[] provincias = Provincia.values();

		showAll(provincias);

	}

	public static void showAll(Provincia[] provincias) {

		for (int i = 0; i < provincias.length; i++) {
			System.out.println("Detalles de la Provincia: " + provincias[i]);
			System.out.println("Poblacion: " + provincias[i].getPoblacion() + "[um]");
			System.out.println("Superficie: " + provincias[i].getSuperficie() + "[um]");
			System.out.println("Densidad Poblacional: " + provincias[i].calcularDensidadPoblacional() + "[um]\n");
		}
	}
}
