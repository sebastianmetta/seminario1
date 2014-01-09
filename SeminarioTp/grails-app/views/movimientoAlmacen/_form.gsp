<%@ page import="almacenes.MovimientoAlmacen" %>



<div class="fieldcontain ${hasErrors(bean: movimientoAlmacenInstance, field: 'causa', 'error')} required">
	<label for="causa">
		<g:message code="movimientoAlmacen.causa.label" default="Causa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="causa" name="causa.id" from="${almacenes.CausaMovimiento.list()}" optionKey="id" required="" value="${movimientoAlmacenInstance?.causa?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: movimientoAlmacenInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="movimientoAlmacen.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${movimientoAlmacenInstance?.fecha}"  />
</div>

