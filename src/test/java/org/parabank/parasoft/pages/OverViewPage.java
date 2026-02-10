package org.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage extends BasePage{
    public OverViewPage(WebDriver webdriver) {
        super(webdriver);
    }

    public boolean haslogoutLink(){
        return getElements(By.cssSelector("a[href='logout.htm']")).size()>0;
    }

    public OpenNewAccountPage clickOpenNewAccountLink(){
        getElement(By.cssSelector("div[id='leftPanel'] h2")).click();
        return navigateToPage(OpenNewAccountPage.class);
    }
}
