package com.DAO;

import com.bean.Station;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDAOImpl implements StationDAO{
    @Override
    public List<Station> seekAllStation() throws SQLException {
        DAO dao = new DAO();
        String sql = "select * from Station";
        List<Station> stationList = new ArrayList<Station>();
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Station station = new Station();
                station.setStationNumber(resultSet.getString(1));
                station.setStationName(resultSet.getString(2));
                stationList.add(station);
            }
        } catch (SQLException e) {
            return null;
        }
        return stationList;
    }

    @Override
    public boolean AddStation(Station station) throws SQLException {
        DAO dao = new DAO();
        String sql = "insert into Station values(?,?)";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,station.getStationNumber());
            preparedStatement.setString(2,station.getStationName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean ChangeStation(Station station) throws SQLException {
        DAO dao = new DAO();
        String sql = "update Station set StationName=? where StationNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, station.getStationName());
            preparedStatement.setString(2, station.getStationNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean DeleteStation(String StationNumber) throws SQLException {
        DAO dao = new DAO();
        String sql = "delete from Station where StationNumber=?";
        try {
            PreparedStatement preparedStatement = dao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,StationNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
