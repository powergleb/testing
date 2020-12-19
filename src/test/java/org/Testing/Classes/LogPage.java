package org.Testing.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogPage {

    public WebDriver driver;

    public LogPage(WebDriver drivers) {
        this.driver = drivers;
    }

    private By LoginForm =  By.className("auth-popup__form-body");


    public void inButton(){
        driver.findElement(By.id("login_form_show_js")).click();}
    public void inputLogin(String login) {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys(login); }
    public void inputPasswd(String passwd) {
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).sendKeys(passwd); }
    public void clickLoginBtn() {
        driver.findElement(LoginForm).submit(); }

}
