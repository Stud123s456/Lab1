package by.bsuir.insurance.servlet;

import by.bsuir.insurance.dao.EmployeeDao;
import by.bsuir.insurance.entity.obj.Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.bsuir.insurance.helper.ServletHelper.*;

public class LoginServlet extends HttpServlet implements IServlet {

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher(MAINPAGE).forward(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String login = getParam(request, LOGIN);
        if (login.isEmpty()) {
            request.setAttribute("login_not_found", "Логин не обнаружен");
            getServletContext().getRequestDispatcher(MAINPAGE).forward(request, response);
            return;
        }

        String password = getParam(request, PASSWORD);
        Employee employee = EmployeeDao.getInstance().getByLogin(login);
        if (employee == null || !employee.getPassword().equals(password)) {
            request.setAttribute("user_not_auth", "Пользователь не зарегистрирован");
            getServletContext().getRequestDispatcher(MAINPAGE).forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute(USER, employee);
        log.info("Employee " + employee.getLogin() + " has logged in");
        getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
    }
}
