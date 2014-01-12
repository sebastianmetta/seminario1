package productos



import static org.springframework.http.HttpStatus.*
import productos.Tamanio;
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TamanioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tamanio.list(params), model:[tamanioInstanceCount: Tamanio.count()]
    }

    def show(Tamanio tamanioInstance) {
        respond tamanioInstance
    }

    def create() {
        respond new Tamanio(params)
    }

    @Transactional
    def save(Tamanio tamanioInstance) {
        if (tamanioInstance == null) {
            notFound()
            return
        }

        if (tamanioInstance.hasErrors()) {
            respond tamanioInstance.errors, view:'create'
            return
        }

        tamanioInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tamanioInstance.label', default: 'Tamanio'), tamanioInstance.id])
                redirect tamanioInstance
            }
            '*' { respond tamanioInstance, [status: CREATED] }
        }
    }

    def edit(Tamanio tamanioInstance) {
        respond tamanioInstance
    }

    @Transactional
    def update(Tamanio tamanioInstance) {
        if (tamanioInstance == null) {
            notFound()
            return
        }

        if (tamanioInstance.hasErrors()) {
            respond tamanioInstance.errors, view:'edit'
            return
        }

        tamanioInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Tamanio.label', default: 'Tamanio'), tamanioInstance.id])
                redirect tamanioInstance
            }
            '*'{ respond tamanioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Tamanio tamanioInstance) {

        if (tamanioInstance == null) {
            notFound()
            return
        }

        tamanioInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Tamanio.label', default: 'Tamanio'), tamanioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tamanioInstance.label', default: 'Tamanio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
