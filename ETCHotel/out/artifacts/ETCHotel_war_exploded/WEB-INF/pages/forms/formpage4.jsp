<form action="page4" method="post">
    <form action="page3" method="post">
        <div class="card">
            <div class="card-body">
                <!-- header -->
                <nav class="navbar navbar-light bg-light">
                    <div class="container-fluid">
                        <span class="navbar-brand mb-0 h1"><fmt:message bundle="${labels}" key="proposal.contract"/></span>
                    </div>
                </nav><br>
                <!-- proposal -->
                <c:if test="${not empty requestScope.contract}">

                    <h6><strong><fmt:message bundle="${labels}" key="proposal.name1"/></strong></h6>
                    <h6><small><c:out value="${requestScope.contract.programmName}" /></small></h6><br>

                    <h6><strong><fmt:message bundle="${labels}" key="proposal.name2"/></strong></h6>
                    <h6><small><c:out value="${requestScope.contract.objects}" /></small></h6><br>

                    <h6><strong><fmt:message bundle="${labels}" key="proposal.name3"/></strong></h6>
                    <h6><small><c:out value="${requestScope.contract.sum}" /> <c:out value="${requestScope.contract.currencyName}" /></small></h6><br>

                    <h6><strong><fmt:message bundle="${labels}" key="proposal.name4"/></strong></h6>
                    <h6><small><c:out value="${requestScope.contract.sumPayment}" /> <c:out value="${requestScope.contract.currencyName}" /></small></h6><br>

                    <h6><strong><fmt:message bundle="${labels}" key="proposal.name5"/></strong></h6>
                    <h6><small><c:out value="${requestScope.contract.endDate}" /></small></h6><br><br>
                </c:if>

                <button type="submit" class="btn btn-outline-success">
                    <input type="hidden" name="operation" value="success">
                    <fmt:message bundle="${labels}" key="proposal.button.save"/>
                </button>

            </div>
        </div>
    </form>

</form>