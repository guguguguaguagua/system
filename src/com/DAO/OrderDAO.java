package com.DAO;

import com.bean.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    boolean AddOrder(Order order) throws SQLException;
    boolean DeleteOrder(String OrderNumber) throws SQLException;
    List<Order> SeekUserOrder(String UserNumber) throws SQLException;
}
