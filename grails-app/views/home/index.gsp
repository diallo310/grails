<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails Plateform</title>
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
        <h1>Welcome to player management platform and results</h1>

        <p>
            Congratulations, you have successfully started your first Grails application! At the moment
            this is the default page, feel free to modify it to either redirect to a controller or display
            whatever content you may choose. Below is a list of controllers that are currently deployed in
            this application, click on each to execute its default action:
        </p>


    </section>
</div>
<div class="footer">
    <span id="footer-links">
        <a target="_blank" href="http://grails.org/" class="footer-link">Grails.org</a> <span class="separator">•</span>
        <a target="_blank" href="http://twitter.com/grailsframework" class="footer-link">Twitter</a>
        <br>
        <a target="_blank" href="http://github.com/grails/" class="footer-link">GitHub</a> <span class="separator">•</span>
        <a target="_blank" href="http://grails.slack.com/" class="footer-link">Slack</a>
        <br>
        <a target="_blank" href="http://www.ociweb.com/" class="footer-link">OCI</a>
    </span>
</div>
</body>
</html>
