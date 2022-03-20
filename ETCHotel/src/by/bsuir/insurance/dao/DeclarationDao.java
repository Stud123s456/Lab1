package by.bsuir.insurance.dao;

import by.bsuir.insurance.entity.obj.Declaration;
import by.bsuir.insurance.service.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static by.bsuir.insurance.helper.DaoHelper.*;

public class DeclarationDao extends Dao<Declaration> {

    private static DeclarationDao instance;

    public static DeclarationDao getInstance() {
        if (instance == null) {
            synchronized (DeclarationDao.class) {
                if (instance == null) {
                    instance = new DeclarationDao();
                }
            }
        }
        return instance;
    }

    @Override
    public Declaration getById(int id) {
        return null;
    }

    @Override
    public ArrayList<Declaration> getAll() {
        return null;
    }

    @Override
    public boolean insert(Declaration obj) {
        Connection con = null;
        PreparedStatement stmt = null;
        int nextId = 0;
        try {
            con = ConnectionProvider.getConnection();
            stmt = con.prepareStatement(NEXTID_DECLARATION);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nextId = rs.getInt(ID);
                nextId++;
            }
            rs.close();

            con = ConnectionProvider.getConnection();
            stmt = con.prepareStatement(INSERT_DECLARATION);
            stmt.setInt(1, nextId);
            stmt.setString(2, obj.getFullName());
            stmt.setString(3, obj.getContact());
            stmt.setString(4, obj.getAddress());
            stmt.setInt(5, obj.getInsuranceOptionId());
            stmt.setInt(6, obj.getPeriodId());
            stmt.setInt(7, obj.getContractTimeId());
            stmt.setInt(8, obj.getCurrencyId());
            stmt.setDouble(9, obj.getSumInsured());
            stmt.setString(10, obj.getDate());
            stmt.setInt(11, obj.getClientId());
            stmt.setInt(12, obj.getEmployeeId());
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
    public boolean update(Declaration obj) {
        return false;
    }

    @Override
    public boolean delete(Declaration obj) {
        return false;
    }

    @Override
    public boolean isExists(Declaration obj) {
        return false;
    }
}
