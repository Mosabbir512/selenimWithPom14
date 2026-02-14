package org.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApprovedLoanPage extends BasePage{
    public ApprovedLoanPage(WebDriver webdriver) {
        super(webdriver);
    }
    public boolean isApprovedLoanId() {
        return getElements(By.id("newAccountId")).size() > 0;
    }
}
