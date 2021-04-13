package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseProjectpage {
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[1]/div[3]/a")
    private WebElement change;


    public WebDriver webDriver;
    public ChooseProjectpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public WebElement getChange() {
        return change;
    }
}
