package org.parabank.parasoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.parabank.parasoft.pages.BasePage;
import org.parabank.parasoft.pages.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.io.FileInputStream;

import java.util.Objects;
import java.util.Properties;


public class BaseTest {
    WebDriver driver;
    Page pg;
    private Properties prop;



    public BaseTest() {
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(path);
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void browserSetup(){
        String browserName="firefox";

        if(Objects.equals(browserName,"firefox")){
            driver=new FirefoxDriver();
        } else if (Objects.equals(browserName,"chrome")) {
            driver=new ChromeDriver();
        } else if (Objects.equals(browserName,"edge")) {
            driver=new EdgeDriver();
        } else if (Objects.equals(browserName,"safari")) {
            driver=new SafariDriver();
        } else if (Objects.equals(browserName,"headlessFirefox")) {
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--headless");
            driver=new FirefoxDriver(options);
        } else if (Objects.equals(browserName,"headlessChrome")) {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--headless");
            driver=new ChromeDriver(options);
        }
        else {
            throw new IllegalArgumentException("unsupported browser : "+browserName);
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("baseUrl"));
        pg = new BasePage(driver);



    }

    @AfterMethod
    public void browserTearDown(){
        driver.quit();
        System.out.println("Browser TearDown after each method. ");
    }


    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}
