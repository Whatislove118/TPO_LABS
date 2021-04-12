package com.lab3.siteconfiguration;

import com.lab3.pages.Authpage;
import com.lab3.pages.Templatepage;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestTemplateConfig {
    public static Authpage authpage;
    public static Templatepage template;
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
        authpage.auth();
        template = new Templatepage(chromeDriver);
    }


    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }


    @Test
    public void testChooseTemplate() throws InterruptedException {
        template.getTemplate().click();
        Assert.assertEquals(ConfProperties.getProperty("uKit-domain-page"), chromeDriver.getCurrentUrl());
        Thread.sleep(500000);
    }

}
