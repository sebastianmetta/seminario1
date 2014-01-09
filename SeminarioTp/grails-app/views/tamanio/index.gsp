
<%@ page import="seminarioTp.productos.Tamanio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tamanio.label', default: 'Tamanio')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tamanio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tamanio" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="alto" title="${message(code: 'tamanio.alto.label', default: 'Alto')}" />
					
						<g:sortableColumn property="ancho" title="${message(code: 'tamanio.ancho.label', default: 'Ancho')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tamanioInstanceList}" status="i" var="tamanioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tamanioInstance.id}">${fieldValue(bean: tamanioInstance, field: "alto")}</g:link></td>
					
						<td>${fieldValue(bean: tamanioInstance, field: "ancho")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tamanioInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
