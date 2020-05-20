package com.udemy.java.test.assignments;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PriceTableTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver= DriverFactory.getDriver(browser);
    }

    @Test
    public void minPriceTest(){
        TestMain_Ass_3 ob = new TestMain_Ass_3(driver);
        ob.selectMinPriceOrder();
        String status = ob.getStatus();

        Assert.assertEquals("PASS",status);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
