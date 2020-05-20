package com.udemy.java.test.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreenPageObject {

    private final WebDriver driver;

    @FindBy(id="coupon")
    private WebElement coupon;

    @FindBy(id="couponbtn")
    private WebElement couponbtn;

    @FindBy(id="cc")
    private WebElement CC;

    @FindBy(id="year")
    private WebElement Year;

    @FindBy(id="cvv")
    private WebElement Cvv;

    @FindBy(id="buy")
    private WebElement buy;

    @FindBy(id="status")
    private WebElement status;

    public PaymentScreenPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void applyPromoCode(String promoCode){
        this.coupon.sendKeys(promoCode);
        this.couponbtn.click();
    }

    public void enterCC(String cc, String year, String cvv){
        this.CC.sendKeys(cc);
        this.Year.sendKeys(year);
        this.Cvv.sendKeys(cvv);
    }

    public void buyProduct(){
        this.buy.click();
    }

    public String getStatus(){
        return this.status.getText().trim();
    }
}
