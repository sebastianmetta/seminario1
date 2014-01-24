package infraestructura

class Operario {

	String nombre
	Date fechaDeNacimiento
	
    static constraints = {
		nombre blank:false 
		fechaDeNacimiento nullable:false 
    }
	
	String toString() {
		return this.getNombre()
	}
}
