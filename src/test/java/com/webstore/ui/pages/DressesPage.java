package com.webstore.ui.pages;

import com.webstore.ui.maps.CommonMap;
import com.webstore.ui.maps.DressesMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DressesPage {

    DressesMap dressesMap = new DressesMap();
    CommonMap commonMap = new CommonMap();
    public static WebDriver driver;
    public static Logger log = Logger.getLogger(LoginPage.class);
    
    public void addDressIntoCart() {
        try {
            driver = LoginPage.driver;
            Actions action = new Actions(driver);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.findElement(dressesMap.clickOnDressesTab()).click();
            js.executeScript("window.scrollBy(0,1000)", "");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            action.moveToElement(driver.findElement(commonMap.hoverToProduct())).perform();
            driver.findElement(commonMap.addCartButton()).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(commonMap.proceedToCheckoutButton()).click();
        } catch (Exception e) {
            String error = "Add Dress into Cart failed. Due to " + e;
            log.info(error);
        }
    }
}
