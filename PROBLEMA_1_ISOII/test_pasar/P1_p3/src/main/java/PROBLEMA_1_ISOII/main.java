package PROBLEMA_1_ISOII;


public class main {
	public static void main(String[] args) {
		Consola io = new Consola();

		try {

			int añoEntrada = io.leerInt("Por favor, introduzca un año:");

			Fecha fecha = new Fecha(añoEntrada);

			boolean esBisiesto = fecha.esBisiesto();

			if (esBisiesto) {
				io.escribir("El año " + fecha.getAnio() + " es bisiesto.");
			} else {
				io.escribir("El año " + fecha.getAnio() + " no es bisiesto.");
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