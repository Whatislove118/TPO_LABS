package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DNSpage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div[1]/span[2]/input")
    private WebElement name;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/span[4]")
    private WebElement domain;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/button[2]")
    private WebElement dnsSubmit;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/a")
    private WebElement dnsInputActivateButton;



    public WebDriver webDriver;
    public DNSpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void chooseDNS(){
        this.getDnsInputActivateButton().click();
        this.getName().sendKeys("tpo-three");
        this.getDnsSubmit().click();
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

    public WebElement getDnsInputActivateButton() {
        return dnsInputActivateButton;
    }
}
