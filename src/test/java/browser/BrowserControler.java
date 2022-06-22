package browser;

import org.example.pages.GoogleMail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BrowserControler {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public GoogleMail getGoogleMail(){
        return new GoogleMail(getDriver());
    }

}
