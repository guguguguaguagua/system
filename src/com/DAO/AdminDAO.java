package com.DAO;

import com.bean.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    Admin AdminLogin(String AdminNumber) throws SQLException;
    boolean ChangeAdmin(Admin admin) throws SQLException;
}
