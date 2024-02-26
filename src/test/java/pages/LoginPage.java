package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Element

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginBtn = By.cssSelector("button[type='submit']");

    //Helper Methods

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(loginBtn).click();
    }

    public void login(){
        provideEmail("jason.fenstermaker1234@testpro.io");
        providePassword("Testpro.io2");
        clickSubmit();
    }



}
