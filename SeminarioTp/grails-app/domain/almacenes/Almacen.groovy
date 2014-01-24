package almacenes

import productos.Producto;
import productos.Tamanio;
import productos.TipoProducto;

class Almacen {

	String nombre
	Tamanio capacidadMaxima
	List<TipoProducto> tiposDeProductosAdmitidos
	List<Producto> productosEnStock
	List<MovimientoAlmacen> movimientosRealizados
	List<LimpiezaAlmacen> limpiezasRealizadas
	
	static hasMany = [ tiposDeProductosAdmitidos: TipoProducto, 
										productosEnStock: Producto, 
										movimientosRealizados: MovimientoAlmacen, 
										limpiezasRealizadas: LimpiezaAlmacen ]

    static constraints = {
		nombre blank:false
    }
	
	static mapping = {
		sort nombre:"asc"
	}
	
	/**
	 * Efectua una operación que modifica el stock sobre este almacen.
	 * @param movimiento
	 */
	void efectuarMovimiento(MovimientoAlmacen movimiento){
		
	}
	
	/**
	 * Efectua una operación de limpieza sobre este almacen.
	 */
	void limpiar() {
		
	}
	
	/**
	 * Devuelve <code>true</code> si el producto cabe en éste almacen.
	 * @param producto
	 * @return
	 */
	Boolean productoCabe(Producto producto) {
		Tamanio ocupacion = new Tamanio()
		for(Producto eachProducto : this.getProductosEnStock()) {
			ocupacion = Tamanio.sumarTamanio(ocupacion, eachProducto)
		}
		//El producto cabe si la capacidad maxima del almacen es mayor o igual a  
		//la suma de los tamaños de los productos en stock mas el tamaño del nuevo producto.
		if (this.getCapacidadMaxima().compareTo(Tamanio.sumarTamanio(ocupacion, producto.getTamanio()))>=0) {
			return true
		}
		else {
			return false
		}
	}
	
	/**
	 * Devuelve <code>true</code> si éste almacen necesita limpiarse.
	 * @return
	 */
	Boolean debeLimpiarse() {
		
	}
	
	/**
	 * Devuelve el listado de productos a vencer respecto a la fecha de referencia.
	 * @return
	 */
	List<Producto> obtenerProductosAVencer(Date fechaReferencia){
		
	}
	
	@Override
	public String toString() {
		return this.getNombre()
	}
}
