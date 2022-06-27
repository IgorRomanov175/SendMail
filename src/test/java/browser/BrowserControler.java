package browser;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.GoogleMail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BrowserControler {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public GoogleMail getGoogleMail(){
        return new GoogleMail(getDriver());
    }

}
