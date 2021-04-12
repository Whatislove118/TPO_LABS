package com.lab3.mainelements;

import com.lab3.pages.Menu;
import com.lab3.utils.Checker;
import com.lab3.utils.ConfProperties;
import com.sun.tools.javac.comp.Check;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
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
        chromeDriver.quit();
    }

    @Before
    public void clickMenu() throws InterruptedException {
        Thread.sleep(500);
        menu.getMenuElement().click();
    }

    @After
    public void setOff(){
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
    }
    

    @Test
    public void testNavigationTo_TOUR(){
        menu.getTour().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_tour"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));

    }

    @Test
    public void testNavigationTo_BLOG(){
        menu.getBlog().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));;
        Assert.assertEquals(ConfProperties.getProperty("menu_page_blog"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testNavigationTo_FORUM(){
        menu.getForum().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_forum"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testNavigationTo_TARIFF(){
        menu.getTariff().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_tariff"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));

    }

    @Test
    public void testNavigationTo_VACANCY(){
        menu.getVacancy().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_vacancy"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testNavigationTo_EXAMPLES(){
        menu.getExamples().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_examples"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testNavigationTo_KNOWLEDGE_BASE(){
        menu.getKnowledgeBase().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_knowledge-base"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testNavigationTo_FEEDBACK(){
        menu.getFeedback().click();
        List<String> browserTabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(ConfProperties.getProperty("menu_page_feedback"), chromeDriver.getCurrentUrl());
        chromeDriver.close();
        chromeDriver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testNavigationTo_REGISTRATION(){
        menu.getRegistration().click();
        Assert.assertEquals(ConfProperties.getProperty("menu_page_registration"), chromeDriver.getCurrentUrl());
    }

    @Test
    public void testExisting_AUTHORIZATION(){
        Assert.assertTrue(Checker.checkIsExist(menu.getAuthorization()));
    }
}
