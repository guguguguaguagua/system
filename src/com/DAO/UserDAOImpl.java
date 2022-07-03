package com.DAO;

import com.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public User Login(String UserNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from user where UserNumber=?";
        User user = new User();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,UserNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserNumber(resultSet.getString(1));
                user.setUserPassword(resultSet.getString(2));
                user.setUserName(resultSet.getString(3));
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public boolean Register(User user) throws SQLException {
        DAO dao = new DAO();
        String sql = "insert into user values(?,?,?)";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getUserNumber());
            preparedStatement.setString(2,user.getUserPassword());
            preparedStatement.setString(3,user.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean Change(User user) throws SQLException {
        DAO dao = new DAO();
        String sql = "update user set UserPassword=?,UserName=? where UserNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getUserPassword());
            preparedStatement.setString(2,user.getUserName());
            preparedStatement.setString(3,user.getUserNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean Delete(String UserNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "delete from user where UserNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,UserNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<User> SeekAll() throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from user";
        List<User> userList = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserNumber(resultSet.getString(1));
                user.setUserPassword(resultSet.getString(2));
                user.setUserName(resultSet.getString(3));
                userList.add(user);
            }
        } catch (SQLException e) {
            return null;
        }
        return userList;
    }
}
