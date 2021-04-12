package com.lab3.mainelements;

import com.lab3.pages.Mainpage;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestRedirectToAuthPage {

    public static Mainpage mainpage;
    public static WebDriver chromeDriver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        mainpage = new Mainpage(chromeDriver);
    }



    @After
    public void setOff(){
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
    }

    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }

    @Test
    public void testAuthButtonExist(){
        Assert.assertTrue(Checker.checkIsExist(mainpage.getUkitAuthButton()));
    }

    @Test
    public void testRedirectToAuthPage(){

        mainpage.getUkitAuthButton().click();
        Assert.assertEquals(ConfProperties.getProperty("uKit-auth-page"), chromeDriver.getCurrentUrl());
    }
}
