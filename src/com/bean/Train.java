package com.bean;

import java.io.Serializable;

public class Train extends Station implements Serializable {
    private String StartStation;
    private String EndStation;
    private String TrainNumber;
    private String TrainType;
    private String DriveTime;
    private String TicketPrice;
    private String TrainSitType;
    private String DateValue;

    public Train() {
        super();
    }

    public String getStartStation() {
        return StartStation;
    }

    public void setStartStation(String startStation) {
        this.StartStation = startStation;
    }

    public String getEndStation() {
        return EndStation;
    }

    public void setEndStation(String endStation) {
        this.EndStation = endStation;
    }

    public String getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.TrainNumber = trainNumber;
    }

    public String getTrainType() {
        return TrainType;
    }

    public void setTrainType(String trainType) {
        this.TrainType = trainType;
    }

    public String getDriveTime() {
        return DriveTime;
    }

    public void setDriveTime(String driveTime) {
        this.DriveTime = driveTime;
    }

    public String getTicketPrice() {
        return TicketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.TicketPrice = ticketPrice;
    }

    public String getTrainSitType() {
        return TrainSitType;
    }

    public void setTrainSitType(String trainSitType) {
        this.TrainSitType = trainSitType;
    }

    public String getDateValue() {
        return DateValue;
    }

    public void setDateValue(String dateValue) {
        this.DateValue = dateValue;
    }
}
