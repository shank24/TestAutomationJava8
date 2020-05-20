package com.udemy.java.test.assignments;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import static com.udemy.java.test.assignments.PaymentScreenActions.*;

public class PaymentScreenTest {

    private WebDriver driver;
    private PaymentScreenPageObject paymentScreenPageObject;



    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver= DriverFactory.getDriver(browser);
        this.paymentScreenPageObject = new PaymentScreenPageObject(driver);
    }

    @Test(dataProvider = "criteria")
    public void paymentScreenTest(Consumer<PaymentScreenPageObject> consumer){
        paymentScreenPageObject.goTo();
        consumer.accept(paymentScreenPageObject);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    @DataProvider(name = "criteria")
    public Object[] testData(){
        return new Object[]{
                validCC.andThen(buyNow).andThen(successFullPurchase),
                freeCoupon.andThen(buyNow).andThen(successFullPurchase),
                discountedCoupon.andThen(validCC).andThen(buyNow).andThen(successFullPurchase),
                invalidCC.andThen(buyNow).andThen(failedPurchase),
                invalidCC.andThen(discountedCoupon).andThen(buyNow).andThen(failedPurchase),
                buyNow.andThen(failedPurchase)


        };
    }
    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
