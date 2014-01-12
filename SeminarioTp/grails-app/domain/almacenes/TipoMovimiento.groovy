package almacenes

class TipoMovimiento {
	
	String descripcion
	DireccionMovimiento direccion
	
	static constraints = {
		descripcion blank:false
		direccion nullable:false 
	}
    
	String toString() {
		if (this.getDireccion().equals(DireccionMovimiento.ADENTRO)) 
			return   ">> ".concat(this.getDescripcion())
		else
			return "<< ".concat(this.getDescripcion())
	}
}
