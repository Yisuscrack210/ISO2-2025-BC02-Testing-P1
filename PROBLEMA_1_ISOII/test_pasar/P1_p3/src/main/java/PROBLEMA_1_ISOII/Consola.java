package PROBLEMA_1_ISOII;

import java.util.Scanner;

public class Consola {

	private final Scanner scanner;

	public Consola() {
		this.scanner = new Scanner(System.in);
	}

	public void escribir(Object mensaje) {
		System.out.println(mensaje);
	}

	public int leerInt(String mensaje) throws NumberFormatException {
		this.escribir(mensaje);
		String entrada = scanner.nextLine();

		try {
			return Integer.parseInt(entrada);
		} catch (NumberFormatException e) {

			throw new NumberFormatException("Error: La entrada '" + entrada + "' contiene caracteres no válidos.");
		}
	}

	public double leerDouble(String mensaje) {
		this.escribir(mensaje);
		try {
			return Double.parseDouble(scanner.nextLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Error: Entrada no válida para un número decimal.");
		}
	}

	public String leerCadena(String mensaje) {
		this.escribir(mensaje);
		return scanner.nextLine();

	}
}