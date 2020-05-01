package com.udemy.java.test.predicate;

import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class Assignment_predicate {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver= DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest(){
        this.driver.get("https://google.com/");
        //this.driver.findElements(By.tagName("a")).forEach(e-> System.out.println(e.getText()));
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));

        System.out.println("Before :: " + elements.size());
/*
        //Blank Rule
        Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;

        Predicate<WebElement> isContainingLetter_s = (e) -> e.getText().contains("s");
        Predicate<WebElement> isContainingLetter_S = (e) -> e.getText().contains("S");

        Predicate<WebElement> hasS = (e) -> e.getText().toLowerCase().contains("s");
        System.out.println("Before :: " + elements.size());

        // It is checking the rule, if it is blank, then remove it.
        elements.removeIf(isBlank.or(hasS));
*/

        // Without Method Reference
        //Rules.get().forEach(rule -> elements.removeIf(rule));

        // Method Reference
        Rules.get().forEach(elements::removeIf);

        System.out.println("After  :: " + elements.size());

        // Now we can call all the elements and see actual elements.
        elements.forEach(e-> System.out.println(e.getText()));



    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
