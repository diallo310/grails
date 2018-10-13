<table id="${table}">
    <thead>
    <tr>
        <th>Author</th>
        <g:if test="${role=="true"}"><th>Target</th></g:if>
        <th>Content</th>
        <th>Show Detail</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${messageList}" var="msg" controller="message">
        <g:if test="${role=="true"}">
            <tr>
                <td>
                    ${msg.author.username}
                </td>

                <td>${msg.target.username}</td>

                <td>
                    <a id="${msg.id}" class="flagMessage" href="${createLink(action: 'showMessageContent', params: [id: msg.id])}" >${msg.content}</a>
                    <g:if test="${msg.isRead == true}">
                        <script>
                            document.getElementById("${msg.id}").style.color="black";
                        </script>
                    </g:if>

                </td>


                <td><a href="${createLink(action: 'show', params: [id: msg.id])}"><img class ="pictureIcon" src="/assets/vue1.png" class ="pictureIcon" alt="Show"></a></td>
                <td>
                    <fieldset class="buttons">
                        <g:link class="edit" action="edit" resource="${msg}"></g:link>
                    </fieldset>
                </td>
                <td>
                    <g:form resource="${msg}" method="DELETE">
                        <fieldset class="buttons">
                            <input class="delete" type="submit" value="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </fieldset>
                    </g:form>
                </td>


            </tr>

        </g:if>
        <g:if test="${username==msg.target.username && role=="null"}">

        <tr>
            <td>
                ${msg.author.username}
            </td>
            <td>
                <a id="${msg.id}" class="flagMessage" href="${createLink(action: 'showMessageContent', params: [id: msg.id])}" >${msg.content}</a>
                <g:if test="${msg.isRead == true}">
                   <script>
                       document.getElementById("${msg.id}").style.color="black";
                   </script>
                </g:if>

            </td>

            <td><a href="${createLink(action: 'show', params: [id: msg.id])}"><img class ="pictureIcon" src="/assets/vue1.png" class ="pictureIcon" alt="Show"></a></td>
            <td>
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${msg}"></g:link>
                </fieldset>
            </td>
            <td>
                <g:form resource="${msg}" method="DELETE">
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