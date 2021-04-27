package com.snapdeal.courier.service;

import com.snapdeal.courier.dto.RateCard;
import com.snapdeal.courier.entity.CategoryCharges;
import com.snapdeal.courier.entity.LocationCategory;
import com.snapdeal.courier.entity.PaymentMethodHandlingCharge;
import com.snapdeal.courier.entity.WeightCharges;
import com.snapdeal.courier.exception.PaymentMethodNotFoundException;
import com.snapdeal.courier.exception.WeightSlabNotFoundException;
import com.snapdeal.courier.repository.CategoryChargesRepository;
import com.snapdeal.courier.repository.LocationCategoryRepository;
import com.snapdeal.courier.repository.PaymentMethodHandlingChargeRepository;
import com.snapdeal.courier.repository.WeightChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierService {
    private CategoryChargesRepository categoryChargesRepository;
    private LocationCategoryRepository locationCategoryRepository;
    private PaymentMethodHandlingChargeRepository paymentMethodHandlingChargeRepository;
    private WeightChargesRepository weightChargesRepository;

    @Autowired
    public CourierService(CategoryChargesRepository categoryChargesRepository,
                          LocationCategoryRepository locationCategoryRepository,
                          PaymentMethodHandlingChargeRepository paymentMethodHandlingChargeRepository,
                          WeightChargesRepository weightChargesRepository) {
        this.categoryChargesRepository = categoryChargesRepository;
        this.locationCategoryRepository = locationCategoryRepository;
        this.paymentMethodHandlingChargeRepository = paymentMethodHandlingChargeRepository;
        this.weightChargesRepository = weightChargesRepository;
    }

    public RateCard getRateCard(String srcPinCode, String srcCity,
                                String destPinCode, String destCity, String weight,
                                String paymentMethod, String itemPrice) throws WeightSlabNotFoundException, PaymentMethodNotFoundException {
        RateCard rateCard = new RateCard();
        rateCard.setItemPrice(Double.parseDouble(itemPrice));

        Double weightCharge = getWeightCharge(weight);
        rateCard.setWeightCharges(weightCharge);

        Double paymentMethodCharge = getPaymentMethodCharge(paymentMethod);
        rateCard.setPaymentHandlingCharges(paymentMethodCharge);

        Double courierCharges = getChargeBasedOnSourceAndDestination(srcCity, srcPinCode, destCity, destPinCode);
        rateCard.setCourierCharge(courierCharges);

        Double totalCost = weightCharge + paymentMethodCharge + courierCharges + Double.parseDouble(itemPrice);
        rateCard.setTotalCost(totalCost);

        return rateCard;
    }

    private Double getWeightCharge(String weightSlab) throws PaymentMethodNotFoundException, WeightSlabNotFoundException {
        WeightCharges weightCharges = weightChargesRepository.findByWeightSlab(weightSlab);
        if (weightCharges == null) throw new WeightSlabNotFoundException("No Weight Slab Found");
        return weightCharges.getCharge();
    }

    private Double getPaymentMethodCharge(String paymentMethod) throws PaymentMethodNotFoundException {
        PaymentMethodHandlingCharge paymentMethodHandlingCharge = paymentMethodHandlingChargeRepository.findByPaymentMethod(paymentMethod);
        if (paymentMethodHandlingCharge == null) throw new PaymentMethodNotFoundException("No Payment Method Found");
        return paymentMethodHandlingCharge.getHandlingCharge();
    }

    private Double getChargeBasedOnSourceAndDestination(String srcCityName, String srcPinCode,
                                                        String destCityName, String destPinCode) {
        LocationCategory srcLocation = getLocationCategory(srcCityName, srcPinCode);
        LocationCategory destLocation = getLocationCategory(destCityName, destPinCode);
        CategoryCharges categoryCharges =
                categoryChargesRepository.findBySourceCategoryAndDestinationCategory(srcLocation.getCategory(), destLocation.getCategory());
        return categoryCharges.getPercentageCharges();
    }

    private LocationCategory getLocationCategory(String cityName, String pinCode) {
        return locationCategoryRepository.findByCityNameAndPinCode(cityName, pinCode);
    }

}
