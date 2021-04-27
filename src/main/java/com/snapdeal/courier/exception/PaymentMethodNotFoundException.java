package com.snapdeal.courier.exception;

public class PaymentMethodNotFoundException extends Exception{

    private static final long serialVersionUID = -1419276799480192537L;

    public PaymentMethodNotFoundException(String message) {
        super(message);
    }
}
