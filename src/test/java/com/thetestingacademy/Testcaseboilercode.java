package com.thetestingacademy;

import junit.framework.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcaseboilercode {
    public ChromeDriver driver;
    @BeforeTest

        public void open_Browser()
        {
            ChromeOptions edge_options=new ChromeOptions();
            edge_options.addArguments("---guest");
            driver=new ChromeDriver(edge_options);
        }
        @Test
    public void test()
        {
            driver.get("https://app.vwo.com");
            Assert.assertEquals(driver.getTitle(),"Login - VWO" +
                    "Actual   :login VWO");

        }
        @AfterTest
    public void close_browser()
        {
            driver.quit();
        }
    }

