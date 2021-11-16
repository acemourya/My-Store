package com.webstore.ui.pages;

import com.webstore.ui.maps.CommonMap;
import com.webstore.ui.utils.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CommonPage {

    CommonMap commonMap = new CommonMap();
    DressesPage dressesPage = new DressesPage();
    TShirtsPage tShirtsPage = new TShirtsPage();
    public static WebDriver driver;
    public static Logger log = Logger.getLogger(LoginPage.class);

    public void productOrder() {
        dressesPage.addDressIntoCart();
        tShirtsPage.addTShirtIntoCart();
        summary();
        address();
        shipping();
        payment();
    }

    public void summary() {
        try {
            driver = TShirtsPage.driver;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");
            driver.findElement(commonMap.proceedToCheckoutButtonOnSummaryTab()).click();
        } catch (Exception e) {
            String error = "Order failed. Due to " + e;
            log.info(error);
        }
    }

    public void address() {
        try {
            driver = TShirtsPage.driver;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");
            driver.findElement(commonMap.proceedToCheckoutButtonOnAddressTab()).click();
        } catch (Exception e) {
            String error = "Order failed. Due to invalid address data or " + e;
            log.info(error);
        }
    }

    public void shipping() {
        try {
            driver = TShirtsPage.driver;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)", "");
            driver.findElement(commonMap.termOfServiceCheckBoxOnShippingTab()).click();
            driver.findElement(commonMap.proceedToCheckoutButtonOnShippingTab()).click();
        } catch (Exception e) {
            String error = "Order failed. Due to invalid to proceed shipping or " + e;
            log.info(error);
        }
    }

    public void payment() {
        try {
            driver = TShirtsPage.driver;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
            driver.findElement(commonMap.paymentProceedThroughPayByBankWire()).click();
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0,300)", "");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(commonMap.confirmOrderButtonOnPaymentTab()).click();
        } catch (Exception e) {
            String error = "Order failed. Due to payment failed or " + e;
            log.info(error);
        }
        Assert.assertEquals(driver.findElement(commonMap.confirmationOrderHeading()).getText(), Constant.CONFIRMATIONORDERHEADING);
        Assert.assertEquals(driver.findElement(commonMap.confirmedOrder()).getText(), Constant.CONFIRMEDORDER);
        driver.quit();
    }
}
