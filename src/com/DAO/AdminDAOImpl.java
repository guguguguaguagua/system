package com.DAO;

import com.bean.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO{
    @Override
    public Admin AdminLogin(String AdminNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from Admin where AdminNumber=?";
        Admin admin = new Admin();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,AdminNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admin.setAdminNumber(resultSet.getString(1));
                admin.setAdminPassword(resultSet.getString(2));
                admin.setAdminName(resultSet.getString(3));
            }
        } catch (SQLException e) {
            return null;
        }
        return admin;
    }

    @Override
    public boolean ChangeAdmin(Admin admin) throws SQLException {
        DAO dao = new DAO();
        String sql = "update Admin set AdminName=?,AdminPassword=? where AdminNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, admin.getAdminName());
            preparedStatement.setString(2, admin.getAdminPassword());
            preparedStatement.setString(3, admin.getAdminNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
