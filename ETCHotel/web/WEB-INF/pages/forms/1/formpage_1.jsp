<div class="row">
    <!-- user.card.table1.item1 -->
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            VIBOR
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <li><a class="dropdown-item" href="/ETCHotel/menu1"><fmt:message bundle="${labels}" key="user.card.table1.item1"/></a></li>
            <li><a class="dropdown-item" href="/ETCHotel/menu2"><fmt:message bundle="${labels}" key="user.card.table1.item2"/></a></li>
            <li><a class="dropdown-item" href="/ETCHotel/menu3"><fmt:message bundle="${labels}" key="user.card.table1.item3"/></a></li>
            <li><a class="dropdown-item" href="/ETCHotel/menu4"><fmt:message bundle="${labels}" key="user.card.table1.item4"/></a></li>
        </ul>
    </div><br>


    <!-- Вариант страхования: insuranceOptionId=1 -->
    <input type="hidden" name="insuranceOptionId" value="1">
    <h6><fmt:message bundle="${labels}" key="program.menu1"/></h6><br>
    <h6><small><fmt:message bundle="${labels}" key="program.name.description1"/></small></h6>

    <!-- Объекты страхования -->
    <h6><fmt:message bundle="${labels}" key="program.menu2"/></h6>
    <h6><small><fmt:message bundle="${labels}" key="program.name1.obj1"/></small></h6>
    <h6><small><fmt:message bundle="${labels}" key="program.name1.obj2"/></small></h6>
    <h6><small><fmt:message bundle="${labels}" key="program.name1.obj3"/></small></h6>

    <!-- Срок действия договора: contractTimeId=3 -->
    <input type="hidden" name="contractTimeId" value="3">
    <h6><fmt:message bundle="${labels}" key="program.menu3"/> <fmt:message bundle="${labels}" key="user.card.table3.item3"/></h6><br>

    <!-- Порядок выплаты: periodId -->
    <h6><fmt:message bundle="${labels}" key="program.menu4"/></h6><br>
    <div class="btn-group" role="group">
        <input type="checkbox" class="btn-check" name="periodId" value="1" id="b1" autocomplete="off" checked>
        <label class="btn btn-outline-primary" for="b1">
            <fmt:message bundle="${labels}" key="user.card.table2.item1"/>
        </label>
        <input type="checkbox" class="btn-check" name="periodId" value="2" id="b2" autocomplete="off">
        <label class="btn btn-outline-primary" for="b2">
            <fmt:message bundle="${labels}" key="user.card.table2.item2"/>
        </label>
        <input type="checkbox" class="btn-check" name="periodId" value="3" id="b3" autocomplete="off">
        <label class="btn btn-outline-primary" for="b3">
            <fmt:message bundle="${labels}" key="user.card.table2.item3"/>
        </label>
    </div>


    <!-- Общая сумма для страхования -->
    <div class="col-4">
        <h6><fmt:message bundle="${labels}" key="user.card.table5"/></h6>
        <input type="number" name="sumInsured" maxlength="20" min=1 class="form-control" id="f" placeholder="100.000">
    </div>

    <!-- Валюта -->
    <div class="col-4">
        <h6><fmt:message bundle="${labels}" key="user.card.table4"/></h6>
        <div class="btn-group" role="group">
            <input type="checkbox" class="btn-check" name="currencyId" value="1" id="btncheck1" autocomplete="off" checked>
            <label class="btn btn-outline-primary" for="btncheck1"><fmt:message bundle="${labels}" key="user.card.table4.item1"/></label>
            <input type="checkbox" class="btn-check" name="currencyId" value="2" id="btncheck2" autocomplete="off">
            <label class="btn btn-outline-primary" for="btncheck2"><fmt:message bundle="${labels}" key="user.card.table4.item2"/></label>
        </div>
    </div>

</div>