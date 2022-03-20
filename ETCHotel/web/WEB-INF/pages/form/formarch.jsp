<c:if test="${not empty requestScope.declarations}">
    <table class="table caption-top">
        <thead>
        <tr>
            <th scope="col"><fmt:message bundle="${labels}" key="table.arch.header1"/></th>
            <th scope="col"><fmt:message bundle="${labels}" key="table.arch.header2"/></th>
            <th scope="col"><fmt:message bundle="${labels}" key="table.arch.header3"/></th>
            <th scope="col"><fmt:message bundle="${labels}" key="table.arch.header4"/></th>
            <th scope="col"><fmt:message bundle="${labels}" key="table.arch.header5"/></th>
            <th scope="col"><fmt:message bundle="${labels}" key="table.arch.header6"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="rv" items="${requestScope.declarations}">
            <tr>
                <td><c:out value="${rv.id}"/></td>
                <td><c:out value="${rv.programmName}"/></td>
                <td><c:out value="${rv.declName}"/></td>
                <td><c:out value="${rv.date}"/></td>
                <td><c:out value="${rv.clientName}"/></td>
                <td><c:out value="${rv.contact}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>