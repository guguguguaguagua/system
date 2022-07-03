package com.DAO;

import com.bean.Station;

import java.sql.SQLException;
import java.util.List;

public interface StationDAO {
    List<Station> seekAllStation() throws SQLException;
    boolean AddStation(Station station) throws SQLException;
    boolean ChangeStation(Station station) throws SQLException;
    boolean DeleteStation(String StationNumber) throws SQLException;
}
