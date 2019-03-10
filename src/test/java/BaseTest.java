import com.triscent.pages.*;
import com.triscent.support.ProductSelectorHelperMenu;
import com.triscent.utilities.BrowserHelper;
import com.triscent.utilities.DriverSetup;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/*
 *This is a base test class. It will initialize setups for drivers as well as invoke all the Page Object Class with the help of PageFactory Selenium Class.
 */

public class BaseTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static final String username = UserDetailsPropertiesLoad.getUserName();
    public static final String password = UserDetailsPropertiesLoad.getPassword();

   @Before
    public void setUp() {
        driver = DriverSetup.openChrome();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, WebShopHome.class);
        PageFactory.initElements(driver, MyAccountOptions.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, ProductHome.class);
        PageFactory.initElements(driver, OrderProduct.class);
        PageFactory.initElements(driver, CartPage.class);
        PageFactory.initElements(driver, HeaderLinksSupport.class);
        PageFactory.initElements(driver, ProductSelectorHelperMenu.class);
        PageFactory.initElements(driver, RegisterPage.class);
        PageFactory.initElements(driver, BrowserHelper.class);
        PageFactory.initElements(driver, AddressAddPage.class);
        PageFactory.initElements(driver, AddressHomePage.class);
        PageFactory.initElements(driver, CheckoutPage.class);
        PageFactory.initElements(driver, CreditCardPayment.class);
        PageFactory.initElements(driver, OrderConfirmPage.class);
    }

}