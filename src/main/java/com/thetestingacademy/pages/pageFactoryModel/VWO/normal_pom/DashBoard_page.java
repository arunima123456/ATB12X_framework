package com.thetestingacademy.pages.pageFactoryModel.VWO.normal_pom;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard_page
{
    WebDriver driver;

    //set constructor
    public DashBoard_page(WebDriver driver) {
        this.driver = driver;
    }
    private By userNameOnDashboard = By.xpath("//h6");
    // Page Actions
    public String loggedInUserName(){
        WaitHelpers.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard");
        return driver.findElement(userNameOnDashboard).getText();
    }
}
