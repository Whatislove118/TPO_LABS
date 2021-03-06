package com.lab3.costructor;

import com.lab3.pages.Authpage;
import com.lab3.pages.ChooseProjectpage;
import com.lab3.pages.Constructorpage;
import com.lab3.pages.DNSpage;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestDesignButton {

    public static Authpage authpage;
    public static DNSpage dnSpage;
    public static WebDriver chromeDriver;
    public static ChooseProjectpage chooseProjectpage;
    public static Constructorpage constructorpage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(ConfProperties.getProperty("uKit-auth-page"));
        authpage = new Authpage(chromeDriver);
        authpage.getLoginButton().click();
        authpage.authOnExProfile();
        chooseProjectpage = new ChooseProjectpage(chromeDriver);
        chooseProjectpage.getChange().click();
        constructorpage = new Constructorpage(chromeDriver);
    }


    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }



    @Test
    public void testDesignButton(){
        Assert.assertTrue(constructorpage.getDesignButton().isDisplayed());
    }
}
