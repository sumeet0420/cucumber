import com.triscent.pages.HeaderLinksSupport;
import com.triscent.pages.LoginPage;
import com.triscent.pages.WebShopHome;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.utilities.DriverSetup.closeBrowser;
import static com.triscent.utilities.LogUtility.log;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginStepDefition {

    WebDriver driver = BaseTest.driver;
    LoginPage loginPage = BaseTest.loginPage;
    public static final String username = BaseTest.username;
    public static final String password = BaseTest.password;

    @Given("^User opens the browser$")
    public void user_opens_the_browser() {
        log.info("User is on homepage");
        System.out.println("User is on homepage");
    }

    @Then("^navigates to the url$")
    public void navigates_to_the_url() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        log.info("User navigates to the URL");
        System.out.println("User navigates to the URL");
    }

    @Given("^user be able to clicks on login button$")
    public void user_be_able_to_clicks_on_login_button() {
        HeaderLinksSupport.clickLogin();
        log.info("User clicks on login button");
        System.out.println("User clicks on login button");
    }

    @Then("^user provides his correct credentials$")
    public void user_provides_his_correct_credentials() {
        loginPage.withUsername(username).andPassword(password).login();
        log.info("User provides his correct credentials");
        System.out.println("User provides his correct credentials");
    }

    @Then("^he is able to successfully log in the website$")
    public void he_is_able_to_successfully_log_in_the_website() {
        assertTrue(verifyUserLoggedIn());
        log.info("User is able to successful log in the website");
        System.out.println("User is able to successful log in the website");
    }

    @Then("^closes the browser$")
    public void closes_the_browser() {
        closeBrowser();
        System.out.println("Close the browser");
    }

    @Then("^user provides his incorrect credentials$")
    public void user_provides_his_incorrect_credentials() {
        loginPage.withUsername("abcdeds@email.com").andPassword("adf").login();
        log.info("User provides his incorrect credentials");
        System.out.println("User provides his incorrect credentials");
    }


    @Then("^he should not be able to log in the website$")
    public void he_should_not_be_able_to_log_in_the_website() throws Throwable {
        assertFalse(verifyUserLoggedIn());
        log.info("User is not able to login");
        System.out.println("User is not able to login");
    }
}
