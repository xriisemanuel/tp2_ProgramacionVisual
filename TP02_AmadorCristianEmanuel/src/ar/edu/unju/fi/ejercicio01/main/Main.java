package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Category;
import ar.edu.unju.fi.ejercicio01.model.Producto.MadeIn;

public class Main {
	public static String x;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int o = 0;
		ArrayList<Producto> products = new ArrayList<Producto>();

		do {
			menu();
			try {
				o = sc.nextInt();

				switch (o) {
				case 1:
					newProduct(products);
					break;
				case 2:
					for (Producto x : products) {
						System.out.println(x.toString());
					}
					break;
				case 3:
					modifyValues(products);
					break;
				case 4:
					System.out.println("program sttoped");
					break;
				default:
					System.out.println("Debe ingresar una opcion valida");
				}
			} catch (Exception x) {
				System.err.println("WRONG, Only Numbers Please");
				sc.nextLine();
			}

		} while (o != 4);
		sc.close();
	}

	public static void menu() {
		System.out.println("\n***[ Menu de Opciones ]***");
		System.out.println("1. Crear Producto");
		System.out.println("2. Mostrar Productos");
		System.out.println("3. Modificar productos");
		System.out.println("4. Salir");
		System.out.println("Ingrese una opcion: ");
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
			}

		} while (loop);
	}

	public static void checkPrice(Producto p) {
		boolean loop = true;
		float f;

		do {
			try {
				System.out.println("Ingrese el precio del producto: ");
				f = sc.nextFloat();

				if (f > 0) {
					p.setPrice(f);
					loop = false;
				} else {
					System.out.println("Debe Ingresar un precio mayor a cero.");
				}

			} catch (Exception e) {
				System.err.println("Ingrese, unicamente valores numericos positivos");
				sc.nextLine();
			}
		} while (loop);
	}

	public static void selectMadeIn(Producto p) {
		boolean loop = true;
		MadeIn[] made = Producto.MadeIn.values();
		
		for (int i = 0; i < made.length; i++) {
			System.out.println("[" + (i + 1) + "]: " + made[i]);
		}

		do {

			try {
				System.out.println("Ingrese el numero correspondiente al pais: ");
				int n = sc.nextInt();
				if (n > 0 && n <= made.length) {
					p.setMadeIn(made[n - 1]);
					loop = false;
				} else {
					System.out.println("Numero Invalido, intente nuevamente");
				}
			} catch (Exception e) {
				System.err.println("Debe ingresar solo valores numericos");
				sc.nextLine();
			}
		} while (loop);

	}

	public static void selectCategory(Producto p) {
		Boolean loop = true;
		Category[] made = Producto.Category.values();

		for (int i = 0; i < made.length; i++) {
			System.out.println("[" + (i + 1) + "] " + made[i]);
		}

		do {
			try {
				System.out.println("Ingrese el numero de la categoria: ");
				int n = sc.nextInt();
				if (n > 0 && n <= made.length) {
					p.setCat(made[n - 1]);
					loop = false;
				} else {
					System.out.println("Numero Invalido, intente nuevamente");
				}
			} catch (Exception e) {
				System.err.println("Debe ingresar solo valores numericos");
				sc.nextLine();
			}
		} while (loop);
	}

	public static void newProduct(ArrayList<Producto> products) {

		Producto p = new Producto();

		checkString("Codigo");
		p.setCode(x);
		checkString("Descripcion");
		p.setDesc(x);
		checkPrice(p);
		selectMadeIn(p);
		selectCategory(p);

		products.add(p);
		System.out.println("Nuevo Producto Registrado Exitosamente");
	}

	public static void modify(Producto p) {
		int op;
		boolean loop = true;

		do {
			System.out.println("Ingrese el valor que desea modificar: ");
			System.out.println("1 - Descripcion");
			System.out.println("2 - Precio Unitario");
			System.out.println("3 - Origen de fabricacion");
			System.out.println("4 - Categoria");
			System.out.println("Opcion: ");

			try {
				op = sc.nextInt();
				switch (op) {
				case 1:
					System.out.println("Ingrese la nueva descripcion: ");
					checkString("Descripcion");
					p.setDesc(x);
					loop = false;
					break;
				case 2:
					System.out.println("Ingrese el nuevo Precio: ");
					checkPrice(p);
					loop = false;
					break;
				case 3:
					System.out.println("Ingrese el nuevo Origen: ");
					selectMadeIn(p);
					loop = false;
					break;
				case 4:
					System.out.println("Ingrese la nueva categoria: ");
					selectCategory(p);
					loop = false;
					break;
				default:
					System.out.println("Debe ingresar una opcion valida");
				}
			} catch (Exception e) {
				System.out.println("Ingrese una opcion numerica valida");
				sc.nextLine();
			}
		} while (loop);
	}

	public static void modifyValues(ArrayList<Producto> products) {
		boolean exists = false;
		
		if (products.size() != 0) {

			for (Producto x : products) {
				System.out.print("[" + x.getCode() + "] ");
			}

			System.out.println("Ingrese el codigo del producto que desea modificar: ");
			checkString("Codigo");

			for (Producto p : products) {
				if (p.getCode().equals(x)) {
					modify(p);
					exists = true;
					break;
				}
			}

			if (!exists) {
				System.err.println("No Existe El Codigo Ingresado");
			} else {
				System.out.println("¡La modificacion fue exitosa!");
			}

		} else {
			System.out.println("No Existen Productos Registrados");
		}
	}
}