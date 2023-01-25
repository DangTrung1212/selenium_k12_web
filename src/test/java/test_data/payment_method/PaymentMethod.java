package test_data.payment_method;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public enum PaymentMethod {
    COD("COD"),
    MONEY_ORDER("Money Order"),
    CREDIT_CARD("Credit Card"),
    PURCHASE_ORDER("Purchase Order");

    private final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodString() {
        return paymentMethod;
    }
    public static PaymentMethod getRandomPaymentMethod() {
        List<PaymentMethod> paymentMethods= Arrays.asList(PaymentMethod.values());
        return paymentMethods.get(new SecureRandom().nextInt(paymentMethods.size()));
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
