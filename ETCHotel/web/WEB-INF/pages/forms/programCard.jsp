<div class="row">
    <!-- Вариант страхования -->
    <div class="col-md-6">
        <h6><fmt:message bundle="${labels}" key="user.card.table1"/></h6>
        <div class="form-floating mb-3">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="insuranceOptionId" value="1" id="typeid1" checked>
                <label class="form-check-label" for="typeid1">
                    <fmt:message bundle="${labels}" key="user.card.table1.item1"/>
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="insuranceOptionId" value="2" id="typeid2" >
                <label class="form-check-label" for="typeid2">
                    <fmt:message bundle="${labels}" key="user.card.table1.item2"/>
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="insuranceOptionId" value="3" id="typeid3" >
                <label class="form-check-label" for="typeid3">
                    <fmt:message bundle="${labels}" key="user.card.table1.item3"/>
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="insuranceOptionId" value="4" id="typeid4" >
                <label class="form-check-label" for="typeid4">
                    <fmt:message bundle="${labels}" key="user.card.table1.item4"/>
                </label>
            </div>
        </div>
    </div>

    <!-- Порядок выплаты: period -->
    <div class="col-md-3">
        <h6><fmt:message bundle="${labels}" key="user.card.table2"/></h6>
        <div class="form-floating mb-3">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="periodId" value="1" id="periodId1" checked>
                <label class="form-check-label" for="periodId1"><fmt:message bundle="${labels}" key="user.card.table2.item1"/></label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="periodId" value="2" id="periodId2">
                <label class="form-check-label" for="periodId2"><fmt:message bundle="${labels}" key="user.card.table2.item2"/></label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="periodId" value="3" id="periodId3">
                <label class="form-check-label" for="periodId3"><fmt:message bundle="${labels}" key="user.card.table2.item3"/></label>
            </div>
        </div>
    </div>

    <!-- Срок действия договора: contractTime -->
    <div class="col-md-3">
        <h6><fmt:message bundle="${labels}" key="user.card.table3"/></h6>

        <div class="form-floating ">
            <div class="form-check mb-3">
                <input class="form-check-input" type="radio" name="contractTimeId" value="1" id="contractTimeId1">
                <label class="form-check-label" for="contractTimeId1"><fmt:message bundle="${labels}" key="user.card.table3.item1"/></label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="contractTimeId" value="2" id="contractTimeId2">
                <label class="form-check-label" for="contractTimeId2"><fmt:message bundle="${labels}" key="user.card.table3.item2"/></label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="contractTimeId" value="3" id="contractTimeId3">
                <label class="form-check-label" for="contractTimeId3"><fmt:message bundle="${labels}" key="user.card.table3.item3"/></label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="contractTimeId" value="4" id="contractTimeId4">
                <label class="form-check-label" for="contractTimeId4"><fmt:message bundle="${labels}" key="user.card.table3.item4"/></label>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <!-- Общая сумма для страхования -->
    <div class="col-4">
        <h6><fmt:message bundle="${labels}" key="user.card.table5"/></h6>
        <input type="number" name="sumInsured" maxlength="20" min="3000" max="300000" class="form-control" id="f" placeholder="100.000">
    </div>

    <!-- Валюта -->
    <div class="col-4">
        <h6><fmt:message bundle="${labels}" key="user.card.table4"/></h6>
        <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
            <input type="checkbox" class="btn-check" name="currencyId" value="1" id="btncheck1" autocomplete="off">
            <label class="btn btn-outline-primary" for="btncheck1"><fmt:message bundle="${labels}" key="user.card.table4.item1"/></label>
            <input type="checkbox" class="btn-check" name="currencyId" value="2" id="btncheck2" autocomplete="off">
            <label class="btn btn-outline-primary" for="btncheck2"><fmt:message bundle="${labels}" key="user.card.table4.item2"/></label>
        </div>
    </div>
</div>