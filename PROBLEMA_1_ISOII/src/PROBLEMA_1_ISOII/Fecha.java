package PROBLEMA_1_ISOII;

public class Fecha {

	private int año;

	public Fecha(int año) {
		this.setAño(año);
	}

	private void setAño(int año) {
		if (año < 0) {
			throw new IllegalArgumentException("El año no puede ser negativo.");
		}
		this.año = año;
	}

	public int getAño() {
		return año;
	}

	public boolean esBisiesto() {
		return (this.año % 4 == 0) && ((this.año % 100 != 0) || (this.año % 400 == 0));
	}
}
