package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu{

    @FindBy(xpath = "/html/body/button")
    private WebElement menuElement;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[2]")
    private WebElement tour;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]")
    private WebElement blog;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[4]")
    private WebElement forum;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[5]")
    private WebElement tariff;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[6]")
    private WebElement vacancy;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[7]")
    private WebElement examples;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[8]")
    private WebElement knowledgeBase;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/a[9]")
    private WebElement feedback;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[1]/a[1]")
    private WebElement registration;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[1]/a[2]")
    private WebElement authorization;




    public WebDriver webDriver;
    public Menu(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public WebElement getMenuElement() {
        return menuElement;
    }

    public WebElement getTour() {
        return tour;
    }

    public WebElement getBlog() {
        return blog;
    }

    public WebElement getForum() {
        return forum;
    }

    public WebElement getTariff() {
        return tariff;
    }

    public WebElement getVacancy() {
        return vacancy;
    }

    public WebElement getExamples() {
        return examples;
    }

    public WebElement getKnowledgeBase() {
        return knowledgeBase;
    }

    public WebElement getFeedback() {
        return feedback;
    }

    public WebElement getRegistration() {
        return registration;
    }

    public WebElement getAuthorization() {
        return authorization;
    }
}
