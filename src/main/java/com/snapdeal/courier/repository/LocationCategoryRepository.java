package com.snapdeal.courier.repository;

import com.snapdeal.courier.entity.LocationCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationCategoryRepository extends CrudRepository<LocationCategory, Long> {
    LocationCategory findByCityNameAndPinCode(String cityName,String pinCode);
}
