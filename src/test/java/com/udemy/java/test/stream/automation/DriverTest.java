package com.udemy.java.test.stream.automation;


import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class DriverTest {

        private WebDriver driver;

        @BeforeTest
        @Parameters("browser")
        public void setDriver(@Optional("chrome") String browser){
                this.driver= DriverFactory.getDriver(browser);
        }

        // Do not allow blank links
        // Do not allow link containing s
        // convert linkText to uppercase
        // print on the console

        @Test
        public void googleTest(){
                this.driver.get("https://google.com/");
                this.driver.findElements(By.tagName("a"))
                        .stream()
                        .filter(e-> e.getText().trim().length()!=0)
                        .filter(e-> !e.getText().toLowerCase().contains("s"))
                        .map(e-> e.getText().toUpperCase())
                        .forEach(e -> System.out.println(e));
        }

        //Improved Code
        @Test
        public void googleTest1(){
                this.driver.get("https://google.com/");
                this.driver.findElements(By.tagName("a"))
                        .stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .filter(e-> e.length()!=0)
                        .filter(e-> !e.toLowerCase().contains("s"))
                        .map(String::toUpperCase)
                        .forEach(System.out::println);
        }


        @AfterTest
        public void quitDriver(){
                this.driver.quit();
        }

}


