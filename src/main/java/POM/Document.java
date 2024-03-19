package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Document {
    WebDriver driver;
    //HomePage homePage;
    WebDriverWait wait;
    By docNameExampleElement = new By.ByXPath("//div[@class=\"left\" and contains(text(), \"File a Lien\")]");
    WebElement docName=driver.findElement(docNameExampleElement);
    By docPriceExampleElement = new By.ByXPath("//span[@class=\"price-amount\" and contains(text(), \"449\")]");
    WebElement docPrice=driver.findElement(docPriceExampleElement);

    public Document(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //homePage=new HomePage(driver);
    }
    public String getDocName(){
        return docName.getText();
    }
    public String getDocPrice(){
        return docPrice.getText();
    }
    public void navigateToDocPage(){
        driver.navigate().refresh ();
        wait.until(ExpectedConditions.visibilityOfElementLocated(docNameExampleElement));
    }

    public void docPageLoaded(){
        //homePage.getPaidClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(docNameExampleElement));

        if(!docName.isDisplayed()) {
            navigateToDocPage();
        }
    }
}
