package com.udemy.java.test.stream.automation;


import com.udemy.java.test.supplier.DriverFactory;
import com.udemy.java.test.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

        private WebDriver driver;

        @BeforeTest
        @Parameters("browser")
        public void setDriver(@Optional("chrome") String browser){
                this.driver= DriverFactory.getDriver(browser);
        }


        /*@Test
        public void linkTest(){
                this.driver.get("https://the-internet.herokuapp.com/broken_images");
                //Getting all the elements which is having SRC attribute
                boolean result = this.driver.findElements(By.xpath("//*[@src]"))
                                                .stream()
                                                .map(e -> e.getAttribute("src"))
                                                .map(src -> LinkUtil.getResponseCode(src))
                                                // Do we have any R_Code, which is not 200, means this is broken
                                                .anyMatch(rc -> rc!=200);

                Assert.assertFalse(result);
        }*/


        // Using Collect()

        @Test
        public void linkTest(){
                this.driver.get("https://the-internet.herokuapp.com/broken_images");
                //Getting all the elements which is having SRC attribute
                List<String> list = this.driver.findElements(By.xpath("//*[@src]"))
                        .stream()
                        .map(e -> e.getAttribute("src"))
                        .filter(src -> LinkUtil.getResponseCode(src) != 200)
                        .collect(Collectors.toList());

                Assert.assertEquals(list.size(),0,list.toString());



        }


/*
        @Test
        public void linkTestHref(){
                this.driver.get("https://the-internet.herokuapp.com/broken_images");
                //Getting all the elements which is having SRC attribute
                this.driver.findElements(By.xpath("//*[@href]"))
                        .stream()
                        .map(e -> e.getAttribute("href"))
                        .forEach(src -> {
                                System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                        });
        }*/

        /*//Improved Code
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
        }*/


        @AfterTest
        public void quitDriver(){
                this.driver.quit();
        }

}


