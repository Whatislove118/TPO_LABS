package com.lab3.authorization;

import com.lab3.pages.Authpage;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestRegistrationDefault {
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
    }


    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }

    @Before
    public void clear(){
        authpage.getEmailInputReg().clear();
        authpage.getPasswordInputReg().clear();
    }


    @Test
    public void testAuthForm_WITHOUT_DATA_REGISTRATION() throws InterruptedException {
        authpage.getSubmitButtonReg().click();
        Assert.assertEquals(ConfProperties.getProperty("uKit-auth-page"), chromeDriver.getCurrentUrl());
    }

    @Test
    public void testAuthForm_INVALID_DATA_REGISTRATION() throws InterruptedException {
        authpage.getEmailInputReg().sendKeys("aaa");
        authpage.getPasswordInputReg().sendKeys("aaa");
        authpage.getSubmitButtonReg().click();
        Assert.assertEquals(ConfProperties.getProperty("uKit-auth-page"), chromeDriver.getCurrentUrl());

    }

    @Test
    public void testAuthForm_VALID_DATA_REGISTRATION() throws InterruptedException{
        authpage.getEmailInputReg().sendKeys(ConfProperties.getProperty("auth_email"));
        authpage.getPasswordInputReg().sendKeys(ConfProperties.getProperty("auth_password"));
        authpage.getSubmitButtonReg().click();
        Assert.assertEquals(ConfProperties.getProperty("uKit-template-page"), chromeDriver.getCurrentUrl());
    }






}
