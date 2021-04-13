package com.lab3.pages;

import com.lab3.utils.ConfProperties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Templatepage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[3]")
    private WebElement template;

    public WebDriver webDriver;
    public Templatepage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public WebElement getTemplate() {
        return template;
    }


    public void chooseTemplate(){
        this.getTemplate().click();
    }
}
