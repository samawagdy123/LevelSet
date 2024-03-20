import POM.Document;
import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChickGetPaid {
    private WebDriver driver;
    private HomePage homePage;
    private Document doc;

    @BeforeClass
    public void setUp(){
        driver = new EdgeDriver();
        homePage = new HomePage(driver);
        doc = new Document(driver);
    }

    @Test
    public void checkDocPrice(){
        homePage.navigateToHomePage();
        homePage.getPaidClick();
        doc.checkDocPageLoaded();

        Assert.assertEquals(doc.getDocName(), "File a Lien", "Document name does not match");
        Assert.assertEquals(doc.getDocPrice(), "$449", "Document price does not match");
    }

   @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
