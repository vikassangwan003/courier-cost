package com.snapdeal.courier.dto;

import java.io.Serializable;

public class RateCard implements Serializable {

    private static final long serialVersionUID = -1907526497428314416L;

    private double totalCost;
    private double weightCharges;
    private double paymentHandlingCharges;
    private double itemPrice;
    private double courierCharge;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getWeightCharges() {
        return weightCharges;
    }

    public void setWeightCharges(double weightCharges) {
        this.weightCharges = weightCharges;
    }

    public double getPaymentHandlingCharges() {
        return paymentHandlingCharges;
    }

    public void setPaymentHandlingCharges(double paymentHandlingCharges) {
        this.paymentHandlingCharges = paymentHandlingCharges;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getCourierCharge() {
        return courierCharge;
    }

    public void setCourierCharge(double courierCharge) {
        this.courierCharge = courierCharge;
    }
}
