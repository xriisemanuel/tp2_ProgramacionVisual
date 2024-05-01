package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {

	JUJUY(770000, 53219), SALTA(1800000, 155488), TUCUMAN(1600000, 22524), CATAMARCA(400000, 102602),
	LA_RIOJA(380000, 89680), SANTIAGO_DEL_ESTERO(900000, 136351);

	private final int poblacion;
	private final int superficie;
	private Provincia(int poblacion, int superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	// only getter can be created on "enum" classes.
	public int getPoblacion() {
		return poblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public double calcularDensidadPoblacional() {
		return (double) poblacion / superficie;
	}

}