<%@ include file = "header.jsp" %>

<body style="font-family: Verdana, sans-serif">
    <div align="left" style="width: 100%; padding-bottom: 20px">
        <h3><fmt:message bundle="${labels}" key="page.logo"/>&nbsp; &#9734;&#9734;&#9734;</h3>

        <!-- localization -->
        <form method="get" action="login">
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

    <!-- header -->
    <div align="center" style="width: 100%; padding-bottom: 20pt">
        <h1><fmt:message bundle="${labels}" key="login.header"/></h1>
    </div><br>

    <!-- form -->
    <form action="login" method="post">
        <table align="center" style="border-spacing: 20px">
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="login.login"/></td>
                <td><input type="text" name="login" maxlength="20"></td><br>
            </tr>
            <tr>
                <td align="right"><fmt:message bundle="${labels}" key="login.password"/></td>
                <td><input type="password" name="password" maxlength="20"></td><br><br>
            </tr>
            <tr>
                <td align="right" colspan="2">
                    <input type="submit" name="btnLogin" value="<fmt:message bundle="${labels}" key="login.submit"/>" style="font-family: Verdana, sans-serif;" style="padding-bottom: 20pt;">
                    <a href="register"><fmt:message bundle="${labels}" key="login.register"/></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

