package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="login")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    public WebElement login;


    public void login(String emailStr,String passwordStr){
        email.sendKeys(emailStr);
        password.sendKeys(passwordStr);
        login.click();

    }
}
