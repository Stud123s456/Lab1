<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.user}">
    <c:set scope="request" var="error" value="not_logged"/>
    <c:redirect url="login"/>
</c:if>

<c:set var="locale" value="en_US"/>
<c:if test="${not empty sessionScope.locale}">
    <c:set var="locale" value="${sessionScope.locale}"/>
</c:if>

<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="by.bsuir.reservation.locales.labels" var="labels" />

<c:if test="${not empty requestScope.error}">
    <fmt:message bundle="${labels}" key="reservation.error.${requestScope.error}" var="errorMessage"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><fmt:message key="page.title" bundle="${labels}"/></title>
<c:if test="${not empty errorMessage}">
    <script type="application/javascript">
        window.alert('${errorMessage}');
    </script>
</c:if>
    <style>
        body {
            font-family: Verdana, sans-serif;
        }
    </style>
</head>