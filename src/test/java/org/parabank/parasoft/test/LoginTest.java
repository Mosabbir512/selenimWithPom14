package org.parabank.parasoft.test;

import org.parabank.parasoft.pages.LoginPage;
import org.parabank.parasoft.pages.OverviewPage;
import org.parabank.parasoft.util.ParaBankUtil;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test
    public void checkTittle() {
        LoginPage lPage = pg.navigateToPage(LoginPage.class);
        String title = lPage.getPageTitle();
        Assert.assertEquals(title, ParaBankUtil.TITTLE);
    }

    @Test
    public void loginShouldSucceedWithValidCredentialV1() {
        LoginPage loginPage = pg.navigateToPage(LoginPage.class);
        loginPage = loginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword());

        OverviewPage oPage = loginPage
                .clickLoginButton();
        Assert.assertTrue(oPage.hasLogOutLink());
    }

    @Test
    public void loginShouldSucceedWithValidCredentialV2() {
        OverviewPage overviewPage = pg.navigateToPage(LoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(overviewPage.hasLogOutLink());
    }
}