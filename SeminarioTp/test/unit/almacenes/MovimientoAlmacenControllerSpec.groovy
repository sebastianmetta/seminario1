package almacenes



import grails.test.mixin.*
import spock.lang.*

@TestFor(MovimientoAlmacenController)
@Mock(MovimientoAlmacen)
class MovimientoAlmacenControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.movimientoAlmacenInstanceList
            model.movimientoAlmacenInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.movimientoAlmacenInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def movimientoAlmacen = new MovimientoAlmacen()
            movimientoAlmacen.validate()
            controller.save(movimientoAlmacen)

        then:"The create view is rendered again with the correct model"
            model.movimientoAlmacenInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            movimientoAlmacen = new MovimientoAlmacen(params)

            controller.save(movimientoAlmacen)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/movimientoAlmacen/show/1'
            controller.flash.message != null
            MovimientoAlmacen.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def movimientoAlmacen = new MovimientoAlmacen(params)
            controller.show(movimientoAlmacen)

        then:"A model is populated containing the domain instance"
            model.movimientoAlmacenInstance == movimientoAlmacen
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def movimientoAlmacen = new MovimientoAlmacen(params)
            controller.edit(movimientoAlmacen)

        then:"A model is populated containing the domain instance"
            model.movimientoAlmacenInstance == movimientoAlmacen
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def movimientoAlmacen = new MovimientoAlmacen()
            movimientoAlmacen.validate()
            controller.update(movimientoAlmacen)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.movimientoAlmacenInstance == movimientoAlmacen

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            movimientoAlmacen = new MovimientoAlmacen(params).save(flush: true)
            controller.update(movimientoAlmacen)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/movimientoAlmacen/show/$movimientoAlmacen.id"
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
            def movimientoAlmacen = new MovimientoAlmacen(params).save(flush: true)

        then:"It exists"
            MovimientoAlmacen.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(movimientoAlmacen)

        then:"The instance is deleted"
            MovimientoAlmacen.count() == 0
            response.redirectedUrl == '/movimientoAlmacen/index'
            flash.message != null
    }
}
