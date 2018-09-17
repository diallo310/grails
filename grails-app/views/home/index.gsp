<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>grails project</title>
</head>
<body>
<content tag="nav">
    <li class="dropdown">
         <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
             <g:if  test= "${c.name != 'Login' && c.name !='Logout' }">
                 <li class="controller">
                     <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
            </li>
        </g:if>
    </g:each>

    </li>
    <li class="dropdown">
        <g:link controller="Logout">Logout</g:link>
    </li>
</content>
<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to your admin area</h1>

    </section>
</div>



</body>
</html>
