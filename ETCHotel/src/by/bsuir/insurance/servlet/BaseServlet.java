package by.bsuir.insurance.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.INFOPAGE;

public class BaseServlet extends HttpServlet implements IServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        prepareData(request);
        getServletContext().getRequestDispatcher(INFOPAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(INFOPAGE).forward(request, response);
    }

    private void prepareData(HttpServletRequest request){

    }
}
