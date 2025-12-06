package PROBLEMA_1_ISOII;

public class Fecha {

	private int anio;

	public Fecha(int anio) {
		this.setAnio(anio);
	}

	private void setAnio(int anio) {
		if (anio < 0) {
			throw new IllegalArgumentException("El año no puede ser negativo.");
		}
		this.anio =anio;
	}

	public int getAnio() {
		return anio;
	}

	public boolean esBisiesto() {
		return (this.anio % 4 == 0) && ((this.anio % 100 != 0) || (this.anio % 400 == 0));
	}
}
