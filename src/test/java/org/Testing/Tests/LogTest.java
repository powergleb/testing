package org.Testing.Tests;

import org.Testing.Classes.LogPage;
import org.Testing.Classes.ProfilePage;
import org.Testing.Classes.ReadingProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LogTest {

    LogPage logPage;
    ProfilePage profilePage;
    WebDriver driver;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ReadingProperties.getProperty(("chromedriver")));
        driver = new ChromeDriver();

        driver.get(ReadingProperties.getProperty("mainpage"));


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("SiteVersionSwitcher__button")));
            driver.findElement(By.className("SiteVersionSwitcher__button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("SiteVersionSwitcher__button")));
        }
        catch (Exception e)
        {        }
        logPage = new LogPage(driver);
        profilePage = new ProfilePage(driver);

    }
    @Test
    public void loginTest() throws InterruptedException {
        logPage.inButton();
        logPage.inputLogin(ReadingProperties.getProperty("login"));
        logPage.inputPasswd(ReadingProperties.getProperty("password"));
        Thread.sleep(10000);
        logPage.clickLoginBtn();
        Assert.assertEquals("Евгений", profilePage.getUserName());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }





}
