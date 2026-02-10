package org.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver webdriver) {
        super(webdriver);
    }

    public LoginPage fillUsername(String username){
        getElement(By.cssSelector("input[name='username']")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password){
        getElement(By.xpath("//input[@name='password']")).sendKeys(password);
        return this;
    }

    public OverViewPage clickLoginButton(){
        getElement(By.cssSelector("input[value='Log In']")).click();
        return navigateToPage(OverViewPage.class);
    }

}
