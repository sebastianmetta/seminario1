<%@ page import="almacenes.Almacen" %>



<div class="fieldcontain ${hasErrors(bean: almacenInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="almacen.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${almacenInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: almacenInstance, field: 'capacidadMaxima', 'error')} required">
	<label for="capacidadMaxima">
		<g:message code="almacen.capacidadMaxima.label" default="Capacidad Maxima" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="capacidadMaxima" name="capacidadMaxima.id" from="${productos.Tamanio.list()}" optionKey="id" required="" value="${almacenInstance?.capacidadMaxima?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: almacenInstance, field: 'limpiezasRealizadas', 'error')} ">
	<label for="limpiezasRealizadas">
		<g:message code="almacen.limpiezasRealizadas.label" default="Limpiezas Realizadas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${almacenInstance?.limpiezasRealizadas?}" var="l">
    <li><g:link controller="limpiezaAlmacen" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="limpiezaAlmacen" action="create" params="['almacen.id': almacenInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'limpiezaAlmacen.label', default: 'LimpiezaAlmacen')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: almacenInstance, field: 'movimientosRealizados', 'error')} ">
	<label for="movimientosRealizados">
		<g:message code="almacen.movimientosRealizados.label" default="Movimientos Realizados" />
		
	</label>
	<g:select name="movimientosRealizados" from="${almacenes.MovimientoAlmacen.list()}" multiple="multiple" optionKey="id" size="5" value="${almacenInstance?.movimientosRealizados*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: almacenInstance, field: 'productosEnStock', 'error')} ">
	<label for="productosEnStock">
		<g:message code="almacen.productosEnStock.label" default="Productos En Stock" />
		
	</label>
	<g:select name="productosEnStock" from="${productos.Producto.list()}" multiple="multiple" optionKey="id" size="5" value="${almacenInstance?.productosEnStock*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: almacenInstance, field: 'tiposDeProductosAdmitidos', 'error')} ">
	<label for="tiposDeProductosAdmitidos">
		<g:message code="almacen.tiposDeProductosAdmitidos.label" default="Tipos De Productos Admitidos" />
		
	</label>
	<g:select name="tiposDeProductosAdmitidos" from="${productos.TipoProducto.list()}" multiple="multiple" optionKey="id" size="5" value="${almacenInstance?.tiposDeProductosAdmitidos*.id}" class="many-to-many"/>
</div>

