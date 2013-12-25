package seminarioTp.productos

class TipoProducto {

	String nombre
	String descripcion
	
    static constraints = {
		nombre (blank:false) 
		descripcion () 
    }
}
