<content tag="nav" id="${navbar}">

<ul class="nav navbar-nav navbar-left">

    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
        <g:if  test= "${c.name != 'Login' && c.name !='Logout' && c.name !='Api' && c.name !='UserRole' && c.name !='Role' && c.name !='RestOauth'}">
            <li class="controller">
                <g:link controller="${c.logicalPropertyName}" >${c.name}</g:link>
            </li>

        </g:if>
    </g:each>
</ul>
<ul class="nav navbar-nav navbar-right">


<li class="navbar-brand">
    <h1 style="color:blue;">Bonjour ${username}</h1>
</li>

    <li class="button">
        <g:link controller="Logout">Logout</g:link>
    </li>
</ul>

</content>