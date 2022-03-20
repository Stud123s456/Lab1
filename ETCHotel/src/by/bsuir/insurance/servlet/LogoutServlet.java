package by.bsuir.insurance.servlet;

import by.bsuir.insurance.entity.obj.Employee;
import by.bsuir.insurance.helper.ServletHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.USER;

public class LogoutServlet extends HttpServlet implements IServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doLogout(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doLogout(request, response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (ServletHelper.isLogged(request)) {
            Employee employee = (Employee) request.getSession().getAttribute(USER);
            log.info("User " + employee.getLogin() + " has logged out");
            session.removeAttribute(USER);
        }
        getServletContext().getRequestDispatcher(ServletHelper.LOGINPAGE).forward(request, response);
    }
}
