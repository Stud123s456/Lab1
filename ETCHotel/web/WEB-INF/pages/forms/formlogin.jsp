<form action="login" method="post">
  <div class="row text-center">
    <div class="col-3"></div>
    <div class="col-9">
      <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
          <%@ include file = "error.jsp" %>
          <div class="col-md-4"><br><br>
            <img src="${pageContext.request.contextPath}/images/ins.jpeg" class="img-fluid rounded-start">
          </div><br><br>
          <div class="col-md-8">
            <div class="card-body"><br>
              <h5 class="card-title"><fmt:message bundle="${labels}" key="declaration.signin"/></h5><br>
              <div class="form-floating mb-3">
                <input type="text" name="login" maxlength="20" class="form-control" id="floatingInput" placeholder="<fmt:message bundle="${labels}" key="login.login"/>">
                <label for="floatingInput"><fmt:message bundle="${labels}" key="login.login"/></label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" name="password" maxlength="20" class="form-control" id="floatingPassword" placeholder="<fmt:message bundle="${labels}" key="login.password"/>">
                <label for="floatingPassword"><fmt:message bundle="${labels}" key="login.password"/></label>
              </div><br>

              <button type="submit" name="btnLogin" class="btn btn-primary">
                <fmt:message bundle="${labels}" key="login.submit"/>
              </button>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
</form>