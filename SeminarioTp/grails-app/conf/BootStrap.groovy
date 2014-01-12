import almacenes.CausaMovimiento;
import almacenes.DireccionMovimiento;
import almacenes.TipoMovimiento;
import productos.EstadoProducto;
import productos.Tamanio;
import productos.TipoProducto;

class BootStrap {

    def init = { servletContext ->
		if (!TipoProducto.count()) {
			new TipoProducto(nombre: "Huevo blanco super", descripcion: "Cajon de huevo blanco super").save()
			new TipoProducto(nombre: "Huevo color super", descripcion: "Cajon de huevo color super").save()
			new TipoProducto(nombre: "Huevo blanco 1", descripcion: "Cajon de huevo blanco 1").save()
			new TipoProducto(nombre: "Huevo blanco 2", descripcion: "Cajon de huevo blanco 2").save()
			new TipoProducto(nombre: "Huevo blanco 3", descripcion: "Cajon de huevo blanco 3").save()
			new TipoProducto(nombre: "Huevo color 1", descripcion: "Cajon de huevo color 1").save()
			new TipoProducto(nombre: "Huevo color 2", descripcion: "Cajon de huevo color 2").save()
			new TipoProducto(nombre: "Huevo color 3", descripcion: "Cajon de huevo color 3").save()
		}
		if  (!Tamanio.count()) {
			new Tamanio(alto:  1, ancho: 1 ).save()
			new Tamanio(alto:  2, ancho: 2 ).save()
			new Tamanio(alto:  3, ancho: 3 ).save()
		}
		if (!EstadoProducto.count()) {
			new EstadoProducto(descripcion: "Normal").save()
			new EstadoProducto(descripcion: "Vencido").save()
		}

		TipoMovimiento entrada = new TipoMovimiento(descripcion: "Entrada", direccion: DireccionMovimiento.ADENTRO).save()
		TipoMovimiento salida = new TipoMovimiento(descripcion: "Salida", direccion: DireccionMovimiento.AFUERA).save()
	
		new CausaMovimiento(descripcion: "Venta a cliente", tipoMovimiento: salida).save()
		new CausaMovimiento(descripcion: "Compra a proveedor", tipoMovimiento: entrada).save()
		new CausaMovimiento(descripcion: "Vencimiento de producto", tipoMovimiento: salida).save()
		new CausaMovimiento(descripcion: "Rotura de producto", tipoMovimiento: salida).save()

    }
    def destroy = {
    }
}
