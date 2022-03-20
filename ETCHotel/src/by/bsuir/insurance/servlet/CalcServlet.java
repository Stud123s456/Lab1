package by.bsuir.insurance.servlet;

import by.bsuir.insurance.entity.obj.Currency;
import by.bsuir.insurance.entity.obj.Declaration;
import by.bsuir.insurance.entity.obj.PaymentSchedule;
import by.bsuir.insurance.helper.ServletHelper;
import by.bsuir.insurance.service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static by.bsuir.insurance.helper.ServletHelper.CALCPAGE;
import static by.bsuir.insurance.helper.ServletHelper.*;

public class CalcServlet extends HttpServlet implements IServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
    }

    @Override
    public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            String sumInsured1 = ServletHelper.getParam(request, sumInsured);
            if (sumInsured1.isEmpty()) {
                request.setAttribute("sum_not_found", "Страховая сумма не указана");
                getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
                return;
            }

            String insuranceOption = ServletHelper.getParam(request, insuranceOptionId);
            if (insuranceOption.isEmpty()) {
                request.setAttribute("insurance_not_found", "Выберите программу страхования");
                getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
                return;
            }

            String periodId1 = ServletHelper.getParam(request, periodId);
            if (periodId1.isEmpty()) {
                request.setAttribute("period_not_found", "Выберите порядок выплат");
                getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
                return;
            }

            String currencyId1 = ServletHelper.getParam(request, currencyId);
            if (currencyId1.isEmpty()) {
                request.setAttribute("currency_not_found", "Выберите валюту");
                getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
                return;
            }

            String contractTimeId1 = ServletHelper.getParam(request, contractTimeId);
            if (contractTimeId1.isEmpty()) {
                request.setAttribute("contract_not_found", "Выберите срок действия договора");
                getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
                return;
            }

            Declaration declaration = new Declaration();
            declaration.setId(0);
            declaration.setInsuranceOptionId(Integer.parseInt(insuranceOption));
            declaration.setPeriodId(Integer.parseInt(periodId1));
            declaration.setCurrencyId(Integer.parseInt(currencyId1));
            declaration.setSumInsured(Double.valueOf(sumInsured1));
            declaration.setContractTimeId(Integer.parseInt(contractTimeId1));

            PaymentSchedule schedule = CalcService.start(declaration);
            double sumAmount = schedule.getSumAmount();
            double amount = schedule.getAmount();
            String dateEnd = schedule.getDateEnd();
            String currencyName = (Integer.parseInt(currencyId1) == Currency.BYN.getId()) ?
                    Currency.BYN.getName(): Currency.USD.getName();

            request.setAttribute(SUMAMOUNT, sumAmount);
            request.setAttribute(AMOUNT, amount);
            request.setAttribute(DATEEND, dateEnd);
            request.setAttribute(CURRNAME, currencyName);
            getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);

        } catch(Exception e){
            log.error(e.getMessage());
            request.setAttribute("declaration_no", "Ошибка при оформлении");
            getServletContext().getRequestDispatcher(CALCPAGE).forward(request, response);
            return;
        }
    }

}
