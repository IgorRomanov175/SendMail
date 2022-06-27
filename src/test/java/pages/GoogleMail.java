package pages;


import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class GoogleMail extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement mailInputField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputField;

    @FindBy(css = "div.T-I.T-I-KE.L3")
    private WebElement writeMailButton;

    @FindBy(name = "to")
    private WebElement addressToFieldInput;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement mailTopic;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private WebElement textMailFieldInput;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendMailButton;

    @FindBy(xpath = "//div[@class='BHzsHc']")
    private WebElement addAccountButton;

    @FindBy(xpath = "//div[@class='yW']//span[@name='TestUser ForSelenium']")
    private WebElement incomingMail;

    public GoogleMail(WebDriver driver) {
        super(driver);
    }

    public GoogleMail inputMailAddress(String address){
        mailInputField.sendKeys(address, Keys.ENTER);
        waitForVisibilityOfElement(WAIT_TIME, passwordInputField);
        return this;
    }

    public GoogleMail inputPassword(String address){
        passwordInputField.sendKeys(address, Keys.ENTER);
        waitForVisibilityOfElement(WAIT_TIME, writeMailButton);
        return this;
    }

    public GoogleMail writeMailButtonClick(){
        writeMailButton.click();
        waitForVisibilityOfElement(WAIT_TIME, addressToFieldInput);
        return this;
    }

    public GoogleMail writeMail(String addressTo, String text){
        addressToFieldInput.sendKeys(addressTo);
        mailTopic.sendKeys("1");
        textMailFieldInput.sendKeys(text);
        sendMailButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public GoogleMail addAccount(){
        addAccountButton.click();
        waitForVisibilityOfElement(WAIT_TIME, mailInputField);
        return this;
    }
}
