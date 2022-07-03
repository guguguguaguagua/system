package com.bean;

public class Order extends Train{
    private String OrderNumber;
    private String UserNumber_temp;
    private String TrainNumber_temp;

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.OrderNumber = orderNumber;
    }

    public String getUserNumber_temp() { return UserNumber_temp; }

    public void setUserNumber_temp(String userNumber_temp) { UserNumber_temp = userNumber_temp; }

    public String getTrainNumber_temp() { return TrainNumber_temp; }

    public void setTrainNumber_temp(String trainNumber_temp) { TrainNumber_temp = trainNumber_temp; }
}
