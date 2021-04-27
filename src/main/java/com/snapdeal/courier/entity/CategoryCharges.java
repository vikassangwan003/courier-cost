package com.snapdeal.courier.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *   TIER1-CITY to TIER-2CITY  CHARGE
 *   TIER3-CITY to TIER1-CITY  CHARGE
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "CATEGORY_CHARGES")
public class CategoryCharges {
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "SOURCE_CATEGORY")
    private String sourceCategory;

    @Column(name = "DESTINATION_CATEGORY")
    private String destinationCategory;

    @Column(name = "PERCENTAGE_CHARGES")
    private Double percentageCharges;

    public String getSourceCategory() {
        return sourceCategory;
    }

    public String getDestinationCategory() {
        return destinationCategory;
    }

    public Double getPercentageCharges() {
        return percentageCharges;
    }
}
