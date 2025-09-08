package com.thetestingacademy.tests.PageObjectModel_Test.VWO;

import com.thetestingacademy.pages.pageFactoryModel.VWO.normal_pom.DashBoard_page;
import com.thetestingacademy.pages.pageFactoryModel.VWO.normal_pom.login_Page;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_VWO_login_normal_01_script_POM
{
    @Test
    public void test_negative_VWO_Login()

    {
        //1)driver manager code
WebDriver driver=new ChromeDriver();

//2)page class code
login_Page loginpage=new login_Page(driver);
     String error_msg=loginpage.loginToVWOLoginInvalidCreds("abc@gmail.com","test7893354353");
//3)assertion varification

     assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
driver.quit();
    }
    @Owner("Arunima")
    @Test
    public void test_positive_VWO_Login()
    {
        WebDriver driver=new ChromeDriver();
        login_Page loginpage=new login_Page(driver);
        loginpage.loginToVWOLoginValidCreds("hebiva4776@amcret.com","Test@4321");
        //after correct username and password dashboard page will load

        DashBoard_page dashBoardPage =new DashBoard_page(driver);
        String userName=dashBoardPage.loggedInUserName();
        assertThat(userName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(userName,"Amcret");
        driver.quit();


    }
}
