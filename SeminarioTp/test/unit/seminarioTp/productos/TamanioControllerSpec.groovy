package seminarioTp.productos



import productos.Tamanio;
import grails.test.mixin.*
import spock.lang.*

@TestFor(TamanioController)
@Mock(Tamanio)
class TamanioControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.tamanioInstanceList
            model.tamanioInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.tamanioInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def tamanio = new Tamanio()
            tamanio.validate()
            controller.save(tamanio)

        then:"The create view is rendered again with the correct model"
            model.tamanioInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            tamanio = new Tamanio(params)

            controller.save(tamanio)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/tamanio/show/1'
            controller.flash.message != null
            Tamanio.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def tamanio = new Tamanio(params)
            controller.show(tamanio)

        then:"A model is populated containing the domain instance"
            model.tamanioInstance == tamanio
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def tamanio = new Tamanio(params)
            controller.edit(tamanio)

        then:"A model is populated containing the domain instance"
            model.tamanioInstance == tamanio
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def tamanio = new Tamanio()
            tamanio.validate()
            controller.update(tamanio)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.tamanioInstance == tamanio

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            tamanio = new Tamanio(params).save(flush: true)
            controller.update(tamanio)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/tamanio/show/$tamanio.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            status == 404

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def tamanio = new Tamanio(params).save(flush: true)

        then:"It exists"
            Tamanio.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(tamanio)

        then:"The instance is deleted"
            Tamanio.count() == 0
            response.redirectedUrl == '/tamanio/index'
            flash.message != null
    }
}
