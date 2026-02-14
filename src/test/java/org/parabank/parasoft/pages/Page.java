package org.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.parabank.parasoft.util.ParaBankUtil;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver webdriver){
        this.driver=webdriver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(ParaBankUtil.WAIT_TIME));
    }

    public abstract WebElement getElement(By selector);
    public abstract List<WebElement> getElements(By selector);
    public abstract String getTextFormElement(By selector);
    public abstract void clickElement(By selector);
    public abstract String getPageTitle();

    public abstract void waitForElementToBeVisible(By selector);

    public <T extends BasePage> T navigateToPage(Class<T> pageClass){
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
