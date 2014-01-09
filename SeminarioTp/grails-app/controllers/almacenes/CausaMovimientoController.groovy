package almacenes



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CausaMovimientoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CausaMovimiento.list(params), model:[causaMovimientoInstanceCount: CausaMovimiento.count()]
    }

    def show(CausaMovimiento causaMovimientoInstance) {
        respond causaMovimientoInstance
    }

    def create() {
        respond new CausaMovimiento(params)
    }

    @Transactional
    def save(CausaMovimiento causaMovimientoInstance) {
        if (causaMovimientoInstance == null) {
            notFound()
            return
        }

        if (causaMovimientoInstance.hasErrors()) {
            respond causaMovimientoInstance.errors, view:'create'
            return
        }

        causaMovimientoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'causaMovimientoInstance.label', default: 'CausaMovimiento'), causaMovimientoInstance.id])
                redirect causaMovimientoInstance
            }
            '*' { respond causaMovimientoInstance, [status: CREATED] }
        }
    }

    def edit(CausaMovimiento causaMovimientoInstance) {
        respond causaMovimientoInstance
    }

    @Transactional
    def update(CausaMovimiento causaMovimientoInstance) {
        if (causaMovimientoInstance == null) {
            notFound()
            return
        }

        if (causaMovimientoInstance.hasErrors()) {
            respond causaMovimientoInstance.errors, view:'edit'
            return
        }

        causaMovimientoInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CausaMovimiento.label', default: 'CausaMovimiento'), causaMovimientoInstance.id])
                redirect causaMovimientoInstance
            }
            '*'{ respond causaMovimientoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CausaMovimiento causaMovimientoInstance) {

        if (causaMovimientoInstance == null) {
            notFound()
            return
        }

        causaMovimientoInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CausaMovimiento.label', default: 'CausaMovimiento'), causaMovimientoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'causaMovimientoInstance.label', default: 'CausaMovimiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
