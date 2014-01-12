<%@ page import="productos.EstadoProducto" %>



<div class="fieldcontain ${hasErrors(bean: estadoProductoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="estadoProducto.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${estadoProductoInstance?.descripcion}"/>
</div>

