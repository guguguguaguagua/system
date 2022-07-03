package com.DAO;

public class DAOFactory {

    public static UserDAO getUserDAOImpl() { return new UserDAOImpl(); }

    public static TrainDAO getTrainDAOImpl() {
        return new TrainDAOImpl();
    }

    public static OrderDAO getOrderDAOImpl() { return new OrderDAOImpl(); }

    public static StationDAO getStationDAOImpl() { return new StationDAOImpl(); }

    public static AdminDAO getAdminDAOImpl() { return new AdminDAOImpl(); }
}
