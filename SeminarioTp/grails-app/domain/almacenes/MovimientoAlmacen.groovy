package almacenes

import productos.Producto;

class MovimientoAlmacen {

	Date fecha = new Date()
	CausaMovimiento causa
	List<Producto> productos
	
	static belongsTo = [ almacen : Almacen ]
	static hasMany =  [ productos : Producto ]
	
    static constraints = {
		almacen()
		fecha nullable:false 
		causa nullable:false
		productos() 
    }
	
	/**
	 * Devuelve <code>true</code> si todos los productos asociados al movimiento admiten el mismo. De lo contrario, <code>false</code>.
	 */
	boolean productosAdmitenMovimiento(){
		for(Producto eachProducto : this.getProductos()){
			if(eachProducto.getFechaVencimiento().compareTo(new Date())<0) {
				return false
			}
		}
		return true
	}
	
	
	String toString(){
		return this.getFecha().toString().concat(" ").concat(this.getCausa().toString())
	}
	
}
