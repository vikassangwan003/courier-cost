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
@Table(name = "WEIGHT_CHARGES")
public class WeightCharges {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "WEIGHT_SLAB")
    private String weightSlab;

    @Column(name = "CHARGE")
    private Double charge;

    public String getWeightSlab() {
        return weightSlab;
    }

    public Double getCharge() {
        return charge;
    }
}
