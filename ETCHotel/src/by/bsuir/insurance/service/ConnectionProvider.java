package by.bsuir.insurance.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
    private final static Logger log = LogManager.getRootLogger();
    private static DataSource dataSource;
    private static final String JDBC_PATH = "java:/comp/env/jdbc/insurance";

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            try {
                InitialContext initialContext = new InitialContext();
                dataSource = (DataSource) initialContext.lookup(JDBC_PATH);
            } catch (NamingException ne) {
                log.error("Error during datasource initialization: ", ne);
            }
        }
        return dataSource.getConnection();
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                log.error("Error during conncetion releasing: ", ex);
            }
        }
    }
}
