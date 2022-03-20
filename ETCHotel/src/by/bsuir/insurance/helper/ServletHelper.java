package by.bsuir.insurance.helper;

import by.bsuir.insurance.entity.obj.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ServletHelper {
    private final static Logger LOG = LogManager.getRootLogger();

    private final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public final static String RESERVATION_PAGE = "/WEB-INF/jsp/reservation.jsp";
    public final static String SETTINGS_PAGE = "/WEB-INF/jsp/settings.jsp";

    public final static String INFOPAGE = "/WEB-INF/pages/info.jsp";
    public final static String ARCHPAGE = "/WEB-INF/pages/archive.jsp";
    public final static String CALCPAGE = "/WEB-INF/pages/calc.jsp";

    public final static String LOGINPAGE = "/WEB-INF/pages/main.jsp";
    public final static String MAINPAGE = "/WEB-INF/pages/main.jsp";
    public final static String JSPPAGE1 = "/WEB-INF/pages/jsp/page1.jsp";
    public final static String JSPPAGE2 = "/WEB-INF/pages/jsp/page2.jsp";
    public final static String JSPPAGE3 = "/WEB-INF/pages/jsp/page3.jsp";
    public final static String JSPPAGE4 = "/WEB-INF/pages/jsp/page4.jsp";
    public final static String MPAGE1 = "/WEB-INF/pages/jsp/mpage1.jsp";
    public final static String MPAGE2 = "/WEB-INF/pages/jsp/mpage2.jsp";
    public final static String MPAGE3 = "/WEB-INF/pages/jsp/mpage3.jsp";


    public static String getString(HttpServletRequest request, String paramName, String defaultValue) {
        String result = request.getParameter(paramName);
        return  (result == null) ? defaultValue : result;
    }

    public static int getInt(HttpServletRequest request, String paramName, int defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        int result = defaultValue;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            LOG.error("Incorrect integer value: ", ex);
        }
        return result;
    }

    public static double getDouble(HttpServletRequest request, String paramName, double defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        double result = defaultValue;
        try {
            result = Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            LOG.error("Incorrect double value: ", ex);
        }
        return result;
    }

    public static LocalDate getDate(HttpServletRequest request, String paramName, LocalDate defaultValue) {
        String value = request.getParameter(paramName);
        LocalDate date = null;
        if (value == null || value.isEmpty())
            return defaultValue;
        try {
            date = LocalDate.parse(value, dateFormat);
        } catch (DateTimeParseException e) {
            LOG.error("Incorrect date value: ", e);
            return defaultValue;
        }
        return date;
    }

    public static boolean isValidDate(HttpServletRequest request, String paramName) {
        String value = request.getParameter(paramName);
        if (value == null || value.isEmpty())
            return false;
        try {
            LocalDate.parse(value, dateFormat);
        } catch (DateTimeParseException e) {
            LOG.error("Incorrect date value: ", e);
            return false;
        }
        return true;
    }

    public static boolean hasValue(HttpServletRequest request, String paramName) {
        String value = request.getParameter(paramName);
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isLogged(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(USER) != null;
    }

    public static String getParam(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return  (paramValue == null) ? "" : paramValue;
    }

    public static Object getSessionAttr(HttpServletRequest request, String attrName) {
        HttpSession session = request.getSession();
        return session.getAttribute(attrName);
    }

    public static String encodePassword(String password) throws IOException {
        String md5Hash = password;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte [] hash = md.digest();
            md5Hash = DatatypeConverter.printHexBinary(hash).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            LOG.error("MD5 Algorithm not found: ", e);
        }
        return md5Hash;
    }

    public static String parseDateToString(LocalDate date) {
        return dateFormat.format(date);
    }

    public static Employee getEmployee(HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute(USER);
        return employee;
    }

    public static String getLocalDate() {
        try {
            LocalDate date = LocalDate.now();
            return dateFormat.format(date);
        } catch (DateTimeParseException e) {
            LOG.error("Incorrect date value: ", e);
        }
        return "";
    }

    public static String getLocalEndDate(int numMonths) {
        try {
            LocalDate date = LocalDate.now();
            LocalDate endDate = date.plusMonths(numMonths);
            return dateFormat.format(endDate);
        } catch (DateTimeParseException e) {
            LOG.error("Incorrect date value: ", e);
        }
        return "";
    }

    public final static String USER = "user";
    public final static String LOGIN = "login";
    public final static String PHONE = "phone";
    public final static String PASSWORD = "password";
    public final static String CONFIRM = "confirm";
    public final static String LANG = "lang";
    public final static String LOCALE = "locale";

    public final static String ERROR = "error";
    public final static String ERRORMSG = "errormsg";

    /* error message */
    public final static String NO_LOGIN = "no_login";
    public final static String LOGIN_INCORRECT = "login_incorrect";
    public final static String REGISTRATION_SUCCESS = "registration.success";
    public final static String PASSWORD_MISMATCH = "password_mismatch";
    public final static String NON_UNIQUE = "non_unique_login";
    public final static String BD_ERROR = "bd_error";
    public final static String DB_ERROR = "db_error";
    public final static String SUCCESS = "success";

    public final static String NO_DATEFROM = "no_date_from";
    public final static String NO_DATETO = "no_date_to";
    public final static String WRONG_DATES = "wrong_dates";
    public final static String NO_TYPE = "no_type";
    public final static String NO_VIEW = "no_view";
    public final static String NO_USER = "no_user";
    public final static String NO_NAME = "no_name";
    public final static String FAILED = "failed";

    public final static String EMPLOYEEID = "employeeId";
    public final static String CLIENTNAME = "clientName";
    public final static String PROGRAMTYPE = "programTypeId";
    public final static String DECLARATIONID = "declarationId";
    public final static String DATE = "date";
    public final static String COMMENT = "comment";

    public final static String DECLARATIONS = "declarations";
    public final static String CONTRACTS = "contracts";

    public final static String CLIENT = "client";
    public final static String PROGRAMM = "programm";
    public final static String CONTRACT = "contract";
    public final static String CLIENTINFO = "clientinfo";
    public final static String PROGRAMINFO = "programinfo";

    //card
    public final static String FULLNAME = "fullName";
    public final static String CONTACT = "contact";
    public final static String ADDRESS = "address";
    public final static String insuranceOptionId = "insuranceOptionId";
    public final static String contractTimeId = "contractTimeId";
    public final static String currencyId = "currencyId";
    public final static String sumInsured = "sumInsured";
    public final static String periodId = "periodId";
    public final static String DECLARATION = "declaration";

    public final static String SUMAMOUNT = "sumAmount";
    public final static String AMOUNT = "amount";
    public final static String DATEEND = "dateEnd";
    public final static String CURRNAME = "currencyName";

}
