<table id="${table}">
    <thead>
    <tr>
        <th>Username</th>
        <th>Image</th>
        <th>Authorities</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${userList}" var="user">
        <tr>
            <td>
                <a href="${createLink(action: 'show', params: [id: user.id])}">${user.username}</a>
            </td>
            <td>
                <img src="${"http://localhost:8080/img/" + user.image}"/>
            </td>
            <td>
                <g:each in="${user.getAuthorities()}" var="role">
                    <h2>${role.authority}</h2>
                </g:each>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>