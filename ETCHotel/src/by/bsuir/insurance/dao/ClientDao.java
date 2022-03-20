package by.bsuir.insurance.dao;

import by.bsuir.insurance.entity.obj.Client;
import by.bsuir.insurance.service.ConnectionProvider;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static by.bsuir.insurance.helper.DaoHelper.*;

@NoArgsConstructor
public class ClientDao extends Dao<Client> {

    private static ClientDao instance;

    public static ClientDao getInstance() {
        if (instance == null) {
            synchronized (ClientDao.class) {
                if (instance == null) {
                    instance = new ClientDao();
                }
            }
        }
        return instance;
    }

    public Client getByName(String name) {
        Client client = null;
        Connection con = null;
        String sql = "SELECT * FROM client where fullname = '"+name+"'";
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                client = parse(rs);
            }
            rs.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return client;
    }

    @Override
    public Client getById(int id) {
        Client client = null;
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM client where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                client = parse(rs);
            }
            rs.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return client;
    }

    @Override
    public ArrayList<Client> getAll() {
        return null;
    }

    @Override
    public boolean insert(Client obj) {
        return false;
    }

    @Override
    public boolean update(Client obj) {
        return false;
    }

    @Override
    public boolean delete(Client obj) {
        return false;
    }

    @Override
    public boolean isExists(Client obj) {
        return false;
    }

    private Client parse(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt(ID));
        client.setFullname(rs.getString(FULLNAME));
        client.setContact(rs.getString(CONTACT));
        client.setAddress(rs.getString(ADDRESS));
        return client;
    }
}
