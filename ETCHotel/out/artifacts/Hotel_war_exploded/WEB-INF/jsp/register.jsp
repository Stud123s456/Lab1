<%@ include file = "header.jsp" %>
<body>
    <div align="left" style="width: 100%; padding-bottom: 20px">
        <h3><fmt:message bundle="${labels}" key="page.logo"/>&nbsp; &#9734;&#9734;&#9734;</h3>

        <div align="right" style="width: 100%; padding-bottom: 20px">
            <form method="get" action="register">
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
    </div>

    <div align="center" style="width: 100%; padding-bottom: 20pt">
        <h1><fmt:message bundle="${labels}" key="register.header"/></h1>
    </div><br>

    <form action="register" method="post">
        <table align="center">
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="register.fullname"/></td>
                <td><input type="text" name="fullname" maxlength="30" value="${requestScope.user.fullName}"></td>
            </tr>
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="register.phone"/></td>
                <td><input type="text" name="phone" maxlength="15" value="${requestScope.user.phone}"></td>
            </tr>
            <br>
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="register.login"/></td>
                <td><input type="text" name="login" maxlength="20" value="${requestScope.user.login}"></td>
            </tr>
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="register.password"/></td>
                <td><input type="password" name="password" maxlength="20"></td>
            </tr>
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="register.confirm"/></td>
                <td><input type="password" name="confirm" maxlength="20"></td>
            </tr>
            <tr>
                <td align="right" colspan="2">
                    <input type="submit" name="btnRegister" value="<fmt:message bundle="${labels}" key="register.register"/>" style="padding-right: 10pt">
                    <a href="login"><fmt:message bundle="${labels}" key="register.back"/></a>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>

