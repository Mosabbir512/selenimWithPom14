package org.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenedAccountPage extends BasePage{
    public OpenedAccountPage(WebDriver webdriver) {
        super(webdriver);
    }
    public boolean hasOpenAccountId(){
        return getElements(By.id("newAccountId")).size()>0;
    }

}
