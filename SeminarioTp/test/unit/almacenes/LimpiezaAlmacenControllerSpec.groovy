package almacenes



import grails.test.mixin.*
import spock.lang.*

@TestFor(LimpiezaAlmacenController)
@Mock(LimpiezaAlmacen)
class LimpiezaAlmacenControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.limpiezaAlmacenInstanceList
            model.limpiezaAlmacenInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.limpiezaAlmacenInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def limpiezaAlmacen = new LimpiezaAlmacen()
            limpiezaAlmacen.validate()
            controller.save(limpiezaAlmacen)

        then:"The create view is rendered again with the correct model"
            model.limpiezaAlmacenInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            limpiezaAlmacen = new LimpiezaAlmacen(params)

            controller.save(limpiezaAlmacen)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/limpiezaAlmacen/show/1'
            controller.flash.message != null
            LimpiezaAlmacen.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def limpiezaAlmacen = new LimpiezaAlmacen(params)
            controller.show(limpiezaAlmacen)

        then:"A model is populated containing the domain instance"
            model.limpiezaAlmacenInstance == limpiezaAlmacen
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def limpiezaAlmacen = new LimpiezaAlmacen(params)
            controller.edit(limpiezaAlmacen)

        then:"A model is populated containing the domain instance"
            model.limpiezaAlmacenInstance == limpiezaAlmacen
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def limpiezaAlmacen = new LimpiezaAlmacen()
            limpiezaAlmacen.validate()
            controller.update(limpiezaAlmacen)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.limpiezaAlmacenInstance == limpiezaAlmacen

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            limpiezaAlmacen = new LimpiezaAlmacen(params).save(flush: true)
            controller.update(limpiezaAlmacen)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/limpiezaAlmacen/show/$limpiezaAlmacen.id"
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
            def limpiezaAlmacen = new LimpiezaAlmacen(params).save(flush: true)

        then:"It exists"
            LimpiezaAlmacen.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(limpiezaAlmacen)

        then:"The instance is deleted"
            LimpiezaAlmacen.count() == 0
            response.redirectedUrl == '/limpiezaAlmacen/index'
            flash.message != null
    }
}
