<%@ page import="almacenes.TipoMovimiento" %>



<div class="fieldcontain ${hasErrors(bean: tipoMovimientoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="tipoMovimiento.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${tipoMovimientoInstance?.descripcion}"/>
</div>

