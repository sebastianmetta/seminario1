package almacenes



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LimpiezaAlmacenController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LimpiezaAlmacen.list(params), model:[limpiezaAlmacenInstanceCount: LimpiezaAlmacen.count()]
    }

    def show(LimpiezaAlmacen limpiezaAlmacenInstance) {
        respond limpiezaAlmacenInstance
    }

    def create() {
        respond new LimpiezaAlmacen(params)
    }

    @Transactional
    def save(LimpiezaAlmacen limpiezaAlmacenInstance) {
        if (limpiezaAlmacenInstance == null) {
            notFound()
            return
        }

        if (limpiezaAlmacenInstance.hasErrors()) {
            respond limpiezaAlmacenInstance.errors, view:'create'
            return
        }

        limpiezaAlmacenInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'limpiezaAlmacenInstance.label', default: 'LimpiezaAlmacen'), limpiezaAlmacenInstance.id])
                redirect limpiezaAlmacenInstance
            }
            '*' { respond limpiezaAlmacenInstance, [status: CREATED] }
        }
    }

    def edit(LimpiezaAlmacen limpiezaAlmacenInstance) {
        respond limpiezaAlmacenInstance
    }

    @Transactional
    def update(LimpiezaAlmacen limpiezaAlmacenInstance) {
        if (limpiezaAlmacenInstance == null) {
            notFound()
            return
        }

        if (limpiezaAlmacenInstance.hasErrors()) {
            respond limpiezaAlmacenInstance.errors, view:'edit'
            return
        }

        limpiezaAlmacenInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LimpiezaAlmacen.label', default: 'LimpiezaAlmacen'), limpiezaAlmacenInstance.id])
                redirect limpiezaAlmacenInstance
            }
            '*'{ respond limpiezaAlmacenInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LimpiezaAlmacen limpiezaAlmacenInstance) {

        if (limpiezaAlmacenInstance == null) {
            notFound()
            return
        }

        limpiezaAlmacenInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LimpiezaAlmacen.label', default: 'LimpiezaAlmacen'), limpiezaAlmacenInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'limpiezaAlmacenInstance.label', default: 'LimpiezaAlmacen'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
