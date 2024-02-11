import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
       emailField.clear();
       emailField.sendKeys("jason.fenstermaker1234@testpro.io");

         WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
       passwordField.clear();
       passwordField.sendKeys("Testpro.io2");

       WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
       loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    //Login with valid email Test using the Page Object Model
    @Test
    public void loginValidEmailValidPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("jason.fenstermaker1234@testpro.io");
        loginPage.providePassword("Testpro.io2");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }


}
