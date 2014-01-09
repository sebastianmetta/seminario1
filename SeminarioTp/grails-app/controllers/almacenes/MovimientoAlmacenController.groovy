package almacenes



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MovimientoAlmacenController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MovimientoAlmacen.list(params), model:[movimientoAlmacenInstanceCount: MovimientoAlmacen.count()]
    }

    def show(MovimientoAlmacen movimientoAlmacenInstance) {
        respond movimientoAlmacenInstance
    }

    def create() {
        respond new MovimientoAlmacen(params)
    }

    @Transactional
    def save(MovimientoAlmacen movimientoAlmacenInstance) {
        if (movimientoAlmacenInstance == null) {
            notFound()
            return
        }

        if (movimientoAlmacenInstance.hasErrors()) {
            respond movimientoAlmacenInstance.errors, view:'create'
            return
        }

        movimientoAlmacenInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'movimientoAlmacenInstance.label', default: 'MovimientoAlmacen'), movimientoAlmacenInstance.id])
                redirect movimientoAlmacenInstance
            }
            '*' { respond movimientoAlmacenInstance, [status: CREATED] }
        }
    }

    def edit(MovimientoAlmacen movimientoAlmacenInstance) {
        respond movimientoAlmacenInstance
    }

    @Transactional
    def update(MovimientoAlmacen movimientoAlmacenInstance) {
        if (movimientoAlmacenInstance == null) {
            notFound()
            return
        }

        if (movimientoAlmacenInstance.hasErrors()) {
            respond movimientoAlmacenInstance.errors, view:'edit'
            return
        }

        movimientoAlmacenInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MovimientoAlmacen.label', default: 'MovimientoAlmacen'), movimientoAlmacenInstance.id])
                redirect movimientoAlmacenInstance
            }
            '*'{ respond movimientoAlmacenInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MovimientoAlmacen movimientoAlmacenInstance) {

        if (movimientoAlmacenInstance == null) {
            notFound()
            return
        }

        movimientoAlmacenInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MovimientoAlmacen.label', default: 'MovimientoAlmacen'), movimientoAlmacenInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'movimientoAlmacenInstance.label', default: 'MovimientoAlmacen'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
