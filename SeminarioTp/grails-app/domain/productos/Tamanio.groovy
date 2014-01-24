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
	
	public static double calcularArea(Tamanio tamanio) {
		return tamanio.getAlto() * tamanio.getAncho()
	}
	
	@Override
	public int compareTo(Tamanio o) {
		double thisArea = Tamanio.calcularArea(this)
		double otherArea = Tamanio.calcularArea(o)
		if (thisArea < otherArea) return -1
		if (thisArea > otherArea) return 1
		return 0;
	}
	
	String toString() {
		return this.getAncho().toString().concat(" x ").concat(this.getAlto().toString())
	}
	
	/**
	 * Suma al tamanio 'base', 'otro', y devuelve el tamaño resultante.
	 * @param base Tamaño al cual sumar
	 * @param otro Tamaño a sumar
	 * @return Tamaño resultante
	 */
	public static Tamanio sumarTamanio(Tamanio base, Tamanio otro) {
		base.setAlto(this.getAlto() + otro.getAlto())
		base.setAncho(this.getAncho() + otro.getAncho())
		return base
	}
}
