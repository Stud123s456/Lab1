package by.bsuir.insurance.servlet;

import by.bsuir.insurance.entity.obj.Declaration;
import by.bsuir.insurance.helper.ServletHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet implements IServlet {

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Declaration d = new Declaration();
        String addr = d.getAddress();
        getServletContext().getRequestDispatcher(ServletHelper.MAINPAGE).forward(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(ServletHelper.MAINPAGE).forward(request, response);
    }
}
