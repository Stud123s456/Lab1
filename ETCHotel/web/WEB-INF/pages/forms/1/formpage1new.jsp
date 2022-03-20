<form action="declaration" method="post">
    <%@ include file = "../error.jsp" %>

    <div class="card">
        <div class="card-body">
            <div class="row">
                <!-- program card -->
                <%@ include file = "formpage_1.jsp" %>

                <!-- user card -->
                <div class="col-md-4">
                    <!-- header -->
                    <h4><fmt:message bundle="${labels}" key="user.card.header1"/></h4><br>

                    <!-- name e-mail address -->
                    <div class="form-floating mb-3">
                        <input type="text" name="fullName" maxlength="50" class="form-control" id="floatingInput1" placeholder="<fmt:message bundle="${labels}" key="declaration.item1"/>">
                        <label for="floatingInput1"><fmt:message bundle="${labels}" key="declaration.item1"/></label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" name="contact" maxlength="50" class="form-control" id="floatingInput2" placeholder="<fmt:message bundle="${labels}" key="declaration.item2"/>">
                        <label for="floatingInput2"><fmt:message bundle="${labels}" key="declaration.item2"/></label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" name="address" maxlength="50" class="form-control" id="floatingInput3" placeholder="<fmt:message bundle="${labels}" key="declaration.item3"/>">
                        <label for="floatingInput3"><fmt:message bundle="${labels}" key="declaration.item3"/></label>
                    </div>

                    <button type="submit" class="btn btn-success"><fmt:message bundle="${labels}" key="declaration.submit"/></button><br><br>
                </div><br>

            </div>
        </div><!-- card-body -->
    </div>
    </div>
</form>

