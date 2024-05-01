package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static String x;

	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		int o;
		boolean exit = true;

		do {
			menu();
			try {
				o = sc.nextInt();

				switch (o) {
				case 1:
					newEfemeride(efemerides);
					break;
				case 2:
					for (Efemeride x : efemerides) {
						System.out.println(x.toString());
					}
					break;
				case 3:
					deletEfemeride(efemerides);
					break;
				case 4:
					modifyEfemeride(efemerides);
					break;
				case 5:
					System.out.println("program sttoped");
					exit = false;
					break;
				default:
					System.out.println("Debe ingresar una opcion valida");
				}
			} catch (Exception x) {
				System.err.println("WRONG, Only Numbers Pls");
				sc.nextLine();
			}

		} while (exit);
		sc.close();
	}

	public static void menu() {
		System.out.println("***Menu de Opciones***");
		System.out.println("1 - Crear efemeride");
		System.out.println("2 - Mostrar efemerides");
		System.out.println("3 - Eliminar efemeride");
		System.out.println("4 - Modificar efemeride");
		System.out.println("5 - Salir");
		System.out.print("Opcion: ");
	}

	public static void checkString(String s) {
		boolean loop = true;

		do {
			try {
				System.out.println("Ingrese " + s + ": ");
				x = sc.next();
				if (x.matches("[a-zA-Z0-9]+")) {
					loop = false;
				} else {
					System.out.println("Ingrese " + s + " Alfanumerico");
				}
			} catch (Exception e) {
				System.out.println("Solo debe ingresar caracteres alfanumericos");
				sc.nextLine();
			}
		} while (loop);
	}

	public static void selectMonth(Efemeride e) {
		boolean loop = true;

		Mes[] months = Mes.values();
		for (int i = 0; i < months.length; i++) {
			System.out.println("[" + (i + 1) + "]: " + months[i]);
		}
		System.out.println();
		do {

			try {
				System.out.println("Ingrese el numero correspondiente al MES: ");
				int n = sc.nextInt();
				if (n > 0 && n <= months.length) {
					e.setMonth(months[n - 1]);
					loop = false;
				} else {
					System.out.println("Numero Invalido, intente nuevamente");
				}
			} catch (Exception wrong) {
				System.err.println("Debe ingresar solo valores numericos");
				sc.nextLine();
			}
		} while (loop);

	}

	public static void checkDay(Efemeride e) {
		int day;
		boolean loop = true;

		do {
			System.out.println("Ingrese un dia entre 1 y 31");

			try {
				day = sc.nextInt();

				if (day > 0 && day < 32) {
					e.setDay(day);
					loop = false;
				} else {
					System.out.println("Error, Solo Dias entre 1 - 31 son Validos");
				}

			} catch (Exception wrong) {
				System.err.println("Ingrese solo valores numericos entre 1 - 31");
				sc.nextLine();
			}
		} while (loop);
	}

	public static void newEfemeride(ArrayList<Efemeride> efemerides) {

		Efemeride e = new Efemeride();

		checkString("Codigo");
		e.setCode(x);
		selectMonth(e);
		checkDay(e);
		checkString("Detalle");
		e.setDatail(x);

		efemerides.add(e);
		System.out.println("Nueva Efemeride Registrada Exitosamente");
	}

	public static void deletEfemeride(ArrayList<Efemeride> efemerides) {
		ArrayList<Efemeride> aux = new ArrayList<>();
		boolean exist = false;

		System.out.println("Eliminar Edemeride - codigos disponibles");
		for (Efemeride e : efemerides) {
			System.out.print(e.getCode() + " ");
		}
		System.out.println();

		checkString("Codigo");

		if (efemerides.size() != 0) {
			for (Efemeride e : efemerides) {
				if (!e.getCode().equals(x)) {
					aux.add(e);
				} else {
					exist = true;
				}
			}
			if (exist) {
				efemerides.removeAll(efemerides);
				efemerides.addAll(aux);
				System.out.println("Eliminacion exitosa");
			} else {
				System.out.println("No existe el codigo ingresado");
			}

		} else {
			System.out.println("No hay Efemerides registradas aun");
		}
	}

	public static void modifyEfemeride(ArrayList<Efemeride> efemerides) {
		boolean change = false;

		System.out.println("Modificar Edemeride - codigos disponibles");
		for (Efemeride e : efemerides) {
			System.out.print(e.getCode() + " ");
		}
		System.out.println();

		checkString("Codigo");

		if (efemerides.size() != 0) {
			for (Efemeride e : efemerides) {
				if (e.getCode().equals(x)) {
					selectMonth(e);
					change = true;
				}
			}
		}

		if (change) {
			System.out.println("Modificacion del MES Exitoso");
		} else {
			System.err.println("No existe ninguna efemeride con ese codigo");
		}
	}
}
