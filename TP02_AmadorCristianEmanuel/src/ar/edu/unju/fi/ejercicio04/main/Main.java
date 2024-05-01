package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
	public static String x;
	public static float f;

	public static void main(String[] args) {
		
		ArrayList<Jugador> gamers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		int option = 0;

		do {
			menu();
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					signIn(gamers);
					break;
				case 2:
					for (Jugador j : gamers) {
						System.out.println(j.toString());
					}
					break;
				case 3:
					modify(gamers);
					break;
				case 4:
					delete(gamers);
					break;
				case 5:
					System.out.println("Program stopped");
					break;
				default:
					System.out.println("Opcion Incorrecta, intente nuevamente");
				}
			} catch (Exception e) {
				System.out.println("Solo debe ingresar NUMEROS");
				sc.nextLine();
			}

		} while (option != 5);

	}

	public static void menu() {
		System.out.println("\n*** Menu Principal ***");
		System.out.println("1 - Registrar un nuevo jugador");
		System.out.println("2 - Mostrar jugadores registrados");
		System.out.println("3 - Cambiar la posicion de un jugador");
		System.out.println("4 - Eliminar un jugador");
		System.out.println("5 - Salir");
		System.out.print("Ingrese una opcion: ");
	}

	public static void checkString(String s) {

		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		do {
			try {
				System.out.println("Ingrese " + s + ": ");
				x = scanner.next();
				if (x.matches("[a-zA-Z]+")) {
					loop = false;
				} else {
					System.out.println("Ingrese " + s + " Alfanumerico");
				}
			} catch (Exception e) {
				System.out.println("Solo debe ingresar caracteres alfanumericos");
			}

		} while (loop);
	}

	public static void setAge(Jugador j) {
		Scanner s = new Scanner(System.in);
		int d, m, y;
		boolean loop = true;
		do {
			try {
				System.out.println("\nFecha de Nacimiento");
				System.out.println("Ingrese el dia: ");
				d = s.nextInt();

				if (d > 0 && d < 31) {
					System.out.println("Ingrese el mes: ");
					m = s.nextInt();

					if (m > 0 && m < 12) {
						System.out.println("Ingrese el anio: ");
						y = s.nextInt();

						if (y > 0 && y < 2025) {
							j.setDate(LocalDate.of(y, m, d));
							loop = false;
						} else {
							System.out.println("Anio Inexistente, intente nuevamente");
						}
					} else {
						System.out.println("Meses fuera de rango, intente nuevamente");
					}
				} else {
					System.out.println("Dias fuera de rango, intente nuevamente");
				}
			} catch (Exception e) {
				System.err.println("INGRESE UNICAMENTE VALORES NUMERICOS");
			}
		} while (loop);
	}

	public static void checkFloat(String s) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;

		do {
			try {
				System.out.println("Ingrese su " + s + ": ");
				f = sc.nextFloat();

				if (f > 0) {
					loop = false;
				} else {
					System.err.println("Debe Ingresar valores positivos");
				}

			} catch (Exception e) {
				System.err.println("Ingrese, unicamente valores numericos positivos");
			}
		} while (loop);
	}

	public static void selectPosition(Jugador j) {

		Posicion[] pos = Posicion.values();
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		do {
			try {
				for (int i = 0; i < pos.length; i++) {
					System.out.println("[" + (i + 1) + "] - " + pos[i]);
				}
				System.out.println("Ingresa un numero correspondiente a la posicion: ");
				int x = sc.nextInt();

				if (x > 0 && x <= pos.length) {
					j.setPosition(pos[x - 1]);
					loop = false;
				} else {
					System.out.println("Opcion Inexistente, reintente nuevamente");
				}

			} catch (Exception e) {
				System.err.println("SOLO SE PERMITEN VALORES NUMERICOS ENTEROS");
			}
		} while (loop);
	}

	public static void signIn(ArrayList<Jugador> gamers) {
		Jugador gamer = new Jugador();
		checkString("nombre");
		gamer.setName(x);
		checkString("apellido");
		gamer.setLastname(x);
		setAge(gamer);
		checkString("nacionalidad");
		gamer.setNationality(x);
		checkFloat("altura");
		gamer.setHigh(f);
		checkFloat("peso");
		gamer.setWeight(f);
		selectPosition(gamer);

		gamers.add(gamer);
		System.out.println("Nuevo Jugador Registrado");
	}

	public static void modify(ArrayList<Jugador> gamers) {
		Jugador aux = new Jugador();
		checkString("nombre");
		aux.setName(x);
		checkString("apellido");
		aux.setLastname(x);
		boolean exist = false;

		for (Jugador j : gamers) {
			if (j.getName().equals(aux.getName()) && j.getLastname().equals(aux.getLastname())) {
				selectPosition(j);
				exist = true;
				break;
			}
		}

		if (exist) {
			System.out.println("Modificacion realizada");
		} else {
			System.out.println("No existe el Jugador");
		}
	}

	public static void delete(ArrayList<Jugador> gamers) {
		
		Iterator<Jugador> iterador = gamers.iterator();
		Jugador aux = new Jugador();
		checkString("nombre");
		aux.setName(x);
		checkString("apellido");
		aux.setLastname(x);

		while (iterador.hasNext()) {
			Jugador j = iterador.next();
			if (j.getName().equals(aux.getName()) && j.getLastname().equals(aux.getLastname())) {
				iterador.remove();
			}
		}
		
		System.out.println("Jugador Eliminado Existosamente");
	}
}
