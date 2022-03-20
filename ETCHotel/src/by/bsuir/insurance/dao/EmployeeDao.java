package by.bsuir.insurance.dao;

import by.bsuir.insurance.entity.obj.Employee;
import by.bsuir.insurance.service.ConnectionProvider;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.bsuir.insurance.helper.DaoHelper.*;

@NoArgsConstructor
public class EmployeeDao extends Dao<Employee> {

    private static EmployeeDao instance;

    public static EmployeeDao getInstance() {
        if (instance == null) {
            synchronized (EmployeeDao.class) {
                if (instance == null) {
                    instance = new EmployeeDao();
                }
            }
        }
        return instance;
    }

    public Employee getByLogin(String login) {
        Employee employee = null;
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_USER_BY_LOGIN);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employee = parse(rs);
            }
            rs.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return employee;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public ArrayList<Employee> getAll() {
        return null;
    }

    @Override
    public boolean insert(Employee obj) {
        return false;
    }

    @Override
    public boolean update(Employee obj) {
        return false;
    }

    @Override
    public boolean delete(Employee obj) {
        return false;
    }

    @Override
    public boolean isExists(Employee obj) {
        return false;
    }

    private Employee parse(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt(ID));
        employee.setLogin(rs.getString(LOGIN));
        employee.setPassword(rs.getString(PASSWORD));
        employee.setFullname(rs.getString(FULLNAME));
        employee.setStatus(rs.getString(STATUS));
        return employee;
    }
}
