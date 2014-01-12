package seminarioTp.productos



import static org.springframework.http.HttpStatus.*
import productos.TipoProducto;
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoProductoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoProducto.list(params), model:[tipoProductoInstanceCount: TipoProducto.count()]
    }

    def show(TipoProducto tipoProductoInstance) {
        respond tipoProductoInstance
    }

    def create() {
        respond new TipoProducto(params)
    }

    @Transactional
    def save(TipoProducto tipoProductoInstance) {
        if (tipoProductoInstance == null) {
            notFound()
            return
        }

        if (tipoProductoInstance.hasErrors()) {
            respond tipoProductoInstance.errors, view:'create'
            return
        }

        tipoProductoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoProductoInstance.label', default: 'TipoProducto'), tipoProductoInstance.id])
                redirect tipoProductoInstance
            }
            '*' { respond tipoProductoInstance, [status: CREATED] }
        }
    }

    def edit(TipoProducto tipoProductoInstance) {
        respond tipoProductoInstance
    }

    @Transactional
    def update(TipoProducto tipoProductoInstance) {
        if (tipoProductoInstance == null) {
            notFound()
            return
        }

        if (tipoProductoInstance.hasErrors()) {
            respond tipoProductoInstance.errors, view:'edit'
            return
        }

        tipoProductoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoProducto.label', default: 'TipoProducto'), tipoProductoInstance.id])
                redirect tipoProductoInstance
            }
            '*'{ respond tipoProductoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoProducto tipoProductoInstance) {

        if (tipoProductoInstance == null) {
            notFound()
            return
        }

        tipoProductoInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoProducto.label', default: 'TipoProducto'), tipoProductoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoProductoInstance.label', default: 'TipoProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
