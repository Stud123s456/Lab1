package test.by.bsuir.insurance.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.insurance.servlet.CalcServlet;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.*;
import static org.junit.Assert.assertEquals;

public class CalcServletTest {

    private CalcServlet calcServlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        calcServlet = new CalcServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void calculateSumPayment() throws ServletException, IOException {

        request.addParameter(sumInsured, "100000");
        request.addParameter(insuranceOptionId, "1");
        request.addParameter(periodId, "1");
        request.addParameter(currencyId, "1");
        request.addParameter(contractTimeId, "1");

        calcServlet.doPost(request, response);

        String sumAmount = "320";
        String amount = "320";
        String currName = "BYN";

        assertEquals(sumAmount, request.getAttribute(SUMAMOUNT));
        assertEquals(amount, request.getAttribute(AMOUNT));
        assertEquals(currName, request.getAttribute(CURRNAME));
    }

}
