package org.parabank.parasoft.test;

import org.parabank.parasoft.pages.LoginPage;
import org.parabank.parasoft.pages.OpenedAccountPage;
import org.parabank.parasoft.pages.OpenNewAccountPage;
import org.parabank.parasoft.pages.OverViewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest{
    @Test
    public void openNewAccountShouldSucceedv1(){
        LoginPage page=pg.navigateToPage(LoginPage.class);
        page=page.fillUsername("mosabbir19")
                .fillPassword("1234");
        OverViewPage page2=page.clickLoginButton();
        OpenNewAccountPage page3=page2.clickOpenNewAccountLink();
        OpenedAccountPage page4=page3.clickOpenNewAccountButton();

        Assert.assertTrue(page4.hasOpenAccountId());

    }

    @Test
    public void openNewAccountShouldSucceedv2(){
        OpenedAccountPage page4=pg.navigateToPage(LoginPage.class)
                .fillUsername("mosabbir19")
                .fillPassword("1234")
                .clickLoginButton()
                .clickOpenNewAccountLink()
                .clickOpenNewAccountButton();

        Assert.assertTrue(page4.hasOpenAccountId());

    }
}
