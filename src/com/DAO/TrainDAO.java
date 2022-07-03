package com.DAO;

import com.bean.Train;

import java.sql.SQLException;
import java.util.List;

public interface TrainDAO {
    boolean AddTrain(Train train) throws SQLException;
    boolean DeleteTrain(String TrainNumber) throws SQLException;
    boolean ChangeTrain(Train train) throws SQLException;
    List<Train> SeekTrain(String StartStation,String EndStation) throws SQLException;
    List<Train> AllTrain() throws SQLException;
}
