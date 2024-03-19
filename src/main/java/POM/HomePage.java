package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    String homeUrl="https://www.levelset.com/";
    WebDriverWait wait;
    By getPaidElement = new By.ByXPath("//a[@class=\"btn btn-info btn-outline mob-dropdown-btn\"]");
    By docElement = new By.ByXPath("//ul[@class=\"d-flex\"]//a");

    public HomePage(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateToHome(){
        driver.get(homeUrl);
        wait.until(ExpectedConditions.elementToBeClickable(getPaidElement));
    }
    public void getPaidClick(){
        driver.findElement(getPaidElement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(docElement));
        driver.findElement(docElement).click();
    }

}
