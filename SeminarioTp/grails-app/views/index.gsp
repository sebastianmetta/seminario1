<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Campo chico - Inicio</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .1em solid #000000;
				margin: 2em 2em 1em;
				padding: 1.2em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ffffff;
				-webkit-box-shadow: 0px 0px 1.25em #ffffff;
				box-shadow: 0px 0px 1.25em #ffffff;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.4em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 1em;
				list-style-type: circle;
				margin-bottom: 0.6em;
				margin-right: 0.5em;
				padding: 0.1em;;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
				color:  rgb(188,71,0);
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h1 {
				text-transform: uppercase;
				font-size: 1.5em;
				margin: 0 0 0.3em;
				color:  rgb(188,71,0)
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Secciones</h1>
			<ul>
				<li>Control de stock</li>
				<li>Reportes</li>
				<li>Contacto</li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h2>Bienvenido</h2>
			<p>Gracias por utilizar CAMPO CHICO, sistema de control de stocks.</p>
			<div id="controller-list" role="navigation">
				<h2>Entidades disponibles:</h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>
