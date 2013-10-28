<%@ page import="seminariotp.Producto" %>



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

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'tipo', 'error')} required">
	<label for="tipo">
		<g:message code="producto.tipo.label" default="Tipo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipo" name="tipo.id" from="${seminariotp.TipoProducto.list()}" optionKey="id" required="" value="${productoInstance?.tipo?.id}" class="many-to-one"/>
</div>

