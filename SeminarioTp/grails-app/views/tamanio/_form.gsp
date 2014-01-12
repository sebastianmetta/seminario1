<%@ page import="productos.Tamanio" %>



<div class="fieldcontain ${hasErrors(bean: tamanioInstance, field: 'alto', 'error')} required">
	<label for="alto">
		<g:message code="tamanio.alto.label" default="Alto" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="alto" value="${fieldValue(bean: tamanioInstance, field: 'alto')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: tamanioInstance, field: 'ancho', 'error')} required">
	<label for="ancho">
		<g:message code="tamanio.ancho.label" default="Ancho" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ancho" value="${fieldValue(bean: tamanioInstance, field: 'ancho')}" required=""/>
</div>

