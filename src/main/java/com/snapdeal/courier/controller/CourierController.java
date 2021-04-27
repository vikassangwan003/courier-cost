package com.snapdeal.courier.controller;

import com.snapdeal.courier.dto.RateCard;
import com.snapdeal.courier.exception.PaymentMethodNotFoundException;
import com.snapdeal.courier.exception.WeightSlabNotFoundException;
import com.snapdeal.courier.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/snapdeal-courier/")
public class CourierController {

    private CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping("/rate-card")
    public ResponseEntity<RateCard> getRateCard(@RequestParam(value = "srcPinCode") String srcPinCode,
                                                @RequestParam(value = "srcCity") String srcCity,
                                                @RequestParam(value = "destPinCode") String destPinCode,
                                                @RequestParam(value = "destCity") String destCity,
                                                @RequestParam(value = "weight") String weight,
                                                @RequestParam(value = "price") String price,
                                                @RequestParam(value = "paymentMethod") String paymentMethod) {

        RateCard rateCard = null;
        try {
            rateCard = courierService.getRateCard(srcPinCode, srcCity, destPinCode, destCity, weight, paymentMethod, price);
        } catch (Exception exception) {
            new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(rateCard, HttpStatus.OK);
    }
}
