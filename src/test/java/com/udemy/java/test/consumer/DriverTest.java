package com.udemy.java.test.consumer;


import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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
                // Consumer Implementation
                this.driver.findElements(By.tagName("a")).forEach(e-> System.out.println(e.getText()));
        }

        @AfterTest
        public void quitDriver(){
                this.driver.quit();
        }

}


