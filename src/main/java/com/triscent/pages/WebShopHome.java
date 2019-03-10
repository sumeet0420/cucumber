package com.triscent.pages;

import com.triscent.support.Categories;
import com.triscent.support.ProductType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.triscent.utilities.LogUtility.log;

public class WebShopHome {

    private static WebDriver driver;

    private static final String url = "http://demowebshop.tricentis.com/";
    private static final String TITLE = "Demo Web Shop";

    /*
    Locating all the elements required for Home Page
    */

    private static @FindBy(className = "ico-login")
    WebElement login;
    private static @FindBy(linkText = "Register")
    WebElement register;
    private @FindBy(linkText = "Appareals")
    WebElement apparels;
    private static @FindBy(linkText = "Apparel & Shoes")
    WebElement books;
    private static @FindBy(linkText = "Apparel & Shoes")
    WebElement computers;
    private static @FindBy(linkText = "ELECTRONICS")
    WebElement electronics;
    private static @FindBy(linkText = "Log out")
    WebElement logout;
    private static boolean isUserLoggedIn;

    public static boolean verifyUserLogin() {
        return isUserLoggedIn;
    }

    public WebShopHome(WebDriver driver) {
        this.driver = driver;
    }

    public static void openWebShopHomePage() {
        driver.get(url);
    }

    public static boolean verifyTitle() {
        return TITLE.equals(driver.getTitle());
    }

    /*
     *@Note: This is a helper class provided to select a Product based on String.
     *Whenever possible, kindly use by passing Category types.
     */
    public static void selectProductType(String productCategory) {
        switch (productCategory) {
            case "APPARELS":
                selectProductType(ProductType.APPARELS);
                break;
            case "BOOKS":
                selectProductType(ProductType.BOOKS);
                break;
            case "DIGITALDOWNLOADS":
                selectProductType(ProductType.DIGITAL_DOWNLOADS);
                break;
            case "GIFTCARDS":
                selectProductType(ProductType.GIFT_CARDS);
                break;
            case "JEWELRY":
                selectProductType(ProductType.JEWELRY);
                break;
            case "CAMERA":
                selectProductType(ProductType.ELECTONICS.CAMERA);
                break;
            case "CELLPHONES":
                selectProductType(ProductType.ELECTONICS.CELLPHONES);
                break;
            case "ACCESSORIES":
                selectProductType(ProductType.COMPUTERS.ACCESSORIES);
                break;
            case "NOTEBOOKS":
                selectProductType(ProductType.COMPUTERS.NOTEBOOKS);
                break;
            case "DESKTOPS":
                selectProductType(ProductType.COMPUTERS.DESKTOPS);
                break;
            default:
                try {
                    throw new Exception("Invalid Product Selections.");
                } catch (Exception e) {
                    e.getMessage();
                }
        }
    }

    public static void selectProductType(Categories categories) {

        Actions actions = new Actions(driver);

        if (categories.getCategory().equals(ProductType.APPARELS.getCategory())) {
            driver.findElement(By.linkText(ProductType.APPARELS.category)).click();
        } else if (categories.getCategory().equals(ProductType.BOOKS.getCategory())) {
            driver.findElement(By.linkText(ProductType.BOOKS.category)).click();
        } else if (categories.getCategory().equals(ProductType.DIGITAL_DOWNLOADS.getCategory())) {
            driver.findElement(By.linkText(ProductType.DIGITAL_DOWNLOADS.category)).click();
        } else if (categories.getCategory().equals(ProductType.GIFT_CARDS.getCategory())) {
            driver.findElement(By.linkText(ProductType.GIFT_CARDS.category)).click();
        } else if (categories.getCategory().equals(ProductType.DIGITAL_DOWNLOADS.getCategory())) {
            driver.findElement(By.linkText(ProductType.DIGITAL_DOWNLOADS.category)).click();
        } else if (categories.getCategory().equals(ProductType.JEWELRY.getCategory())) {
            driver.findElement(By.linkText(ProductType.JEWELRY.category)).click();
        } else if (categories.getCategory().equals(ProductType.COMPUTERS.ACCESSORIES.getCategory())) {
            actions.moveToElement(driver.findElement(By.linkText("COMPUTERS")))
                    .build().perform();
            actions.moveToElement(driver.findElement(By.linkText("Accessories"))).click()
                    .build().perform();
        } else if (categories.getCategory().equals(ProductType.COMPUTERS.DESKTOPS.getCategory())) {
            actions.moveToElement(driver.findElement(By.linkText("COMPUTERS")))
                    .build().perform();
            actions.moveToElement(driver.findElement(By.linkText("Desktops"))).click()
                    .build().perform();
        } else if (categories.getCategory().equals(ProductType.COMPUTERS.NOTEBOOKS.getCategory())) {
            actions.moveToElement(driver.findElement(By.linkText("COMPUTERS")))
                    .build().perform();
            actions.moveToElement(driver.findElement(By.linkText("Notebooks"))).click()
                    .build().perform();
        } else if (categories.getCategory().equals(ProductType.ELECTONICS.CAMERA.getCategory())) {
            actions.moveToElement(driver.findElement(By.linkText("ELECTRONICS")))
                    .build().perform();
            actions.moveToElement(driver.findElement(By.linkText("Camera, photo"))).click()
                    .build().perform();
        } else if (categories.getCategory().equals(ProductType.ELECTONICS.CELLPHONES.getCategory())) {
            actions.moveToElement(driver.findElement(By.linkText("ELECTRONICS")))
                    .build().perform();
            actions.moveToElement(driver.findElement(By.linkText("Cell phones"))).click()
                    .build().perform();
        }
        log.info("Product " + categories.getCategory() + " is selected");
    }

    public static void clickLogin() {
        if (logout != null) {
            login.click();
            isUserLoggedIn = true;
        } else {
            try {
                log.error("A user is already logged in");
                throw new Exception("A user is already logged in.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}