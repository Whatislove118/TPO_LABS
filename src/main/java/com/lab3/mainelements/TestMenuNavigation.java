package com.lab3.mainelements;

import com.lab3.pages.Menu;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestMenuNavigation {

    public static Menu menu;
    public static WebDriver chromeDriver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        menu = new Menu(chromeDriver);
    }


    @AfterClass
    public static void close(){
        chromeDriver.close();
    }

    @Test
    public void testExistingButton_TOUR(){

    }

    @Test
    public void testExistingButton_BLOG(){

    }

    @Test
    public void testExistingButton_FORUM(){

    }

    @Test
    public void testExistingButton_TARIFF(){

    }

    @Test
    public void testExistingButton_VACANCY(){

    }

    @Test
    public void testExistingButton_EXAMPLES(){

    }

    @Test
    public void testExistingButton_KNOWLEDGE_BASE(){}

    @Test
    public void testExistingButton_FEEDBACK(){}

    @Test
    public void testExistingButton_REGISTRATION(){}

    @Test
    public void testExistingButton_AUTHORIZATION(){}
}
