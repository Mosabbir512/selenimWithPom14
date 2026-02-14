package org.parabank.parasoft.test;

import org.parabank.parasoft.pages.LoginPage;
import org.parabank.parasoft.pages.OverviewPage;
import org.parabank.parasoft.pages.RegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerShouldSucceed() {
        String username = LoremIpsum.getInstance().getName().replaceAll(" ", "");
        LoginPage page = pg.navigateToPage(LoginPage.class);
        RegisterPage registerPage = page.clickRegisterLink();
        registerPage = registerPage
                .fillFirstName("John")
                .fillLastName("Doe")
                .fillAddress("123 Main St")
                .fillCity("Anytown")
                .fillState("Anystate")
                .fillZipCode("12345")
                .fillPhone("123-456-7890")
                .fillSsn("123-45-6789")
                .fillUsername(username)
                .fillPassword("password123")
                .fillConfirmPassword("password123");
        OverviewPage overViewPage= registerPage.clickRegisterButton();
        Assert.assertTrue(overViewPage.hasLogOutLink());

    }

    @Test
    public void registerShouldSucceedV2() {
        String username = LoremIpsum.getInstance().getName().replaceAll(" ", "");
        OverviewPage oPage = pg.navigateToPage(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getTitle(5))
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterButton();
        Assert.assertTrue(oPage.hasLogOutLink());
    }

//    @Test(dataProvider = "getDataProviderData")
//    public void registerDdtShouldSucceedV2(String firstName, String lastName, String address) {
//        String username = LoremIpsum.getInstance().getName().replaceAll(" ", "");
//        OverviewPage oPage = pg.navigateToPage(LoginPage.class)
//                .clickRegisterLink()
//                .fillFirstName(firstName)
//                .fillLastName(lastName)
//                .fillAddress(address)
//                .fillCity(LoremIpsum.getInstance().getCity())
//                .fillState(LoremIpsum.getInstance().getStateAbbr())
//                .fillZipCode(LoremIpsum.getInstance().getZipCode())
//                .fillPhone(LoremIpsum.getInstance().getPhone())
//                .fillSsn(LoremIpsum.getInstance().getPhone())
//                .fillUsername(username)
//                .fillPassword(username)
//                .fillConfirmPassword(username)
//                .clickRegisterButton();
//        Assert.assertTrue(oPage.hasLogOutLink());
//    }

}
