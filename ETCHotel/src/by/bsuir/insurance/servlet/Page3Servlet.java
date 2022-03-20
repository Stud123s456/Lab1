package by.bsuir.insurance.servlet;

import by.bsuir.insurance.dao.ContractDao;
import by.bsuir.insurance.entity.Contract;
import by.bsuir.insurance.helper.ServletHelper;
import org.apache.logging.log4j.core.jmx.Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.*;

public class Page3Servlet extends HttpServlet implements IServlet {

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(JSPPAGE3).forward(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String operation = ServletHelper.getParam(request, "operation");
        if(Integer.parseInt(operation) == 1){
            Contract contract = (Contract) request.getSession().getAttribute(CONTRACT);
            request.setAttribute(CONTRACT, contract);
            getServletContext().getRequestDispatcher(JSPPAGE4).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(MAINPAGE).forward(request, response);
        }
    }

}
