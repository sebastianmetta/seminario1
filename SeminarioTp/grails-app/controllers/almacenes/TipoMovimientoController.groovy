package almacenes



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoMovimientoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoMovimiento.list(params), model:[tipoMovimientoInstanceCount: TipoMovimiento.count()]
    }

    def show(TipoMovimiento tipoMovimientoInstance) {
        respond tipoMovimientoInstance
    }

    def create() {
        respond new TipoMovimiento(params)
    }

    @Transactional
    def save(TipoMovimiento tipoMovimientoInstance) {
        if (tipoMovimientoInstance == null) {
            notFound()
            return
        }

        if (tipoMovimientoInstance.hasErrors()) {
            respond tipoMovimientoInstance.errors, view:'create'
            return
        }

        tipoMovimientoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoMovimientoInstance.label', default: 'TipoMovimiento'), tipoMovimientoInstance.id])
                redirect tipoMovimientoInstance
            }
            '*' { respond tipoMovimientoInstance, [status: CREATED] }
        }
    }

    def edit(TipoMovimiento tipoMovimientoInstance) {
        respond tipoMovimientoInstance
    }

    @Transactional
    def update(TipoMovimiento tipoMovimientoInstance) {
        if (tipoMovimientoInstance == null) {
            notFound()
            return
        }

        if (tipoMovimientoInstance.hasErrors()) {
            respond tipoMovimientoInstance.errors, view:'edit'
            return
        }

        tipoMovimientoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoMovimiento.label', default: 'TipoMovimiento'), tipoMovimientoInstance.id])
                redirect tipoMovimientoInstance
            }
            '*'{ respond tipoMovimientoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoMovimiento tipoMovimientoInstance) {

        if (tipoMovimientoInstance == null) {
            notFound()
            return
        }

        tipoMovimientoInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoMovimiento.label', default: 'TipoMovimiento'), tipoMovimientoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoMovimientoInstance.label', default: 'TipoMovimiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
