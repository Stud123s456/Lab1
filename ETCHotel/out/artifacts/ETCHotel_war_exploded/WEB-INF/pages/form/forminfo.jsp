<div class="accordion" id="accordionExample">

    <div class="accordion-item">
        <h2 class="accordion-header" id="headingOne">
            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                <c:out value="${programm1.name}"/>
            </button>
        </h2>
        <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong><c:out value="${requestScope.programm1.name}"/>.</strong><br>
                <c:out value="${requestScope.programm1.content}"/>
            </div>
        </div>
    </div>

    <div class="accordion-item">
        <h2 class="accordion-header" id="headingTwo">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <c:out value="${requestScope.programm2.name}"/>
            </button>
        </h2>
        <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong><c:out value="${requestScope.programm2.name}"/>.</strong><br>
                <c:out value="${requestScope.programm2.content}"/>
            </div>
        </div>
    </div>

    <div class="accordion-item">
        <h2 class="accordion-header" id="headingThree">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <c:out value="${requestScope.programm3.name}"/>
            </button>
        </h2>
        <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong><c:out value="${requestScope.programm3.name}"/>.</strong><br>
                <c:out value="${requestScope.programm3.content}"/>
            </div>
        </div>
    </div>

    <div class="accordion-item">
        <h2 class="accordion-header" id="heading4">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse4" aria-expanded="false" aria-controls="collapse4">
                <c:out value="${requestScope.programm4.name}"/>
            </button>
        </h2>
        <div id="collapse4" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong><c:out value="${requestScope.programm4.name}"/>.</strong><br>
                <c:out value="${requestScope.programm4.content}"/>
            </div>
        </div>
    </div>

    <div class="accordion-item">
        <h2 class="accordion-header" id="heading5">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
                <c:out value="${requestScope.programm5.name}"/>
            </button>
        </h2>
        <div id="collapse5" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong><c:out value="${requestScope.programm5.name}"/>.</strong><br>
                <c:out value="${requestScope.programm5.content}"/>
            </div>
        </div>
    </div>

</div>