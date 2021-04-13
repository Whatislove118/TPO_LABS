package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Constructorpage {

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[1]/span[2]")
    private WebElement imageDnD;


    public WebDriver webDriver;
    public Constructorpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public WebElement getImageDnD() {
        return imageDnD;
    }
}
