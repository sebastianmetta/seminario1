package seminarioTp.productos

class Producto {

	String nombre
	Date fechaVencimiento = new Date()
	TipoProducto tipoProducto
	Tamanio tamanio
	EstadoProducto estado

	static constraints = {
		nombre  (blank:false)
		fechaVencimiento (unique:false)
		tipoProducto (unique:true) 
	}

	/**
	 * Devuelve <code>true</code> si el producto tiene fecha de vencimiento menor a <code>compararContra</code>.
	 * @param compararContra Fecha contra la cual comparar el vencimiento.
	 * @return <code>true</code> si está vencido. <code>false</code> de lo contrario.
	 */
	Boolean estaVencido(Date compararContra) {
		return (fechaVencimiento.compareTo(compararContra)>0);
	}
		
	/**
	 * Devuelve <code>true</code> si el producto tiene fecha de vencimiento menor a la fecha actual.
	 * @return <code>true</code> si está vencido. <code>false</code> de lo contrario.
	 */
	Boolean estaVencido() {
		estaVencido(new Date())
	}
}
