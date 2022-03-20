<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="en_US"/>
<c:if test="${not empty sessionScope.locale}">
    <c:set var="locale" value="${sessionScope.locale}"/>
</c:if>

<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="by.bsuir.reservation.locales.labels" var="labels" />

<c:if test="${not empty requestScope.error}">
    <fmt:message bundle="${labels}" key="login.error.${requestScope.error}" var="errorMessage"/>
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
        .tt {
            border: 4px double;
            border-collapse: separate;
            width: 100%;
            border-spacing: 7px 11px;
        }
        .ttd {
            font-family: Verdana, sans-serif;
            padding: 5px;
            border: 1px solid;
        }
    </style>
</head>
