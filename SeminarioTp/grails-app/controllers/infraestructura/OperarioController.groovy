package infraestructura



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OperarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Operario.list(params), model:[operarioInstanceCount: Operario.count()]
    }

    def show(Operario operarioInstance) {
        respond operarioInstance
    }

    def create() {
        respond new Operario(params)
    }

    @Transactional
    def save(Operario operarioInstance) {
        if (operarioInstance == null) {
            notFound()
            return
        }

        if (operarioInstance.hasErrors()) {
            respond operarioInstance.errors, view:'create'
            return
        }

        operarioInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'operarioInstance.label', default: 'Operario'), operarioInstance.id])
                redirect operarioInstance
            }
            '*' { respond operarioInstance, [status: CREATED] }
        }
    }

    def edit(Operario operarioInstance) {
        respond operarioInstance
    }

    @Transactional
    def update(Operario operarioInstance) {
        if (operarioInstance == null) {
            notFound()
            return
        }

        if (operarioInstance.hasErrors()) {
            respond operarioInstance.errors, view:'edit'
            return
        }

        operarioInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Operario.label', default: 'Operario'), operarioInstance.id])
                redirect operarioInstance
            }
            '*'{ respond operarioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Operario operarioInstance) {

        if (operarioInstance == null) {
            notFound()
            return
        }

        operarioInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Operario.label', default: 'Operario'), operarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'operarioInstance.label', default: 'Operario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
