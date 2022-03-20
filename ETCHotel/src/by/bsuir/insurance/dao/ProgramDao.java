package by.bsuir.insurance.dao;

import by.bsuir.insurance.entity.obj.Program;
import by.bsuir.insurance.service.ConnectionProvider;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.bsuir.insurance.helper.DaoHelper.*;

public class ProgramDao extends Dao<Program> {

    private static ProgramDao instance;

    public static ProgramDao getInstance() {
        if (instance == null) {
            synchronized (ProgramDao.class) {
                if (instance == null) {
                    instance = new ProgramDao();
                }
            }
        }
        return instance;
    }

    @Override
    public Program getById(int id) {
        Program program = null;
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM program_table where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                program = parse(rs);
            }
            rs.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return program;
    }

    @Override
    public ArrayList<Program> getAll() {
        ArrayList<Program> programs = new ArrayList<>();
        Connection con = null;
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from program");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                programs.add(parse(rs));
            }
            rs.close();
        } catch (SQLException ex) {
            log.error("", ex.getMessage());
        } finally {
            ConnectionProvider.releaseConnection(con);
        }
        return programs;
    }

    @Override
    public boolean insert(Program obj) {
        return false;
    }

    @Override
    public boolean update(Program obj) {
        return false;
    }

    @Override
    public boolean delete(Program obj) {
        return false;
    }

    @Override
    public boolean isExists(Program obj) {
        return false;
    }

    private Program parse(ResultSet rs) throws SQLException {
        Program program = new Program();
        program.setProgramTypeId(rs.getInt(ID));
        program.setContent(rs.getString(CONTENT));
        program.setName(rs.getString(NAME));
        program.setObjects(rs.getString("objects"));
        return program;
    }
}
