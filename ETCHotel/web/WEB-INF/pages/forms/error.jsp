<c:if test="${not empty errormsg}">
    <div class="alert alert-danger" role="alert">${errormsg}</div>
</c:if>

<c:if test="${not empty fullname_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="fullname.not.found"/></div>
</c:if>

<c:if test="${not empty contact_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="contact.not.found"/></div>
</c:if>

<c:if test="${not empty address_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="login.not.found"/></div>
</c:if>

<c:if test="${not empty sum_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="sum.not.found"/></div>
</c:if>

<c:if test="${not empty login_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="login.not.found"/></div>
</c:if>

<c:if test="${not empty user_not_auth}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="user.not.auth"/></div>
</c:if>

<c:if test="${not empty declaration_ok}">
    <div class="alert alert-success" role="alert"><fmt:message bundle="${labels}" key="declaration.ok"/></div>
</c:if>

<c:if test="${not empty declaration_no}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="declaration.no"/></div>
</c:if>

<c:if test="${not empty params_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="params.not.found"/></div>
</c:if>

<c:if test="${not empty contract_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="contract.not.found"/></div>
</c:if>

<c:if test="${not empty currency_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="currency.not.found"/></div>
</c:if>

<c:if test="${not empty period_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="period.not.found"/></div>
</c:if>

<c:if test="${not empty insurance_not_found}">
    <div class="alert alert-danger" role="alert"><fmt:message bundle="${labels}" key="insurance.not.found"/></div>
</c:if>

<c:if test="${not empty contract_success}">
    <div class="alert alert-success" role="alert"><fmt:message bundle="${labels}" key="contract.success"/></div>
</c:if>

