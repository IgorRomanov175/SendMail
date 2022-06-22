package scenario;

import browser.BrowserControler;
import org.example.user.User;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario extends BrowserControler {

    private static final String GOOGLE_MAIL_LOGIN = "https://accounts.google.com/AccountChooser/signinchooser?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser";
    private static final User TEST_USER_1 = new User("testuserforselenium111@gmail.com", "g7B2a8d4", "Hello");
    private static final User TEST_USER_2 = new User("testuserforselenium112@gmail.com", "g7B2a8d4", "Hi");

    @Test
    public void sendMail(){
        getDriver().get(GOOGLE_MAIL_LOGIN);

        getGoogleMail()
                .inputMailAddress(TEST_USER_1.getMail())
                .inputPassword(TEST_USER_1.getPassword())
                .writeMailButtonClick()
                .writeMail(TEST_USER_2.getMail(), TEST_USER_1.getMailText());

        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get(GOOGLE_MAIL_LOGIN);

        getGoogleMail()
                .addAccount()
                .inputMailAddress(TEST_USER_2.getMail())
                .inputPassword(TEST_USER_2.getPassword());

        Assert.assertTrue(getGoogleMail().getIncomingMail().isDisplayed());
    }
}
