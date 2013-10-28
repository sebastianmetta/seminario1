package seminariotp

class Producto {

	String nombre
	Date fechaVencimiento = new Date()
	TipoProducto tipo

	static constraints = {
		nombre  (blank:false)
		fechaVencimiento (unique:false)
		tipo (unique:true) 
	}
}
