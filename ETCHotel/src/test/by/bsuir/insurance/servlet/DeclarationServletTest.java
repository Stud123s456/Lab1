package test.by.bsuir.insurance.servlet;

import by.bsuir.insurance.entity.obj.Employee;
import by.bsuir.insurance.servlet.DeclarationServlet;
import static by.bsuir.insurance.helper.ServletHelper.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class DeclarationServletTest {

    private DeclarationServlet declarationServlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        declarationServlet = new DeclarationServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void initDeclaration() throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setId(1);
        request.getSession().setAttribute(USER, employee);

        //user info
        request.addParameter(FULLNAME, "Ivan Ivanov");
        request.addParameter(CONTACT, "90339988770");
        request.addParameter(ADDRESS, "Minsk");
        //program info
        request.addParameter(insuranceOptionId,"1");
        request.addParameter(periodId, "1");
        request.addParameter(contractTimeId, "1");
        request.addParameter(currencyId, "1");
        request.addParameter(sumInsured, "10000");

        declarationServlet.doPost(request, response);

        assertEquals("Заявка успешно оформлена", request.getAttribute("declaration_ok"));
    }

}
