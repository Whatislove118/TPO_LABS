package com.lab3.authorization;

import com.lab3.pages.Authpage;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAuthOuter {

    public static Authpage authpage;
    public static WebDriver chromeDriver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(ConfProperties.getProperty("uKit-auth-page"));
        authpage = new Authpage(chromeDriver);
        authpage.getLoginButton().click();
    }


    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }

    @Test
    public void testAuthOuter_VK(){
        Assert.assertTrue(Checker.checkIsExist(authpage.getVkButton()));


    }

    @Test
    public void testAuthOuter_FACEBOOK(){
        Assert.assertTrue(Checker.checkIsExist(authpage.getFacebookButton()));
    }

    @Test
    public void testAuthOuter_UUID(){
        Assert.assertTrue(Checker.checkIsExist(authpage.getuUIDButton()));
    }

}
