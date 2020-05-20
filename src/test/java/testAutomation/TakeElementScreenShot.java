package testAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeElementScreenShot {

    public static void main(String[] args) throws IOException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.get("https://app.hubspot.com/login");


        WebElement email = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot my password"));

        email.sendKeys("shankkalra@gmail.com");
        password.sendKeys("dasdasdasdasd");

        takeElementScreenshot(email,"email");
        takeElementScreenshot(password,"password");
        takeElementScreenshot(loginButton,"loginButton");
        takeElementScreenshot(forgotPassword,"forgotLink");

        driver.quit();

    }

    public static void takeElementScreenshot(WebElement element,String filename) throws IOException {
        File srcFile = element.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcFile,new File ("./target/screenshot/" + filename +  ".png"));

    }
}
