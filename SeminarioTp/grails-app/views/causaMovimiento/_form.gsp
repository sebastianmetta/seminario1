<%@ page import="almacenes.CausaMovimiento" %>



<div class="fieldcontain ${hasErrors(bean: causaMovimientoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="causaMovimiento.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${causaMovimientoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: causaMovimientoInstance, field: 'tipoMovimiento', 'error')} required">
	<label for="tipoMovimiento">
		<g:message code="causaMovimiento.tipoMovimiento.label" default="Tipo Movimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoMovimiento" name="tipoMovimiento.id" from="${almacenes.TipoMovimiento.list()}" optionKey="id" required="" value="${causaMovimientoInstance?.tipoMovimiento?.id}" class="many-to-one"/>
</div>

