package org.Testing.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CityPage {
    public WebDriver driver;

    public CityPage(WebDriver drivers) {
        this.driver = drivers;
    }


    public void changeCity(String cityname) {
        driver.findElement(By.cssSelector(".pseudo.pseudo_dashed.popup_close.city-popup_toggle-button__js")).click();
        driver.findElement(By.partialLinkText(cityname)).click();
    }

    public void сhangeСheck(String cityname) {
        Assert.assertEquals(cityname, driver.findElement(By.className("popup_close")).getText());
    }

    public void deliveryCheck(String cityname) {
        driver.findElement(By.cssSelector("[data-link-type = \"Delivery\"] a")).click();
        String name = driver.findElement(By.cssSelector(".about_content.inside_block h1:first-child span")).getText();
        Assert.assertEquals(name.contains(cityname), true);
    }
}

