package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mainpage {

    @FindBy(xpath = "//*[@id=\"choice\"]/div/div/div[1]")
    private WebElement uKitBlock;
    @FindBy(xpath = "//*[@id=\"choice\"]/div/div/div[2]")
    private WebElement uCozBlock;
    @FindBy(xpath = "//*[@id=\"choice\"]/div/div/div[3]")
    private WebElement divlyBlock;
    @FindBy(xpath = "//*[@id=\"choice\"]/div/div/div[1]/div[3]/a[1]")
    private WebElement ukitAuthButton;


    public WebDriver webDriver;
    public Mainpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }



    public WebElement getuKitBlock() {
        return uKitBlock;
    }

    public WebElement getuCozBlock() {
        return uCozBlock;
    }

    public WebElement getDivlyBlock() {
        return divlyBlock;
    }

    public WebElement getUkitAuthButton() {
        return ukitAuthButton;
    }
}

