<%@ page import="almacenes.LimpiezaAlmacen" %>



<div class="fieldcontain ${hasErrors(bean: limpiezaAlmacenInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="limpiezaAlmacen.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${limpiezaAlmacenInstance?.fecha}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: limpiezaAlmacenInstance, field: 'encargado', 'error')} required">
	<label for="encargado">
		<g:message code="limpiezaAlmacen.encargado.label" default="Encargado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="encargado" name="encargado.id" from="${infraestructura.Operario.list()}" optionKey="id" required="" value="${limpiezaAlmacenInstance?.encargado?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: limpiezaAlmacenInstance, field: 'almacen', 'error')} required">
	<label for="almacen">
		<g:message code="limpiezaAlmacen.almacen.label" default="Almacen" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="almacen" name="almacen.id" from="${almacenes.Almacen.list()}" optionKey="id" required="" value="${limpiezaAlmacenInstance?.almacen?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: limpiezaAlmacenInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones">
		<g:message code="limpiezaAlmacen.observaciones.label" default="Observaciones" />
		
	</label>
	<g:textField name="observaciones" value="${limpiezaAlmacenInstance?.observaciones}"/>
</div>

