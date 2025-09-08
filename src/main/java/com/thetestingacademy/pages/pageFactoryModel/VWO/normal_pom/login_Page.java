package com.thetestingacademy.pages.pageFactoryModel.VWO.normal_pom;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_Page {
    //PAGE CLASS

    WebDriver driver;

    //set constructor
    public login_Page(WebDriver driver) {
        this.driver = driver;
    }

    //step 1-page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //action

    public String loginToVWOLoginInvalidCreds(String user, String Password) {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(signButton).click();

        //WaitHelpers.waitJVM(5000);
        WaitHelpers.checkVisibility(driver, error_message, 3);
        String error_messagetext = driver.findElement(error_message).getText();
        return error_messagetext;
    }

    public void loginToVWOLoginValidCreds(String user, String Password) {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(signButton).click();
        WaitHelpers.waitJVM(5000);
    }
}