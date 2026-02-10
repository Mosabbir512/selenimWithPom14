package org.parabank.parasoft.test;

import org.parabank.parasoft.pages.LoginPage;
import org.parabank.parasoft.pages.OverViewPage;
import org.parabank.parasoft.util.ParaBankUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void checkTitle(){
        String title=pg.getPageTitle();
        Assert.assertEquals(title, ParaBankUtil.TITTLE);
    }

    @Test
    public void loginShouldSuccessWithValidCredentialsv1(){
        LoginPage loginPage=pg.navigateToPage(LoginPage.class);
        loginPage=loginPage
                .fillUsername("mosabbir19")
                .fillPassword("1234");
        OverViewPage overViewPage=loginPage.clickLoginButton();
        Assert.assertTrue(overViewPage.haslogoutLink());
    }


    @Test
    public void loginShouldSuccessWithValidCredentialsv2(){
        OverViewPage overViewPage=pg.navigateToPage(LoginPage.class)
                .fillUsername("mosabbir19")
                .fillPassword("1234")
                .clickLoginButton();
        Assert.assertTrue(overViewPage.haslogoutLink());
    }
}
