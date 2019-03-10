import com.triscent.support.ProductType;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

import static com.triscent.pages.WebShopHome.selectProductType;
import static org.testng.AssertJUnit.assertEquals;

public class ProductCategoriesStepDefinition {

    WebDriver driver = BaseTest.driver;
    @Given("^User click on a product \"([^\"]*)\"$")
    public void user_click_on_a_product(String productName) {
        selectProductType(productName);
    }

    @And("Verify URL is \"([^\"]*)\"$")
    public void verify_url(String URL){
        assertEquals(URL,driver.getCurrentUrl());
    }

}