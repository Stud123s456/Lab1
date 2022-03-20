package by.bsuir.insurance.servlet;

import by.bsuir.insurance.dao.ContractDao;
import by.bsuir.insurance.entity.Contract;
import by.bsuir.insurance.entity.obj.Employee;
import by.bsuir.insurance.helper.ServletHelper;
import by.bsuir.insurance.servlet.IServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static by.bsuir.insurance.helper.ServletHelper.*;

public class ArchiveServlet extends HttpServlet implements IServlet {

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        prepareData(request);
        getServletContext().getRequestDispatcher(ServletHelper.ARCHPAGE).forward(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String contractId = ServletHelper.getParam(request, "contractId");
        if(!contractId.isEmpty()){
            ContractDao contractDao = ContractDao.getInstance();
            contractDao.deleteById(Integer.parseInt(contractId));
        }

        getServletContext().getRequestDispatcher(ServletHelper.ARCHPAGE).forward(request, response);
    }

    private void prepareData(HttpServletRequest request) {
        Employee employee = (Employee) request.getSession().getAttribute(USER);
        if(employee != null){
            ContractDao contractDao = ContractDao.getInstance();
            ArrayList<Contract> contracts = contractDao.getAllById(employee.getId());
            request.setAttribute(CONTRACTS, contracts);
        }
    }
}
