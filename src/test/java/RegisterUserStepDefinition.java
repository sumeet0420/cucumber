import com.triscent.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.triscent.pages.HeaderLinksSupport.clickRegister;
import static com.triscent.pages.RegisterPage.*;
import static org.testng.Assert.assertFalse;

public class RegisterUserStepDefinition{

    WebDriver driver = BaseTest.driver;
    @Given("^that the user clicks Register button$")
    public void that_the_user_clicks_Register_button() throws Throwable {
        clickRegister();
        System.out.println("Register button clicked.");
    }

    @Then("^Register the user with the following details$")
    public void register_the_user_with_the_following_details(DataTable table){
        List<List<String>> data = table.raw();
        selectGender(data.get(1).get(1));
        enterFirstName(data.get(2).get(1));
        enterLastName(data.get(3).get(1));
        enterEmail(data.get(4).get(1));
        enterPassword(data.get(5).get(1));
        enterConfirmPassword(data.get(6).get(1));
        clickRegisterButton();
    }

    @Then("^verify if the user should not be registered successfully$")
    public void verify_if_the_user_should_not_be_registered_successfully() throws Throwable {
        assertFalse(RegisterPage.verifyRegister());
    }

}
