package com.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authpage {

    @FindBy(xpath = "//*[@id=\"container_sign_up\"]/div[2]/div[2]/div/div[1]/div[1]/span[1]")
    private WebElement vkButton;
    @FindBy(xpath = "//*[@id=\"container_sign_up\"]/div[2]/div[2]/div/div[1]/div[1]/span[2]")
    private WebElement facebookButton;
    @FindBy(xpath = "///*[@id=\"container_sign_up\"]/div[2]/div[2]/div/div[1]/div[1]/span[3]")
    private WebElement uUIDButton;

    @FindBy(xpath = "//*[@id=\"sign_up_email\"]")
    private WebElement emailInputReg;
    @FindBy(xpath = "//*[@id=\"sign_up_password\"]")
    private WebElement passwordInputReg;

    @FindBy(xpath = "//*[@id=\"sign_in_email\"]")
    private WebElement emailInputLogin;
    @FindBy(xpath = "//*[@id=\"sign_in_password\"]")
    private WebElement passwordInputLogin;

    @FindBy(xpath = "//*[@id=\"sign_up_btn\"]")
    private WebElement submitButtonReg;
    @FindBy(xpath = "//*[@id=\"sign_in_btn\"]")
    private WebElement submitButtonLogin;

    @FindBy(xpath = "//*[@id=\"container_sign_up\"]/div[2]/div[2]/div/div[3]/div[2]/div[2]")
    private WebElement errBlock;
    @FindBy(xpath = "//*[@id=\"container_sign_up\"]/div[2]/div[2]/div/p[3]/button")
    private WebElement loginButton;



    public WebDriver webDriver;
    public Authpage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public WebElement getVkButton() {
        return vkButton;
    }

    public WebElement getFacebookButton() {
        return facebookButton;
    }

    public WebElement getuUIDButton() {
        return uUIDButton;
    }

    public WebElement getEmailInputReg() {
        return emailInputReg;
    }

    public WebElement getPasswordInputReg() {
        return passwordInputReg;
    }

    public WebElement getSubmitButtonReg() {
        return submitButtonReg;
    }

    public WebElement getErrBlock() {
        return errBlock;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getEmailInputLogin() {
        return emailInputLogin;
    }

    public WebElement getPasswordInputLogin() {
        return passwordInputLogin;
    }

    public WebElement getSubmitButtonLogin() {
        return submitButtonLogin;
    }
}
