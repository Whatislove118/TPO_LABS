package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Constructorpage {

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[1]/span[2]")
    private WebElement imageDnD;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/span[2]")
    private WebElement changedImageDnD;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div")
    private WebElement basicButton;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[1]/ul/li[6]")
    private WebElement basicElement;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/div/span[2]")
    private WebElement structureButton;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/ul/li[1]")
    private WebElement structureElement;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[3]/div/span[2]")
    private WebElement contentButton;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[3]/ul/li[12]")
    private WebElement contentElement;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[6]/div")
    private WebElement mediaButton;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[6]/ul/li[1]")
    private WebElement mediaElement;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[7]/div/span[2]")
    private WebElement contactsButton;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[7]/ul/li[1]")
    private WebElement contactsElement;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[8]/div/span[2]")
    private WebElement socialButton;

    @FindBy(xpath = "//*[@id=\"ul-panelConstructor\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[8]/ul/li[3]")
    private WebElement socialElement;

    @FindBy(xpath = "//*[@id=\"ul-left-menu\"]/div[1]/div[2]/span[4]")
    private WebElement designButton;

    @FindBy(xpath = "//*[@id=\"ul-left-menu\"]/div[1]/div[2]/span[3]")
    private WebElement constructorButton;

    @FindBy(xpath = "//*[@id=\"ul-left-menu\"]/div[1]/div[3]/span[6]")
    private WebElement publishButton;

    @FindBy(xpath = "//*[@id=\"body\"]")
    private WebElement canvas;








    public WebDriver webDriver;
    public Constructorpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public WebElement getBasicButton() {
        return basicButton;
    }

    public WebElement getBasicElement() {
        return basicElement;
    }

    public WebElement getStructureButton() {
        return structureButton;
    }

    public WebElement getStructureElement() {
        return structureElement;
    }

    public WebElement getContentButton() {
        return contentButton;
    }

    public WebElement getContentElement() {
        return contentElement;
    }

    public WebElement getMediaButton() {
        return mediaButton;
    }

    public WebElement getMediaElement() {
        return mediaElement;
    }

    public WebElement getContactsButton() {
        return contactsButton;
    }

    public WebElement getContactsElement() {
        return contactsElement;
    }

    public WebElement getSocialButton() {
        return socialButton;
    }

    public WebElement getSocialElement() {
        return socialElement;
    }

    public WebElement getDesignButton() {
        return designButton;
    }

    public WebElement getConstructorButton() {
        return constructorButton;
    }

    public WebElement getPublishButton() {
        return publishButton;
    }

    public WebElement getCanvas() {
        return canvas;
    }

    public WebElement getImageDnD() {
        return imageDnD;
    }

    public WebElement getChangedImageDnD() {
        return changedImageDnD;
    }
}
