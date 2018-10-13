<table id="${table}">
    <thead>
    <tr>
        <th>Username</th>
        <th>Image</th>
        <th>Authorities</th>
        <th>Show Detail</th>
        <th>Edit</th>
        <th>Delete</th>


    </tr>
    </thead>
    <tbody>

    <g:each in="${userList}" var="user">
        <g:if test="${user.enabled==true}">
        <tr>
            <td>
               ${user.username}
            </td>
            <td>
                <img class ="pictureProfile" src="${"http://localhost/img/" + user.image}"/>
            </td>
            <td>
                <g:each in="${user.getAuthorities()}" var="role">
                    ${role.authority}
                </g:each>
            </td>

            <td><a href="${createLink(action: 'show', params: [id: user.id])}"><img class ="pictureIcon" src="/assets/vue1.png" class ="pictureIcon" alt="Show"></a></td>
            <td>
                    <fieldset class="buttons">
                        <g:link class="edit" action="edit" resource="${user}"></g:link>
                    </fieldset>
            </td>
            <td>
                <g:form resource="${user}" method="DELETE">
                    <fieldset class="buttons">
                        <input class="delete" type="submit" value="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
            </td>


        </tr>
</g:if>
    </g:each>
    </tbody>
</table>