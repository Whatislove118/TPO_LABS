package com.lab3.costructor;

import com.lab3.pages.*;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


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
    public void testDragAndDrop() throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        while (true){
            try {
                constructorpage.getImageDnD().getLocation();
                break;
            }catch (Exception e){
                Thread.sleep(2000);
            }
        }
        int y = 0;
        int offset = 0;
        try{
            y = constructorpage.getImageDnD().getLocation().y;
            constructorpage.getImageDnD().getLocation();
            offset = -150;
            actions.dragAndDropBy(constructorpage.getImageDnD(),0, offset).perform();
        }catch (Exception e){
            y = constructorpage.getChangedImageDnD().getLocation().y;
            offset = 150;
            actions.dragAndDropBy(constructorpage.getChangedImageDnD(),0, offset).perform();
        }
        Thread.sleep(1000);
        Assert.assertEquals( (y + offset), constructorpage.getChangedImageDnD().getLocation().y, 50);

    }

}
