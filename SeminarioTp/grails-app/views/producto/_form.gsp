<%@ page import="seminarioTp.productos.Producto" %>



<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="producto.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${productoInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'fechaVencimiento', 'error')} required">
	<label for="fechaVencimiento">
		<g:message code="producto.fechaVencimiento.label" default="Fecha Vencimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaVencimiento" precision="day"  value="${productoInstance?.fechaVencimiento}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'tipoProducto', 'error')} required">
	<label for="tipoProducto">
		<g:message code="producto.tipoProducto.label" default="Tipo Producto" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoProducto" name="tipoProducto.id" from="${seminarioTp.productos.TipoProducto.list()}" optionKey="id" required="" value="${productoInstance?.tipoProducto?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="producto.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="estado" name="estado.id" from="${seminarioTp.productos.EstadoProducto.list()}" optionKey="id" required="" value="${productoInstance?.estado?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'tamanio', 'error')} required">
	<label for="tamanio">
		<g:message code="producto.tamanio.label" default="Tamanio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tamanio" name="tamanio.id" from="${seminarioTp.productos.Tamanio.list()}" optionKey="id" required="" value="${productoInstance?.tamanio?.id}" class="many-to-one"/>
</div>

