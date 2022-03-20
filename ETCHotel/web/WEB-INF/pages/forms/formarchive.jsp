<c:if test="${not empty requestScope.contracts}">
  <table class="table caption-top">
    <thead>
      <tr>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header1"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header2"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header3"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header4"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header5"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header6"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header7"/></th>
          <th scope="col"><fmt:message bundle="${labels}" key="arch.header8"/></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="rv" items="${requestScope.contracts}">
      <tr>
          <td><c:out value="${rv.id}"/></td>
          <td><c:out value="${rv.fullName}"/></td>
          <td><c:out value="${rv.programmName}"/></td>
          <td><c:out value="${rv.sum}"/></td>
          <td><c:out value="${rv.sumPayment}"/></td>
          <td><c:out value="${rv.currencyName}"/></td>
          <td><c:out value="${rv.periodName}"/></td>
          <td><c:out value="${rv.endDate}"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>
