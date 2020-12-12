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
    private By loginField = By.id("login");
    private By passwdField = By.id("pass");

    public void inButton(){
        driver.findElement(By.id("login_form_show_js")).click();}
    public void inputLogin(String login) {
        driver.findElement(loginField).click();
        driver.findElement(loginField).sendKeys(login); }
    public void inputPasswd(String passwd) {
        driver.findElement(passwdField).click();
        driver.findElement(passwdField).sendKeys(passwd); }
    public void clickLoginBtn() {
        driver.findElement(LoginForm).submit(); }

}
