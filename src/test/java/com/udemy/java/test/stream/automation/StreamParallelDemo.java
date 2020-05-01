package com.udemy.java.test.stream.automation;


import com.udemy.java.test.supplier.DriverFactory;
import com.udemy.java.test.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StreamParallelDemo {

        private WebDriver driver;

        @BeforeTest
        @Parameters("browser")
        public void setDriver(@Optional("chrome") String browser){
                this.driver= DriverFactory.getDriver(browser);
        }


        // Using Collect()

        @Test
        public void linkTest(){
                this.driver.get("https://www.google.com");
                //Getting all the elements which is having SRC attribute

                System.out.println("Before :: " + LocalDateTime.now());
                List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                        .stream()
                        .parallel()
                        .map(e -> e.getAttribute("href"))
                        .filter(src -> LinkUtil.getResponseCode(src) != 200)
                        .collect(Collectors.toList());



                System.out.println("After :: " + LocalDateTime.now());

        }



        @AfterTest
        public void quitDriver(){
                this.driver.quit();
        }

}


