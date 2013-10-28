<%@ page import="seminariotp.TipoProducto" %>



<div class="fieldcontain ${hasErrors(bean: tipoProductoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="tipoProducto.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${tipoProductoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tipoProductoInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="tipoProducto.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${tipoProductoInstance?.nombre}"/>
</div>

