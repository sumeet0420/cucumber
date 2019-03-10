import com.triscent.pages.PaymentMethod;
import com.triscent.pages.ShippingMethod;
import com.triscent.support.ProductType;
import com.triscent.support.SortBy;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.triscent.pages.CartPage.*;
import static com.triscent.pages.CheckoutPage.*;
import static com.triscent.pages.HeaderLinksSupport.clickShoppingCartButton;
import static com.triscent.pages.OrderConfirmPage.verifySuccessfulMessage;
import static com.triscent.pages.OrderProduct.addToCart;
import static com.triscent.pages.OrderProduct.setQuantity;
import static com.triscent.pages.ProductHome.selectProduct;
import static com.triscent.pages.WebShopHome.selectProductType;
import static com.triscent.support.ProductSelectorHelperMenu.sortBy;
import static com.triscent.utilities.BrowserHelper.wakeUpAfter;
import static org.testng.Assert.assertTrue;


public class ProductStepDefinition {

    WebDriver driver = BaseTest.driver;

    @Then("^he chooses a product category$")
    public void he_chooses_a_product_category(){
        selectProductType(ProductType.APPARELS);
        sortBy(SortBy.priceByAscending);
    }


    @Then("^select a product$")
    public void select_a_product() {
        selectProduct("Casual Golf Belt");
        setQuantity(4);
    }

    @Then("^he clicks on add to cart$")
    public void he_clicks_on_add_to_cart() throws Throwable {
        addToCart();
    }

    @Then("^clicks on Shopping cart button$")
    public void clicks_on_Shopping_cart_button() throws Throwable {
        clickShoppingCartButton();
    }

    @Then("^he accepts the conditions$")
    public void he_accepts_the_conditions() throws Throwable {
        checkTermsAndConditions();
    }

    @Then("^proceeds to checkout$")
    public void proceeds_to_checkout() throws Throwable {
        checkout();
    }

    @Then("^he selects his Billing Address$")
    public void he_selects_his_Billing_Address() throws Throwable {
        selectBillingAddressByIndex(0);
        clickBillingAddressContinueButton();
    }

    @Then("^Shipping Address$")
    public void shipping_Address() throws Throwable {
        clickShippingAddressContinueButton();
    }

    @Then("^Shipping Method as Next Day Air$")
    public void shipping_Method_as_Next_Day_Air() throws Throwable {
        selectShippingMethod(ShippingMethod.ONE_DAY_AIR);
        clickShippingMethodContinueButton();
    }

    @Then("^Payment Method as COD$")
    public void payment_Method_as_COD() throws Throwable {
        selectPaymentMethod(PaymentMethod.COD);
        clickPaymentMethodContinueButton();
    }

    @Then("^Confirms the Payment Information$")
    public void confirms_the_Payment_Information() throws Throwable {
        wakeUpAfter(1000);
        clickPaymentInformationContinueButton();
    }

    @Then("^Confirms the Order$")
    public void confirms_the_Order() throws Throwable {
        clickConfirmOrderContinueButton();
    }

    @When("^Order is placed logout from the site$")
    public void order_is_placed_logout_from_the_site() throws Throwable {
          verifySuccessfulMessage();
    }

    @When("^user applies the discount coupon card \"([^\"]*)\"$")
    public void user_applies_the_discount_coupon_card(String discount_code) {
        applyDiscountCode(discount_code);
    }

    @When("^discount coupon card is successfully verified$")
    public void discount_coupon_card_is_successfully_verified() throws Throwable {
        assertTrue(verifyDiscountCode());
    }

}
