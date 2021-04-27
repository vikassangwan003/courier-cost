package com.snapdeal.courier.repository;

import com.snapdeal.courier.entity.WeightCharges;
import org.springframework.data.repository.CrudRepository;

public interface WeightChargesRepository extends CrudRepository<WeightCharges,Long> {
    WeightCharges findByWeightSlab(String weightSlab);
}
