<table id="${table}">
    <thead>
    <tr>
        <th>Winner Score</th>
        <th>Looser Score</th>
        <th>Winner</th>
        <th>Looser</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${matchList}" var="match">
        <tr>
            <td>
                ${match.winnerScore}
            </td>
            <td>
                ${match.looserScore}
            </td>
            <td>
                <g:if test="${match.winner.image}">
                    <img src="${"http://localhost:8080/img/" + match.winner.image}" />
                </g:if>
                <h2>${match.winner.username}</h2>
            </td>
            <td>
                <g:if test="${match.looser.image}">
                    <img src="${"http://localhost:8080/img/" + match.looser.image}" />
                </g:if>
                <h2>${match.looser.username}</h2>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>