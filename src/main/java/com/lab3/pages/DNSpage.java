package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DNSpage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/span[2]")
    private WebElement name;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/span[4]")
    private WebElement domain;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/button[2]")
    private WebElement dnsSubmit;



    public WebDriver webDriver;
    public DNSpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public WebElement getName() {
        return name;
    }

    public WebElement getDomain() {
        return domain;
    }

    public WebElement getDnsSubmit() {
        return dnsSubmit;
    }
}
