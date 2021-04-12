package com.lab3.siteconfiguration;

import com.lab3.pages.Authpage;
import com.lab3.pages.DNSpage;
import com.lab3.pages.Templatepage;
import com.lab3.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestDNSConfig {
    public static Authpage authpage;
    public static DNSpage dnSpage;
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
        dnSpage = new DNSpage(chromeDriver);
    }


    @AfterClass
    public static void close(){
        chromeDriver.quit();
    }


    @Test
    public void testChoosingDomain(){
        dnSpage.getName().sendKeys("tpo-three");
        dnSpage.getDnsSubmit().click();
    }

}
