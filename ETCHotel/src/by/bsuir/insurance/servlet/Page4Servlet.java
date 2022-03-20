package by.bsuir.insurance.servlet;

import by.bsuir.insurance.dao.ContractDao;
import by.bsuir.insurance.entity.Contract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.*;

public class Page4Servlet extends HttpServlet implements IServlet {

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(JSPPAGE4).forward(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        prepareData(request);
        request.setAttribute("contract_success", "Договор успешно заключен");
        getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
    }

    private void prepareData(HttpServletRequest request){
        Contract contract = (Contract) request.getSession().getAttribute(CONTRACT);
        ContractDao contractDao = ContractDao.getInstance();
        contractDao.insert(contract);
    }
}
