package com.DAO;

import com.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User Login(String UserNumber) throws SQLException;
    boolean Register(User user) throws SQLException;
    boolean Change(User user) throws SQLException;
    boolean Delete(String UserNumber) throws SQLException;
    List<User> SeekAll() throws  SQLException;
}
