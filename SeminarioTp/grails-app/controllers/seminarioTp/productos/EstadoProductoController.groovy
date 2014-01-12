package seminarioTp.productos



import static org.springframework.http.HttpStatus.*
import productos.EstadoProducto;
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EstadoProductoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EstadoProducto.list(params), model:[estadoProductoInstanceCount: EstadoProducto.count()]
    }

    def show(EstadoProducto estadoProductoInstance) {
        respond estadoProductoInstance
    }

    def create() {
        respond new EstadoProducto(params)
    }

    @Transactional
    def save(EstadoProducto estadoProductoInstance) {
        if (estadoProductoInstance == null) {
            notFound()
            return
        }

        if (estadoProductoInstance.hasErrors()) {
            respond estadoProductoInstance.errors, view:'create'
            return
        }

        estadoProductoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'estadoProductoInstance.label', default: 'EstadoProducto'), estadoProductoInstance.id])
                redirect estadoProductoInstance
            }
            '*' { respond estadoProductoInstance, [status: CREATED] }
        }
    }

    def edit(EstadoProducto estadoProductoInstance) {
        respond estadoProductoInstance
    }

    @Transactional
    def update(EstadoProducto estadoProductoInstance) {
        if (estadoProductoInstance == null) {
            notFound()
            return
        }

        if (estadoProductoInstance.hasErrors()) {
            respond estadoProductoInstance.errors, view:'edit'
            return
        }

        estadoProductoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EstadoProducto.label', default: 'EstadoProducto'), estadoProductoInstance.id])
                redirect estadoProductoInstance
            }
            '*'{ respond estadoProductoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EstadoProducto estadoProductoInstance) {

        if (estadoProductoInstance == null) {
            notFound()
            return
        }

        estadoProductoInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EstadoProducto.label', default: 'EstadoProducto'), estadoProductoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoProductoInstance.label', default: 'EstadoProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
