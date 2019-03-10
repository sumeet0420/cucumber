import cucumber.api.java.en.Then;

import static com.triscent.pages.RegisterPage.*;

public class RegisterMultipleUsersStepDefinition {

    @Then("^Register the user with the following details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void register_the_user_with_the_following_details(String gender, String firstName, String lastName,
                                                             String emailId, String password, String repassword) {
        selectGender(gender);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(emailId);
        enterPassword(password);
        enterConfirmPassword(repassword);
        clickRegisterButton();
    }

}
