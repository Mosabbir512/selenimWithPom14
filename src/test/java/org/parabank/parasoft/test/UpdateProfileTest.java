package org.parabank.parasoft.test;

import org.parabank.parasoft.pages.LoginPage;
import org.parabank.parasoft.pages.UpdateProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest extends BaseTest{

    @Test
    public void updateShouldSucceed(){
        UpdateProfilePage up=pg.navigateToPage(LoginPage.class)
                .doLogin(getUsername(),getUsername())
                .clickUpdateProfileLink()
                .fillFirstName("Mosa")
                .fillLastName("Hoss")
                .fillAddress("Din")
                .fillCity("Tan")
                .fillState("Dha")
                .fillZipCode("5200")
                .fillPhone("22222")
                .clickUpdateProfileButton();
        Assert.assertTrue(up.isResultMessageDisplayed());
    }
}
