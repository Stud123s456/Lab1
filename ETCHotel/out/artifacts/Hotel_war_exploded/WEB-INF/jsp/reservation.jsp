<%@ include file = "header_auth.jsp" %>

<body style="font-family: Verdana, sans-serif">
    <div align="left" style="width: 100%; padding-bottom: 20px">
        <h3><fmt:message bundle="${labels}" key="page.logo"/>&nbsp; &#9734;&#9734;&#9734;</h3>

        <!-- localization -->
        <form method="get" action="reservation">
            <fmt:message bundle="${labels}" key="common.language"/>&nbsp;
            <select name="lang" size="1" onchange="this.form.submit()">
                <c:if test="${locale == 'ru_RU'}">
                    <option value="en_US"><fmt:message bundle="${labels}" key="common.language.en"/></option>
                    <option value="ru_RU" selected><fmt:message bundle="${labels}" key="common.language.ru"/></option>
                </c:if>
                <c:if test="${locale == 'en_US'}">
                    <option value="en_US" selected><fmt:message bundle="${labels}" key="common.language.en"/></option>
                    <option value="ru_RU"><fmt:message bundle="${labels}" key="common.language.ru"/></option>
                </c:if>
            </select>
        </form>
    </div>

    <!-- user -->
    <div style="width: 100%">
        <h2>
            <fmt:message bundle="${labels}" key="common.user.name"/> <c:out value="${sessionScope.user.fullName}"/> /
            <c:if test="${sessionScope.user.administrator == true}">
                <fmt:message bundle="${labels}" key="common.user.admin"/>
                <c:set var="tdwidth" value="15%"/>
            </c:if>
            <c:if test="${sessionScope.user.administrator == false}">
                <fmt:message bundle="${labels}" key="common.user.simple"/>
                <c:set var="tdwidth" value="25%"/>
            </c:if>
        </h2>
    </div>

    <table style="width: 100%; border-spacing: 0">
        <tr>
            <td style="width: 50%; text-align: right">
                <form action="logout" method="post">
                    <input type="submit" name="btnLogout" value="<fmt:message bundle="${labels}" key="common.button.logout"/>">
                </form>
            </td>
        </tr>
    </table>

    <div align="center" style="width: 100%; padding-bottom: 20pt">
        <h1><fmt:message bundle="${labels}" key="reservation.header"/></h1>
    </div>

    <table border="1" width="100%">
        <thead>
            <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.room"/></th>
            <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.room.type"/></th>
            <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.room.view"/></th>
            <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.dateFrom"/></th>
            <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.dateTo"/></th>
            <c:if test="${sessionScope.user.administrator == true}">
                <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.user"/></th>
                <th width="${tdwidth}"><fmt:message bundle="${labels}" key="reservation.table.phone"/></th>
            </c:if>
            <th><fmt:message bundle="${labels}" key="reservation.table.action"/></th>
        </thead>
        <tbody>

        <c:forEach var="rv" items="${requestScope.reservations}">
            <tr>
                <td><c:out value="${rv.room.number}"/></td>

                <td><fmt:message bundle="${labels}" key="${rv.room.roomType.name}"/></td>

                <td><fmt:message bundle="${labels}" key="${rv.room.roomView.name}"/></td>

                <td>
                    <fmt:parseDate value="${rv.dateFrom}" pattern="yyyy-MM-dd" var="dateFrom" type="date"/>
                    <fmt:formatDate value="${dateFrom}" pattern="dd.MM.yyyy" type="date"/>
                </td>
                <td>
                    <fmt:parseDate value="${rv.dateTo}" pattern="yyyy-MM-dd" var="dateTo" type="date"/>
                    <fmt:formatDate value="${dateTo}" pattern="dd.MM.yyyy" type="date"/>
                </td>

                <c:if test="${sessionScope.user.administrator == true}">
                    <td>
                        <c:out value="${rv.user.fullName}"/>
                    </td>
                    <td>
                        <c:out value="${rv.user.phone}"/>
                    </td>
                </c:if>

                <td align="center">
                    <form action="reservation" method="post" style="margin-bottom: 0">
                        <input type="hidden" name="reservationId" value="${rv.reservationId}">
                        <input type="hidden" name="action" value="remove">
                        <c:if test="${sessionScope.user.administrator == true}">
                            <input type="submit" name="btnReject" value="<fmt:message bundle="${labels}" key="reservation.table.reject"/>">
                        </c:if>
                        <c:if test="${sessionScope.user.administrator == false}">
                            <input type="submit" name="btnCancel" value="<fmt:message bundle="${labels}" key="reservation.table.cancel"/>">
                        </c:if>
                    </form>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${sessionScope.user.administrator == false}">
            <form action="reservation" method="post">
                <tr>
                    <td>
                        <input type="hidden" name="action" value="create">
                    </td>
                    <td>
                        <select name="roomType" size="1">
                            <c:forEach var="type" items="${requestScope.types}">
                                <option value="${type}"><fmt:message bundle="${labels}" key="${type.name}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="roomView" size="1">
                            <c:forEach var="view" items="${requestScope.views}">
                                <option value="${view}"><fmt:message bundle="${labels}" key="${view.name}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="text" name="dateFrom" maxlength="10">
                    </td>
                    <td>
                        <input type="text" name="dateTo" maxlength="10">
                    </td>
                    <td>
                        <input type="submit" name="btnCreate" value="<fmt:message bundle="${labels}" key="reservation.table.create"/>">
                    </td>
                </tr>
            </form>
        </c:if>
        </tbody>
    </table>

</body>
</html>
