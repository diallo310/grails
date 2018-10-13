<table id="${table}">
    <thead>
    <tr>
        <th>Winner</th>
        <th>Winner Score</th>
        <th>Looser</th>
        <th>Looser Score</th>
        <th>Show Message</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${matchList}" var="match">
        <tr>
            <td>
                <g:if test="${match.winner.image}">
                    <img  src="${"http://localhost/img/" + match.winner.image}" />
                </g:if>
                <p>${match.winner.username}</p>
            </td>
            <td class="score">
                ${match.winnerScore}
            </td>
            <td>
                <g:if test="${match.looser.image}">
                    <img src="${"http://localhost/img/" + match.looser.image}" />
                </g:if>
                <p> ${match.looser.username}</p>
            </td>
            <td>
                ${match.looserScore}
            </td>

            <td><a href="${createLink(action: 'show', params: [id: match.id])}"><img class ="pictureIcon" src="/assets/vue1.png" class ="pictureIcon" alt="Show"></a></td>
            <td>
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${match}"></g:link>
                </fieldset>
            </td>
            <td>
                <g:form resource="${match}" method="DELETE">
                    <fieldset class="buttons">
                        <input class="delete" type="submit" value="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
            </td>



        </tr>
    </g:each>
    </tbody>
</table>