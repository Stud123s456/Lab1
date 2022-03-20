<div class="card">
  <div class="card-body">

    <c:if test="${not empty fullname}">
      <h6><strong><fmt:message bundle="${labels}" key="card.user.item1"/></strong></h6>
      <h6><small><c:out value="${fullName}"/></small></h6><br>
    </c:if>

    <c:if test="${not empty contact}">
      <h6><strong><fmt:message bundle="${labels}" key="card.user.item2"/></strong></h6>
      <h6><small><c:out value="${contact}"/></small></h6><br>
    </c:if>

    <c:if test="${not empty address}">
      <h6><strong><fmt:message bundle="${labels}" key="card.user.item3"/></strong></h6>
      <h6><small><c:out value="${address}"/></small></h6>
    </c:if>

  </div>
</div>