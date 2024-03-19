import POM.Document;
import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChickGetPaid {
    WebDriver driver;
    HomePage homePage;
    Document doc;

    @BeforeClass
    public void setUp(){
        driver= new EdgeDriver();
        homePage=new HomePage(driver);
        doc=new Document(driver);
    }

    @Test
    public void checkDocPrice(){

        homePage.navigateToHome();
        homePage.getPaidClick();
        doc.docPageLoaded();

        /*Assert.assertEquals(doc.getDocName(),"File a Lien","Not the same DOC name");
        Assert.assertEquals(doc.getDocPrice(),"$449","Not the same DOC Price");*/
    }

  /* @AfterClass
    public void shutDown(){
        driver.quit();
    }*/
}
