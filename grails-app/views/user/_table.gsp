<table id="${table}">
    <thead>
    <tr>
        <th>Username</th>
        <th>Image</th>
        <th>Authorities</th>
        <th>Show Detail</th>
        <th>Delete</th>
        <th>Edit</th>


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
                <img src="${"http://localhost:8080/img/" + user.image}"/>
            </td>
            <td>
                <g:each in="${user.getAuthorities()}" var="role">
                    <h2>${role.authority}</h2>
                </g:each>
            </td>

            <td><a href="${createLink(action: 'show', params: [id: user.id])}"><img src="/assets/vue1.png" width=50 height=30 alt=""></a></td>
            <td>
                <g:form resource="${user}" method="DELETE">
                    <fieldset class="buttons">
                        <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
            </img>
            </td>
            <td><a href="/user/edit/${user.id}"><img src="/assets/edit.png" width=50 height=30 alt=""></a></td>


        </tr>
</g:if>
    </g:each>
    </tbody>
</table>