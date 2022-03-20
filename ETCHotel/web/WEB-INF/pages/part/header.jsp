<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="ru_RU"/>
<c:if test="${not empty sessionScope.locale}">
    <c:set var="locale" value="${sessionScope.locale}"/>
</c:if>

<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="by.bsuir.insurance.locales.labels" var="labels" />

<c:if test="${not empty requestScope.error}">
    <fmt:message bundle="${labels}" key="login.error.${requestScope.error}" var="errorMessage"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="page.title" bundle="${labels}"/></title>
    <c:if test="${not empty errorMessage}">
    </c:if>
    <style>
        body {
            color: black;
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
        .fon {
            background: lightgray;
        }
        .fon1 {
            background: #0a53be;
        }
        .fon2 {
            background: #0d6efd;
        }
    </style>

    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js" integrity="sha512-UR25UO94eTnCVwjbXozyeVd6ZqpaAE9naiEUBK/A+QDbfSTQFhPGj5lOR6d8tsgbBk84Ggb5A3EkjsOgPRPcKA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>