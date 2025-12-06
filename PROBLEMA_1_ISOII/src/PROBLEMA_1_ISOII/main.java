package PROBLEMA_1_ISOII;

import PROBLEMA_1_ISOII.Consola;
import PROBLEMA_1_ISOII.Fecha;

public class main {
	public static void main(String[] args) {
		Consola io = new Consola();

		try {

			int añoEntrada = io.leerInt("Por favor, introduzca un año:");

			Fecha fecha = new Fecha(añoEntrada);

			boolean esBisiesto = fecha.esBisiesto();

			if (esBisiesto) {
				io.escribir("El año " + fecha.getAño() + " es bisiesto.");
			} else {
				io.escribir("El año " + fecha.getAño() + " no es bisiesto.");
			}

		} catch (NumberFormatException e) {
			io.escribir(e.getMessage());
		} catch (IllegalArgumentException e) {
			io.escribir(e.getMessage());
		} catch (Exception e) {
			io.escribir(e.getMessage());
		}
	}
}
