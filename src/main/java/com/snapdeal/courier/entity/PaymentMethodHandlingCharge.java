package com.snapdeal.courier.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Entity
@NoArgsConstructor
@Table(name = "PYMNT_METHOD_HANDLING_CHARGES")
public class PaymentMethodHandlingCharge {
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "HANDLING_CHARGE")
    private Double handlingCharge;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Double getHandlingCharge() {
        return handlingCharge;
    }
}
