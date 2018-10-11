<table id="${table}">
    <thead>
    <tr>
        <th>Author</th>
        <th>Message</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${messageList}" var="message" controller="message">
        <g:if test="${username==message.target.username}">
        <tr>
            <td>
                <h2>${message.author.username}</h2>
            </td>
            <td>
                <a id="${message.id}" class="flagMessage" href="${createLink(action: 'showMessageContent', params: [id: message.id])}" >${message.content}</a>
                <g:if test="${message.isRead == true}">
                   <script>
                       document.getElementById("${message.id}").style.color="black";
                   </script>
                </g:if>

            </td>
        </tr>
        </g:if>
    </g:each>
    </tbody>
</table>