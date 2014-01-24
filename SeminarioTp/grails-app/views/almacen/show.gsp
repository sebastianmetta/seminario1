
<%@ page import="almacenes.Almacen" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'almacen.label', default: 'Almacen')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-almacen" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-almacen" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list almacen">
			
				<g:if test="${almacenInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="almacen.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${almacenInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${almacenInstance?.capacidadMaxima}">
				<li class="fieldcontain">
					<span id="capacidadMaxima-label" class="property-label"><g:message code="almacen.capacidadMaxima.label" default="Capacidad Maxima" /></span>
					
						<span class="property-value" aria-labelledby="capacidadMaxima-label"><g:link controller="tamanio" action="show" id="${almacenInstance?.capacidadMaxima?.id}">${almacenInstance?.capacidadMaxima?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${almacenInstance?.limpiezasRealizadas}">
				<li class="fieldcontain">
					<span id="limpiezasRealizadas-label" class="property-label"><g:message code="almacen.limpiezasRealizadas.label" default="Limpiezas Realizadas" /></span>
					
						<g:each in="${almacenInstance.limpiezasRealizadas}" var="l">
						<span class="property-value" aria-labelledby="limpiezasRealizadas-label"><g:link controller="limpiezaAlmacen" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${almacenInstance?.movimientosRealizados}">
				<li class="fieldcontain">
					<span id="movimientosRealizados-label" class="property-label"><g:message code="almacen.movimientosRealizados.label" default="Movimientos Realizados" /></span>
					
						<g:each in="${almacenInstance.movimientosRealizados}" var="m">
						<span class="property-value" aria-labelledby="movimientosRealizados-label"><g:link controller="movimientoAlmacen" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${almacenInstance?.productosEnStock}">
				<li class="fieldcontain">
					<span id="productosEnStock-label" class="property-label"><g:message code="almacen.productosEnStock.label" default="Productos En Stock" /></span>
					
						<g:each in="${almacenInstance.productosEnStock}" var="p">
						<span class="property-value" aria-labelledby="productosEnStock-label"><g:link controller="producto" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${almacenInstance?.tiposDeProductosAdmitidos}">
				<li class="fieldcontain">
					<span id="tiposDeProductosAdmitidos-label" class="property-label"><g:message code="almacen.tiposDeProductosAdmitidos.label" default="Tipos De Productos Admitidos" /></span>
					
						<g:each in="${almacenInstance.tiposDeProductosAdmitidos}" var="t">
						<span class="property-value" aria-labelledby="tiposDeProductosAdmitidos-label"><g:link controller="tipoProducto" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:almacenInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${almacenInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
