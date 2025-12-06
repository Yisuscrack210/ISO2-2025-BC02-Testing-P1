package PROBLEMA_1_ISOII;

import PROBLEMA_1_ISOII.Consola;
import PROBLEMA_1_ISOII.Fecha;

/**
 * Clase principal que orquesta la ejecución. Une el Dominio y la IU sin que se
 * conozcan entre sí directamente.
 */
public class main {
	public static void main(String[] args) {
		Consola io = new Consola();

		try {

			// 1. Lectura de datos usando el componente de IU
			// Aquí se captura la excepción de formato (letras en vez de números)
			int añoEntrada = io.leerInt("Por favor, introduzca un año:");

			// 2. Instanciación del dominio
			// Aquí se captura la excepción de lógica (números negativos) lanzada por el
			// constructor
			Fecha fecha = new Fecha(añoEntrada);

			// 3. Ejecución de lógica
			boolean esBisiesto = fecha.esBisiesto();

			// 4. Salida de resultados
			if (esBisiesto) {
				io.escribir("El año " + fecha.getAño() + " es bisiesto.");
			} else {
				io.escribir("El año " + fecha.getAño() + " no es bisiesto.");
			}

		} catch (NumberFormatException e) {
			// Manejo de error por letras/formato
			io.escribir(e.getMessage());
		} catch (IllegalArgumentException e) {
			// Manejo de error por lógica de negocio (negativos)
			io.escribir(e.getMessage());
		} catch (Exception e) {
			io.escribir(e.getMessage());
		}
	}
}