package by.bsuir.insurance.servlet;

import by.bsuir.insurance.dao.ProgramDao;
import by.bsuir.insurance.entity.Contract;
import by.bsuir.insurance.entity.obj.*;
import by.bsuir.insurance.service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.*;

public class Page2Servlet extends HttpServlet implements IServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(JSPPAGE2).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        prepareData(request);
        getServletContext().getRequestDispatcher(JSPPAGE3).forward(request, response);
    }

    private static void prepareData(HttpServletRequest request){
        Declaration declaration = (Declaration) request.getSession().getAttribute(DECLARATION);
        Client client = (Client) request.getSession().getAttribute(CLIENT);
        PaymentSchedule schedule = CalcService.start(declaration);

        ProgramDao programDao = ProgramDao.getInstance();
        Program program = programDao.getById(declaration.getInsuranceOptionId());
        String objects = program.getObjects();

        Employee employee = (Employee) request.getSession().getAttribute(USER);

        Contract contract = new Contract();
        contract.setParametrs(declaration, client, schedule);
        contract.setObjects(objects);
        contract.setEmployeeId(employee.getId());

        request.getSession().setAttribute(CONTRACT, contract);
        request.setAttribute(CONTRACT, contract);
    }
}
