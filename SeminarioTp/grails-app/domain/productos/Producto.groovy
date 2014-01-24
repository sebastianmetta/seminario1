package productos

import groovy.time.TimeCategory

class Producto {

	String nombre
	Date fechaVencimiento = this.getFechaVencimientoPorDefecto()
	TipoProducto tipoProducto
	Tamanio tamanio
	EstadoProducto estado

	static constraints = {
		nombre  (blank:false)
		//TODO: Fecha de vencimiento mayor a la actual. Tipo producto y tamaños validos.
	}
	
	/**
	 * Devuelve <code>true</code> si el producto tiene fecha de vencimiento menor a <code>compararContra</code>.
	 * @param compararContra Fecha contra la cual comparar el vencimiento.
	 * @return <code>true</code> si está vencido. <code>false</code> de lo contrario.
	 */
	Boolean estaVencido(Date compararContra) {
		return (this.getFechaVencimiento().compareTo(compararContra)>0);
	}
		
	/**
	 * Devuelve <code>true</code> si el producto tiene fecha de vencimiento menor a la fecha actual.
	 * @return <code>true</code> si está vencido. <code>false</code> de lo contrario.
	 */
	Boolean estaVencido() {
		estaVencido(new Date())
	}
	
	String toString() {
		return this.getNombre()
	}
	
	/**
	 * Por defecto se establece que la fecha de vencimiento es 1 mes a partir del alta.
	 * @return
	 */
	Date getFechaVencimientoPorDefecto() {
		GregorianCalendar cal = new GregorianCalendar() 
		cal.setTime(new Date()) 
		cal.add(Calendar.MONTH,1) 
		return cal.getTime() 
	}
}
