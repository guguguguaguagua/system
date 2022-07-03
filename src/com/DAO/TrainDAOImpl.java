package com.DAO;

import com.bean.Train;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainDAOImpl implements TrainDAO{
    @Override
    public boolean AddTrain(Train train) throws SQLException {
        DAO dao = new DAO();
        String sql = "insert into train values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,train.getStartStation());
            preparedStatement.setString(2, train.getEndStation());
            preparedStatement.setString(3,train.getTrainNumber());
            preparedStatement.setString(4,train.getTrainType());
            preparedStatement.setString(5,train.getDriveTime());
            preparedStatement.setString(6,train.getTicketPrice());
            preparedStatement.setString(7,train.getTrainSitType());
            preparedStatement.setString(8,train.getDateValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean DeleteTrain(String TrainNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "delete from train where TrainNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,TrainNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean ChangeTrain(Train train) throws SQLException {
        DAO dao = new DAO();
        String sql = "update train set StartStation=?,EndStation=?,TrainType=?,DriveTime=?,TicketPrice=?,TrainSitType=?,DateValue=? where TrainNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, train.getStartStation());
            preparedStatement.setString(2,train.getEndStation());
            preparedStatement.setString(3,train.getTrainType());
            preparedStatement.setString(4,train.getDriveTime());
            preparedStatement.setString(5,train.getTicketPrice());
            preparedStatement.setString(6,train.getTrainSitType());
            preparedStatement.setString(7, train.getDateValue());
            preparedStatement.setString(8,train.getTrainNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Train> SeekTrain(String StartStation, String EndStation) throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from train where StartStation=? and EndStation=?";
        List<Train> trainList = new ArrayList<Train>();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,StartStation);
            preparedStatement.setString(2,EndStation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Train train = new Train();
                train.setStartStation(resultSet.getString(1));
                train.setEndStation(resultSet.getString(2));
                train.setTrainNumber(resultSet.getString(3));
                train.setTrainType(resultSet.getString(4));
                train.setDriveTime(resultSet.getString(5));
                train.setTicketPrice(resultSet.getString(6));
                train.setTrainSitType(resultSet.getString(7));
                train.setDateValue(resultSet.getString(8));
                trainList.add(train);
            }
        } catch (SQLException e) {
            return null;
        }
        return trainList;
    }

    @Override
    public List<Train> AllTrain() throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from train";
        List<Train> trainList = new ArrayList<Train>();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Train train = new Train();
                train.setStartStation(resultSet.getString(1));
                train.setEndStation(resultSet.getString(2));
                train.setTrainNumber(resultSet.getString(3));
                train.setTrainType(resultSet.getString(4));
                train.setDriveTime(resultSet.getString(5));
                train.setTicketPrice(resultSet.getString(6));
                train.setTrainSitType(resultSet.getString(7));
                train.setDateValue(resultSet.getString(8));
                trainList.add(train);
            }
        } catch (Exception e) {
            return null;
        }
        return trainList;
    }
}
