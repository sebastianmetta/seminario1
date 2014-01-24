<%@ page import="infraestructura.Operario" %>



<div class="fieldcontain ${hasErrors(bean: operarioInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="operario.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${operarioInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: operarioInstance, field: 'fechaDeNacimiento', 'error')} required">
	<label for="fechaDeNacimiento">
		<g:message code="operario.fechaDeNacimiento.label" default="Fecha De Nacimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaDeNacimiento" precision="day"  value="${operarioInstance?.fechaDeNacimiento}"  />
</div>

