package org.Testing.Tests;

import org.Testing.Classes.CityPage;
import org.Testing.Classes.ReadingProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CityTest {
    CityPage cityPage;
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
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-version-switcher__button")));
        cityPage = new CityPage(driver);
    }

    @DataProvider
    public Object[][] cityChange() {
        return new Object[][]{
                {"Москва"},
                {"Казань"},
                {"Самара"}
        };
    }

    @Test(dataProvider = "cityChange")
    public void cityTest(String city){
        cityPage.changeCity(city);
        cityPage.сhangeСheck(city);
        cityPage.deliveryCheck(city);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

