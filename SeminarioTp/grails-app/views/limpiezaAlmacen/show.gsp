
<%@ page import="almacenes.LimpiezaAlmacen" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'limpiezaAlmacen.label', default: 'LimpiezaAlmacen')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-limpiezaAlmacen" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-limpiezaAlmacen" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list limpiezaAlmacen">
			
				<g:if test="${limpiezaAlmacenInstance?.fecha}">
				<li class="fieldcontain">
					<span id="fecha-label" class="property-label"><g:message code="limpiezaAlmacen.fecha.label" default="Fecha" /></span>
					
						<span class="property-value" aria-labelledby="fecha-label"><g:formatDate date="${limpiezaAlmacenInstance?.fecha}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${limpiezaAlmacenInstance?.encargado}">
				<li class="fieldcontain">
					<span id="encargado-label" class="property-label"><g:message code="limpiezaAlmacen.encargado.label" default="Encargado" /></span>
					
						<span class="property-value" aria-labelledby="encargado-label"><g:link controller="operario" action="show" id="${limpiezaAlmacenInstance?.encargado?.id}">${limpiezaAlmacenInstance?.encargado?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${limpiezaAlmacenInstance?.almacen}">
				<li class="fieldcontain">
					<span id="almacen-label" class="property-label"><g:message code="limpiezaAlmacen.almacen.label" default="Almacen" /></span>
					
						<span class="property-value" aria-labelledby="almacen-label"><g:link controller="almacen" action="show" id="${limpiezaAlmacenInstance?.almacen?.id}">${limpiezaAlmacenInstance?.almacen?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${limpiezaAlmacenInstance?.observaciones}">
				<li class="fieldcontain">
					<span id="observaciones-label" class="property-label"><g:message code="limpiezaAlmacen.observaciones.label" default="Observaciones" /></span>
					
						<span class="property-value" aria-labelledby="observaciones-label"><g:fieldValue bean="${limpiezaAlmacenInstance}" field="observaciones"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:limpiezaAlmacenInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${limpiezaAlmacenInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
