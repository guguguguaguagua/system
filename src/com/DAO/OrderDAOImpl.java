package com.DAO;

import com.bean.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO{
    @Override
    public boolean AddOrder(Order order) throws SQLException {
        DAO dao = new DAO();
        String sql = "insert into hotel.`order` values(?,?,?)";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, order.getOrderNumber());
            preparedStatement.setString(2, order.getUserNumber_temp());
            preparedStatement.setString(3, order.getTrainNumber_temp());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean DeleteOrder(String OrderNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "delete  from hotel.`order` where OrderNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,OrderNumber);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            return false;
        } return true;
    }

    @Override
    public List<Order> SeekUserOrder(String UserNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from hotel.train LEFT JOIN hotel.`order` ON  hotel.`order`.TrainNumber_temp = hotel.train.TrainNumber WHERE hotel.`order`.UserNumber_temp=?";
        List<Order> orderList = new ArrayList<Order>();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,UserNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();

                order.setStartStation(resultSet.getString(1));
                order.setEndStation(resultSet.getString(2));
                order.setTrainNumber(resultSet.getString(3));
                order.setTrainType(resultSet.getString(4));
                order.setDriveTime(resultSet.getString(5));
                order.setTicketPrice(resultSet.getString(6));
                order.setTrainSitType(resultSet.getString(7));
                order.setDateValue(resultSet.getString(8));
                order.setOrderNumber(resultSet.getString(9));
                order.setUserNumber_temp(resultSet.getString(10));
                order.setTrainNumber_temp(resultSet.getString(11));
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            return null;
        }
    }
}
