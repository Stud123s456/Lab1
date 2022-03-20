<form action="calc" method="post">
<%@ include file = "error.jsp" %>
<div class="card">
  <div class="card-body">
    <div class="row">

      <!-- from -->
      <div class="col-md-8">
        <h4><fmt:message bundle="${labels}" key="calc.header"/></h4><br>
        <%@ include file = "programCard.jsp" %><br>
        <button type="submit" class="btn btn-success"><fmt:message bundle="${labels}" key="calc.submit"/></button><br>
      </div>

      <!-- to -->
      <div class="col-md-4"><br><br><br>
        <c:if test="${not empty sumAmount}">
          <h6><fmt:message bundle="${labels}" key="calc.header"/></h6>
          <h6><strong><c:out value="${sumAmount}" /> <c:out value="${currencyName}" /></strong></h6><br>
        </c:if>
        <c:if test="${not empty amount}">
          <h6><fmt:message bundle="${labels}" key="calc.payment"/></h6>
          <h6><strong><c:out value="${amount}" /> <c:out value="${currencyName}" /></strong></h6><br>
        </c:if>
        <c:if test="${not empty dateEnd}"></c:if>
      </div>

    </div>
  </div>
</div>
</form>
