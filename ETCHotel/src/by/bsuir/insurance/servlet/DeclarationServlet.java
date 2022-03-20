package by.bsuir.insurance.servlet;

import by.bsuir.insurance.dao.ClientDao;
import by.bsuir.insurance.dao.DeclarationDao;
import by.bsuir.insurance.dao.ProgramDao;
import by.bsuir.insurance.entity.obj.*;
import by.bsuir.insurance.helper.ServletHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static by.bsuir.insurance.helper.ServletHelper.*;

public class DeclarationServlet extends HttpServlet implements IServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            String fullName = ServletHelper.getParam(request, FULLNAME);
            String contact = ServletHelper.getParam(request, CONTACT);
            String address = ServletHelper.getParam(request, ADDRESS);

            if (fullName.isEmpty()) {
                request.setAttribute("fullname_not_found", "ФИО не указано");
                getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
                return;
            }
            if (contact.isEmpty()) {
                request.setAttribute("contact_not_found", "Контакт не указан");
                getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
                return;
            }
            if (address.isEmpty()) {
                request.setAttribute("address_not_found", "Адрес не указан");
                getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
                return;
            }

            String insuranceOption = ServletHelper.getParam(request, insuranceOptionId);
            String period = ServletHelper.getParam(request, periodId);
            String contractTime = ServletHelper.getParam(request, contractTimeId);
            String currency = ServletHelper.getParam(request, currencyId);
            String sumInsuredValue = ServletHelper.getParam(request, sumInsured);
            if (sumInsuredValue.isEmpty()) {
                request.setAttribute("sum_not_found", "Страховая сумма не указана");
                getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
                return;
            }

            Employee employee = ServletHelper.getEmployee(request);
            int employeeId = (employee != null) ? employee.getId(): 1;

            ClientDao clientDao = ClientDao.getInstance();
            Client clientDb = clientDao.getByName(fullName);
            if(clientDb == null){
                request.setAttribute("user_not_auth", "Клиент не обнаружен");
                getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
                return;
            }
            Client client = new Client(clientDb.getId(), fullName, contact, address);

            Declaration declaration = new Declaration(fullName, contact, address,
                    Integer.parseInt(insuranceOption), Integer.parseInt(period),
                    Integer.parseInt(contractTime),  Integer.parseInt(currency),
                    Double.valueOf(sumInsuredValue), ServletHelper.getLocalDate(),
                    client.getId(), employeeId);

            DeclarationDao declarationDao = DeclarationDao.getInstance();
            declarationDao.insert(declaration);
            request.getSession().setAttribute(DECLARATION, declaration);
            request.getSession().setAttribute(CLIENT, client);

            int programId = Integer.parseInt(insuranceOption);
            String programParam = InsuranceOptionId.getParamFromId(programId);
            request.setAttribute(programParam, programParam);

            request.setAttribute("fullName", client.getFullname());
            request.setAttribute(CONTACT, client.getContact());
            request.setAttribute(ADDRESS, client.getAddress());

            request.setAttribute("declaration_ok", "Заявка успешно оформлена");
            getServletContext().getRequestDispatcher(JSPPAGE2).forward(request, response);

        } catch(Exception e){
            log.error(e.getMessage());
            request.setAttribute("declaration_no", "Ошибка при оформлении");
            getServletContext().getRequestDispatcher(JSPPAGE1).forward(request, response);
            return;
        }
    }

}
