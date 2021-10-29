package com.webstore.ui.pages;

import com.webstore.ui.maps.CommonMap;
import com.webstore.ui.maps.TShirtsMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TShirtsPage {

    TShirtsMap tShirtsMap = new TShirtsMap();
    CommonMap commonMap = new CommonMap();

    public static WebDriver driver;
    public static Logger log = Logger.getLogger(LoginPage.class);

    public void addTShirtIntoCart() {
        try {
            driver = DressesPage.driver;
            Actions action = new Actions(driver);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.findElement(tShirtsMap.clickOnTShirtsTab()).click();
            js.executeScript("window.scrollBy(0,600)", "");
            action.moveToElement(driver.findElement(commonMap.hoverToProduct())).perform();
            driver.findElement(commonMap.addCartButton()).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(commonMap.proceedToCheckoutButton()).click();
        } catch (Exception e) {
            String error = "Add T-Shirt in Cart failed. Due to " + e;
            log.info(error);
        }
    }
}
