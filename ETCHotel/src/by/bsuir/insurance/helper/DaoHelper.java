package by.bsuir.insurance.helper;

public class DaoHelper {

    public final static String SELECT_USER_BY_LOGIN = "SELECT * FROM employee where login = ?";

    public final static String SELECT_CONTRACT = "select * from contract";

    public final static String SELECT_CONTRACT_BY_ID = "select * from contract where employee_id=?";

    public final static String INSERT_DECLARATION = "insert into declaration values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public final static String INSERT_CONTRACT = "insert into contract values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public final static String NEXTID_DECLARATION = "select max(id) as id from declaration";

    public final static String NEXTID_CONTRACT = "select max(id) as id from contract";

    public final static String DELETE_CONTRACT = "delete from contract where id=?";

    /* Columns */
    public final static String ID = "id";
    public final static String LOGIN = "login";
    public final static String PASSWORD = "password";
    public final static String FULLNAME = "fullname";
    public final static String STATUS = "status";
    public final static String CONTENT = "content";
    public final static String NAME = "name";

    public final static String DECLID = "declaration_id";
    public final static String PROGRAMNAME = "programmname";
    public final static String DATE = "date";
    public final static String CLIENTNAME = "clientName";
    public final static String CONTACT = "contact";
    public final static String ADDRESS = "address";
}
