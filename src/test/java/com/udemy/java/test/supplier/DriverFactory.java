package com.udemy.java.test.supplier;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

        private static final Supplier<WebDriver> chromeSupplier= () ->{
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                System.setProperty("webdriver.chrome.driver","/home/shanky/IdeaProjects/TestAutomation/src/test/resources/chrome/chromedriver");
                return new ChromeDriver();
        };

        private static final Supplier<WebDriver> firefoxSupplier= () ->{
                System.setProperty("webdriver.gecko.driver","/home/shanky/IdeaProjects/TestAutomation/src/test/resources/firefox/geckodriver");
                return new FirefoxDriver();
        };

        //Final Constant
        private static final Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

        // Reason for using static block, when class is loaded for the first time,
        // Everything is loaded at once and there will be no change in the logic, its one time.
        static{
                MAP.put("chrome",chromeSupplier);
                MAP.put("firefox",firefoxSupplier);
        }

        // We are going to expose only one method to the outside world
        public static WebDriver getDriver(String browser){
                return MAP.get(browser).get();
        }

}


