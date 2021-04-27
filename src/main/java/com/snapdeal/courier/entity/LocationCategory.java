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
@Table(name = "LOCATION_CATEGORY")
public class LocationCategory {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "PIN_CODE")
    private String pinCode;

    @Column(name = "CATEGORY")
    private String category;

    public String getCityName() {
        return cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getCategory() {
        return category;
    }
}
