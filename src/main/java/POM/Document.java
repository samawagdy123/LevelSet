package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Document {
    WebDriver driver;
    WebDriverWait wait;
    By docNameExampleElement = new By.ByXPath("//div[@class='left' and contains(text(), 'File a Lien')]");
    By docPriceExampleElement = new By.ByXPath("//span[@class='price-amount' and contains(text(), '449')]");

    public Document(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getDocName(){
        WebElement docName=driver.findElement(docNameExampleElement);
        return docName.getText();
    }

    public String getDocPrice(){
        WebElement docPrice=driver.findElement(docPriceExampleElement);
        return docPrice.getText();
    }

    public void navigateToDocPage(){
        driver.navigate().refresh ();
        wait.until(ExpectedConditions.visibilityOfElementLocated(docNameExampleElement));
    }

    public void checkDocPageLoaded(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(docNameExampleElement));
       WebElement docName=driver.findElement(docNameExampleElement);
       if(!docName.isDisplayed()) {
            navigateToDocPage();
       }
    }
}
