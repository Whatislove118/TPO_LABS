package com.lab3.utils;

import org.openqa.selenium.WebElement;

public class Checker {

    public static boolean checkIsExist(WebElement webElement){
        return webElement.isDisplayed();
    }
}
