package productos

class EstadoProducto {

	String descripcion
	
    static constraints = {
		descripcion blank:false 
    }
	
	String toString() {
		return this.getDescripcion()
	}
}
