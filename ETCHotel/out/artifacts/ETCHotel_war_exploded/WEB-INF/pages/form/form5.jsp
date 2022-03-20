<c:if test="${not empty errormsg}">
    <div class="alert alert-success" role="alert">${errormsg}</div>
</c:if>

<form action="page5" method="post">
    <!-- заключить удалить редактировать contract -->
    <c:if test="${not empty requestScope.contract}">
        <table class="table caption-top">
            <thead>
                <tr>
                    <th scope="col"><fmt:message bundle="${labels}" key="contract.1"/></th>
                    <th scope="col"><fmt:message bundle="${labels}" key="contract.2"/></th>
                    <th scope="col"><fmt:message bundle="${labels}" key="contract.3"/></th>
                    <th scope="col"><fmt:message bundle="${labels}" key="contract.4"/></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${requestScope.contract.id}"/></td>
                    <td><c:out value="${requestScope.contract.clientName}"/></td>
                    <td><c:out value="${requestScope.contract.programName}"/></td>
                    <td><c:out value="${requestScope.contract.endDate}"/></td>
                </tr>
            </tbody>
        </table>
    </c:if>

    <button type="submit" class="btn btn-outline-primary">
        <fmt:message bundle="${labels}" key="button.2"/>
    </button>
</form>