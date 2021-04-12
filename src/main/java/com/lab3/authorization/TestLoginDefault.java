package com.lab3.authorization;

import com.lab3.pages.Authpage;
import com.lab3.utils.ConfProperties;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestLoginDefault {

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

    @Before
    public void clear() throws InterruptedException{
        authpage.getEmailInputLogin().clear();
        authpage.getPasswordInputLogin().clear();

    }



    @Test
    public void testAuthForm_WITHOUT_DATA_AUTHORIZATION(){
        Assert.assertFalse(authpage.getSubmitButtonLogin().isEnabled());
    }

    @Test
    public void testAuthForm_INVALID_DATA_AUTHORIZATION(){
        authpage.getEmailInputLogin().sendKeys("aaa");
        authpage.getPasswordInputLogin().sendKeys("aaa");
        Assert.assertFalse(authpage.getSubmitButtonLogin().isEnabled());
    }

    @Test
    public void testAuthForm_VALID_DATA_AUTHORIZATION(){
        authpage.getEmailInputLogin().sendKeys(ConfProperties.getProperty("auth_email"));
        authpage.getPasswordInputLogin().sendKeys(ConfProperties.getProperty("auth_password"));
        authpage.getSubmitButtonLogin().click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 5); // seconds
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"wizard-main-container\"]/div[2]/div/div[2]/div/div[1]/div[1]/div/div"),"Выбор шаблона"));
        Assert.assertEquals(ConfProperties.getProperty("uKit-template-page"), chromeDriver.getCurrentUrl());
    }
}
