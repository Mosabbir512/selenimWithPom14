package org.parabank.parasoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.parabank.parasoft.pages.BasePage;
import org.parabank.parasoft.pages.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    Page pg;

    @BeforeMethod
    public void browserSetup(){
        driver=new FirefoxDriver();
        System.out.println("Browser Set up before each test method.");
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        pg=new BasePage(driver);
    }

    @AfterMethod
    public void browserTearDown(){
        driver.quit();
        System.out.println("Browser TearDown after each method. ");
    }
}
