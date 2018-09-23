<table id="${table}">
    <thead>
    <tr>
        <th>Username</th>
        <th>Image</th>
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
        </tr>
    </g:each>
    </tbody>
</table>