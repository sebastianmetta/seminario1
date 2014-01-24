
<%@ page import="almacenes.MovimientoAlmacen" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'movimientoAlmacen.label', default: 'MovimientoAlmacen')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-movimientoAlmacen" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-movimientoAlmacen" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list movimientoAlmacen">
			
				<g:if test="${movimientoAlmacenInstance?.almacen}">
				<li class="fieldcontain">
					<span id="almacen-label" class="property-label"><g:message code="movimientoAlmacen.almacen.label" default="Almacen" /></span>
					
						<span class="property-value" aria-labelledby="almacen-label"><g:link controller="almacen" action="show" id="${movimientoAlmacenInstance?.almacen?.id}">${movimientoAlmacenInstance?.almacen?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimientoAlmacenInstance?.fecha}">
				<li class="fieldcontain">
					<span id="fecha-label" class="property-label"><g:message code="movimientoAlmacen.fecha.label" default="Fecha" /></span>
					
						<span class="property-value" aria-labelledby="fecha-label"><g:formatDate date="${movimientoAlmacenInstance?.fecha}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimientoAlmacenInstance?.causa}">
				<li class="fieldcontain">
					<span id="causa-label" class="property-label"><g:message code="movimientoAlmacen.causa.label" default="Causa" /></span>
					
						<span class="property-value" aria-labelledby="causa-label"><g:link controller="causaMovimiento" action="show" id="${movimientoAlmacenInstance?.causa?.id}">${movimientoAlmacenInstance?.causa?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${movimientoAlmacenInstance?.productos}">
				<li class="fieldcontain">
					<span id="productos-label" class="property-label"><g:message code="movimientoAlmacen.productos.label" default="Productos" /></span>
					
						<g:each in="${movimientoAlmacenInstance.productos}" var="p">
						<span class="property-value" aria-labelledby="productos-label"><g:link controller="producto" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:movimientoAlmacenInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${movimientoAlmacenInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
