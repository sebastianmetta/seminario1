package almacenes

import infraestructura.Operario;

class LimpiezaAlmacen {

	Date fecha
	Operario encargado
	static belongsTo = [ almacen : Almacen ]
	String observaciones
	
    static constraints = {
		fecha blank:false 
		encargado blank:false
		observaciones blank:true, nullable:true 
    }
	
	
}
