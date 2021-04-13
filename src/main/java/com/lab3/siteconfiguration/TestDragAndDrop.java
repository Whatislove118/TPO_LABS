package com.lab3.siteconfiguration;

import com.lab3.pages.*;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestDragAndDrop {

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
    public void testChoosingDomain() throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        while (true){
            try {
                constructorpage.getImageDnD().getLocation();
                break;
            }catch (Exception e){
                Thread.sleep(2000);
            }
        }
        int x = constructorpage.getImageDnD().getLocation().x;
        int y = constructorpage.getImageDnD().getLocation().y;
        System.out.println(x);
        System.out.println(y);
        int offset = 100;
        Thread.sleep(5000);
        actions.dragAndDropBy(constructorpage.getImageDnD(),offset, offset).build().perform();
        System.out.println(constructorpage.getImageDnD().getLocation().x);
        Assert.assertEquals(
                (x + offset) *
                                (y + offset),

                   constructorpage.getImageDnD().getLocation().x *
                                constructorpage.getImageDnD().getLocation().y);

        Thread.sleep(5000);
    }

}
