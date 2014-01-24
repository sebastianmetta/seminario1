
<%@ page import="infraestructura.Operario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'operario.label', default: 'Operario')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-operario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-operario" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'operario.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="fechaDeNacimiento" title="${message(code: 'operario.fechaDeNacimiento.label', default: 'Fecha De Nacimiento')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${operarioInstanceList}" status="i" var="operarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${operarioInstance.id}">${fieldValue(bean: operarioInstance, field: "nombre")}</g:link></td>
					
						<td><g:formatDate date="${operarioInstance.fechaDeNacimiento}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${operarioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
