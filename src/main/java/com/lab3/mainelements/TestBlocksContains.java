package com.lab3.mainelements;

import com.lab1.Main;
import com.lab3.pages.Mainpage;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class TestBlocksContains {

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


    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }

    @Test
    public void testBlockContains_uKit(){
        Assert.assertTrue(Checker.checkIsExist(mainpage.getuKitBlock()));
    }

    @Test
    public void testBlockContains_uCoz(){
        Assert.assertTrue(Checker.checkIsExist(mainpage.getuCozBlock()));
    }

    @Test
    public void testBlockContains_Divly(){
        Assert.assertTrue(Checker.checkIsExist(mainpage.getDivlyBlock()));
    }
}
