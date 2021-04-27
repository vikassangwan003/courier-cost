package com.snapdeal.courier.repository;

import com.snapdeal.courier.entity.PaymentMethodHandlingCharge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodHandlingChargeRepository extends CrudRepository<PaymentMethodHandlingCharge,Long> {
    PaymentMethodHandlingCharge findByPaymentMethod(String paymentMethod);
}
