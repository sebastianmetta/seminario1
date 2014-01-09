package almacenes

class CausaMovimiento {

	String descripcion
	TipoMovimiento tipoMovimiento
	
    static constraints = {
		descripcion blank:false
		tipoMovimiento nullable:false 
    }
}
