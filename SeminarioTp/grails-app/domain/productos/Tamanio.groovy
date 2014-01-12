package productos

class Tamanio implements Comparable<Tamanio> {

	/**
	 * Alto expresado en metros
	 */
	double alto
	/**
	 * Ancho expresado en metros
	 */
	double ancho
	
    static constraints = {

    }
	
	public static double calculateArea(Tamanio tamanio) {
		return tamanio.getAlto() * tamanio.getAncho()
	}
	
	@Override
	public int compareTo(Tamanio o) {
		double thisArea = Tamanio.calculateArea(this)
		double otherArea = Tamanio.calculateArea(o)
		if (thisArea < otherArea) return -1
		if (thisArea > otherArea) return 1
		return 0;
	}
	
	String toString() {
		return this.getAncho().toString().concat(" x ").concat(this.getAlto().toString())
	}
}
