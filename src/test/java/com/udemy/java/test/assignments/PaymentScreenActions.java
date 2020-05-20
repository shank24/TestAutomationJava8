package com.udemy.java.test.assignments;

import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentScreenActions {

    public static final Consumer<PaymentScreenPageObject> freeCoupon = (p) -> p.applyPromoCode("FREEUDEMY");

    public static final Consumer<PaymentScreenPageObject> discountedCoupon = (p) -> p.applyPromoCode("PARTIALUDEMY");

    public static final Consumer<PaymentScreenPageObject> validCC = (p) -> p.enterCC("4111111111111111","2023","123");

    public static final Consumer<PaymentScreenPageObject> invalidCC = (p) -> p.enterCC("4211111111111111","2023","123");

    public static final Consumer<PaymentScreenPageObject> buyNow = (p) -> p.buyProduct();

    // Validations

    public static final Consumer<PaymentScreenPageObject> successFullPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");

    public static final Consumer<PaymentScreenPageObject> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");



}
