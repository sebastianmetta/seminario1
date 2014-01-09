package almacenes

import seminarioTp.productos.Producto;

class MovimientoAlmacen {

	Date fecha = new Date()
	CausaMovimiento causa
	static hasMany =  [productos : Producto]
	
    static constraints = {
    }
}
