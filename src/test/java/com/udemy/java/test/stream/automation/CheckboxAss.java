package com.udemy.java.test.stream.automation;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.test.pages.TableDemoPage;
import com.udemy.java.test.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckboxAss {

    private WebDriver driver;
    private TableDemoPage tableDemoPage;



    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver= DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(driver);
    }

    @Test(dataProvider = "criteria")
    public void tableRowTest(Predicate<List<WebElement>> searchCriteria){
        tableDemoPage.goTo();
        tableDemoPage.selectRows(searchCriteria);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }


    @DataProvider(name = "criteria")
    public Object[] testData(){

        return new Object[]{
                SearchCriteriaFactory.getCriteria("allMale"),
                SearchCriteriaFactory.getCriteria("allFemale"),
                SearchCriteriaFactory.getCriteria("allGender"),
                SearchCriteriaFactory.getCriteria("hasUSA"),
                SearchCriteriaFactory.getCriteria("allFemaleUSA")

        };
    }
    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
