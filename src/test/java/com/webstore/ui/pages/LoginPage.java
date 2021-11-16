package com.webstore.ui.pages;

import com.webstore.ui.maps.LoginMap;
import config.LaunchApplication;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    LoginMap loginMap = new LoginMap();
    LaunchApplication launchApplication = new LaunchApplication();
    CommonPage commonPage = new CommonPage();

    public static WebDriver driver;
    public static Logger log = Logger.getLogger(LoginPage.class);

    public void login(String email, String password) {
        try {
            driver = LaunchApplication.driver;
            driver.findElement(loginMap.signIn()).click();
            driver.findElement(loginMap.signInEmailField()).sendKeys(email);
            driver.findElement(loginMap.passwordField()).sendKeys(password);
            driver.findElement(loginMap.signInButton()).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            String error = "Warning..! Username :" + email + "[LoginPage.login] thrown exception :" + e;
            log.info(error);
        }
    }

    public void signUp(String fistName, String lastName, String email, String password, String address,
                       String city, String state, String postCode, String mobileNumber, String expected) {
        boolean confirmation = true;
        boolean expectedResult = Boolean.parseBoolean(expected);
        try {
            driver = LaunchApplication.driver;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.findElement(loginMap.signIn()).click();
            driver.findElement(loginMap.signUpEmailField()).sendKeys(email);
            driver.findElement(loginMap.createAnAccountButton()).click();
            driver.findElement(loginMap.genderRadioButton()).click();
            driver.findElement(loginMap.firstNameField()).sendKeys(fistName);
            driver.findElement(loginMap.lastNameField()).sendKeys(lastName);
            driver.findElement(loginMap.passwordField()).sendKeys(password);
            js.executeScript("window.scrollBy(0,1500)", "");
            driver.findElement(loginMap.addressField()).sendKeys(address);
            driver.findElement(loginMap.cityField()).sendKeys(city);
            Select selectState = new Select(driver.findElement(loginMap.selectState()));
            selectState.selectByVisibleText(state);
            driver.findElement(loginMap.postCodeField()).sendKeys(postCode);
            driver.findElement(loginMap.mobilePhoneField()).sendKeys(mobileNumber);
            driver.findElement(loginMap.submitAccountButton()).click();
            commonPage.productOrder();
        } catch (Exception e) {
            confirmation = false;
            String error = "Warning..! User sign up failed. Due to invalid user details thrown exception :" + e;
            log.info(error);
            launchApplication.teardown();
        }
        Assert.assertEquals(confirmation, expectedResult);
    }
}
