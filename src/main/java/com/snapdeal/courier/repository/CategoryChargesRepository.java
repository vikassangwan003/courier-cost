package com.snapdeal.courier.repository;

import com.snapdeal.courier.entity.CategoryCharges;
import com.snapdeal.courier.entity.LocationCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryChargesRepository extends CrudRepository<CategoryCharges, Long> {
    CategoryCharges findBySourceCategoryAndDestinationCategory(String srcCategory, String destCategory);
}
