package com.udemy.java.test.predicate;


import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class DriverTest {

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

                //Blank Rule
                Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;

                System.out.println("Before :: " + elements.size());
                // It is checking the rule, if it is blank, then remove it.
                elements.removeIf(isBlank);
                System.out.println("After  :: " + elements.size());

                // Now we can call all the elements and see actual elements.
                elements.forEach(e-> System.out.println(e.getText()));



        }

        @AfterTest
        public void quitDriver(){
                this.driver.quit();
        }

}


