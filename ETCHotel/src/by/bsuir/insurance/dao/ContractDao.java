package by.bsuir.insurance.dao;

import by.bsuir.insurance.entity.Contract;
import by.bsuir.insurance.service.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static by.bsuir.insurance.helper.DaoHelper.*;

public class ContractDao extends Dao<Contract> {

    private static ContractDao instance;

    public static ContractDao getInstance() {
        if (instance == null) {
            synchronized (ContractDao.class) {
                if (instance == null) {
                    instance = new ContractDao();
                }
            }
        }
        return instance;
    }

    public Contract getByClientId(int clientId) {
        return null;
    }

    @Override
    public Contract getById(int id) {
        return null;
    }

    @Override
    public ArrayList<Contract> getAll() {
        ArrayList<Contract> list = new ArrayList<>();
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_CONTRACT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(parse(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return list;
    }

    public ArrayList<Contract> getAllById(int employeeId) {
        ArrayList<Contract> list = new ArrayList<>();
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_CONTRACT_BY_ID);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(parse(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return list;
    }

    @Override
    public boolean insert(Contract obj) {
        Connection con = null;
        PreparedStatement stmt = null;
        int nextId = 0;
        try {
            con = ConnectionProvider.getConnection();
            stmt = con.prepareStatement(NEXTID_CONTRACT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nextId = rs.getInt(ID);
                nextId++;
            }
            rs.close();

            con = ConnectionProvider.getConnection();
            stmt = con.prepareStatement(INSERT_CONTRACT);
            stmt.setInt(1, nextId);
            stmt.setInt(2, obj.getClientId());
            stmt.setInt(3, obj.getProgramTypeId());
            stmt.setInt(4, obj.getCurrencyId());
            stmt.setDouble(5, obj.getSum());
            stmt.setDouble(6, obj.getSumPayment());
            stmt.setString(7, obj.getEndDate());
            stmt.setString(8, obj.getFullName());
            stmt.setString(9, obj.getProgrammName());
            stmt.setString(10, obj.getCurrencyName());
            stmt.setString(11, obj.getObjects());
            stmt.setInt(12, obj.getEmployeeId());
            stmt.setString(13, obj.getPeriodName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return false;
    }

    @Override
    public boolean update(Contract obj) {
        return false;
    }

    @Override
    public boolean delete(Contract obj) {
        return false;
    }

    @Override
    public boolean isExists(Contract obj) {
        return false;
    }

    public void deleteById(int id){
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_CONTRACT);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
    }

    private Contract parse(ResultSet rs) throws SQLException {
        Contract contract = new Contract();
        contract.setId(rs.getInt("id"));
        contract.setClientId(rs.getInt("client_id"));
        contract.setProgramTypeId(rs.getInt("programtype_id"));
        contract.setCurrencyId(rs.getInt("currency_id"));
        contract.setSum(rs.getDouble("sum"));
        contract.setSumPayment(rs.getDouble("sumPayment"));
        contract.setEndDate(rs.getString("end_date"));
        contract.setFullName(rs.getString("full_name"));
        contract.setProgrammName(rs.getString("programmName"));
        contract.setCurrencyName(rs.getString("currencyName"));
        contract.setObjects(rs.getString("objects"));
        contract.setEmployeeId(rs.getInt("employee_id"));
        contract.setPeriodName(rs.getString("periodName"));
        return contract;
    }
}
