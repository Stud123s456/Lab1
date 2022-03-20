<form action="declaration" method="post">
  <div class="row">
    <div class="col-4">
      <%@ include file = "error.jsp" %>

      <div class="form-floating mb-3">
        <input type="text" name="fullname" maxlength="50" class="form-control" id="floatingInput1" placeholder="<fmt:message bundle="${labels}" key="declaration.item1"/>">
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


      <div class="form-floating mb-3">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="programTypeId" value="1" id="flexRadioDefault1">
          <label class="form-check-label" for="flexRadioDefault1"><fmt:message bundle="${labels}" key="insurance.type1"/></label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="programTypeId" value="2" id="flexRadioDefault2" checked>
          <label class="form-check-label" for="flexRadioDefault2"><fmt:message bundle="${labels}" key="insurance.type2"/></label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="programTypeId" value="3" id="flexRadioDefault3" checked>
          <label class="form-check-label" for="flexRadioDefault3"><fmt:message bundle="${labels}" key="insurance.type3"/></label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="programTypeId" value="4" id="flexRadioDefault4" checked>
          <label class="form-check-label" for="flexRadioDefault4"><fmt:message bundle="${labels}" key="insurance.type4"/></label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="programTypeId" value="5" id="flexRadioDefault5" checked>
          <label class="form-check-label" for="flexRadioDefault5"><fmt:message bundle="${labels}" key="insurance.type5"/></label>
        </div>
      </div>
      <div class="form-floating mb-3">
        <input type="text" name="date" maxlength="50" class="form-control" id="floatingInput6" placeholder="<fmt:message bundle="${labels}" key="declaration.item6"/>">
        <label for="floatingInput6"><fmt:message bundle="${labels}" key="declaration.item6"/></label>
      </div>
      <div class="form-floating mb-3">
        <input type="text" name="comment" maxlength="50" class="form-control" id="floatingInput7" placeholder="<fmt:message bundle="${labels}" key="declaration.item7"/>">
        <label for="floatingInput7"><fmt:message bundle="${labels}" key="declaration.item7"/></label>
      </div>
      <div class="form-floating mb-3">
        <div class="btn-group" role="group">
          <input type="radio" class="btn-check" name="declarationId" value="1" name="declarationId" id="btnradio1" autocomplete="off" checked>
          <label class="btn btn-outline-primary" for="btnradio1"><fmt:message bundle="${labels}" key="declaration.type.item1"/></label>
          <!--
          <input type="radio" class="btn-check" name="declarationId" value="2" name="declarationId" id="btnradio2" autocomplete="off">
          <label class="btn btn-outline-primary" for="btnradio2"><fmt:message bundle="${labels}" key="declaration.type.item2"/></label>
          -->
          <input type="radio" class="btn-check" name="declarationId" value="3" name="declarationId" id="btnradio3" autocomplete="off">
          <label class="btn btn-outline-primary" for="btnradio3"><fmt:message bundle="${labels}" key="declaration.type.item3"/></label>
        </div>
      </div>
      <button type="submit" class="btn btn-outline-primary">
        <fmt:message bundle="${labels}" key="declaration.button"/>
      </button>
    </div>
  </div>
</form>