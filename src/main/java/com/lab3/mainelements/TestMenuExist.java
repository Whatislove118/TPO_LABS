package com.lab3.mainelements;

import com.lab3.pages.Mainpage;
import com.lab3.pages.Menu;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import com.sun.tools.javac.comp.Check;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestMenuExist {

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
        chromeDriver.quit();
    }

    @Test
    public void checkMenuExisting(){
        Assert.assertTrue(Checker.checkIsExist(menu.getMenuElement()));
    }
}
