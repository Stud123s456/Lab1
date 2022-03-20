<form action="page4" method="post">
  <table class="table caption-top">
    <c:if test="${not empty requestScope.program1}">
        <tr><td><img src="${pageContext.request.contextPath}/images/1/1.png" class="img-fluid rounded-start"></td></tr>
        <tr><td><img src="${pageContext.request.contextPath}/images/1/2.png" class="img-fluid rounded-start"></td></tr>
        <tr><td><img src="${pageContext.request.contextPath}/images/1/3.png" class="img-fluid rounded-start"></td></tr>
    </c:if>

    <c:if test="${not empty requestScope.program2}">
        <tr><td><img src="${pageContext.request.contextPath}/images/2/1.png" class="img-fluid rounded-start"></td></tr>
        <tr><td><img src="${pageContext.request.contextPath}/images/2/2.png" class="img-fluid rounded-start"></td></tr>
    </c:if>

    <c:if test="${not empty requestScope.program3}">
        <tr><td><img src="${pageContext.request.contextPath}/images/3/1.png" class="img-fluid rounded-start"></td></tr>
        <tr><td><img src="${pageContext.request.contextPath}/images/3/2.png" class="img-fluid rounded-start"></td></tr>
    </c:if>

    <c:if test="${not empty requestScope.program4}">
        <tr><td><img src="${pageContext.request.contextPath}/images/4/1.png" class="img-fluid rounded-start"></td></tr>
        <tr><td><img src="${pageContext.request.contextPath}/images/4/2.png" class="img-fluid rounded-start"></td></tr>
    </c:if>

    <c:if test="${not empty requestScope.program5}">
        <tr><td><img src="${pageContext.request.contextPath}/images/5/1.png" class="img-fluid rounded-start"></td></tr>
        <tr><td><img src="${pageContext.request.contextPath}/images/5/2.png" class="img-fluid rounded-start"></td></tr>
    </c:if>

  </table>
  <button type="submit" class="btn btn-outline-primary">
    <fmt:message bundle="${labels}" key="button.1"/>
  </button>
</form>