package com.udemy.java.test.assignments;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HoverableDropDownTest {

    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@org.testng.annotations.Optional("chrome") String browser){
        this.driver= DriverFactory.getDriver(browser);
        this.actions=new Actions(driver);

    }

    @Test (dataProvider = "linkProvider")
    public void dropDownTest(String path){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        String[] split = path.split("=>");
        Arrays.stream(split)
                .map(String::trim)
                .map(s-> By.linkText(s))
                .map(by -> driver.findElement(by))
                .map(webElement -> actions.moveToElement(webElement))
                .forEach(a->a.perform());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    @DataProvider(name = "linkProvider")
    public Object[] testData() {
        return new Object[]{
                "Dropdown => Dropdown Link 2",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2",
        };
    }


    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
