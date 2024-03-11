package Sprint9StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import java.time.Duration;

public class KoelLoginStepDefinitions {
    private By userAvatarIcon = By.cssSelector("img.avatar");
    WebDriver driver;

    WebDriverWait wait;

    //@Given("I open the browser")
    @Before
    public void iOpenTheBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @And("I open the login page")
    public void iOpenTheLoginPage() {
        driver.get("https://qa.koel.app/");

    }

    @When("I enter my email {string}")
    public void iEnterMyEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I should be taken to the home page")
    public void iShouldBeTakenToTheHomePage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(userAvatarIcon));

        WebElement avatarImage = wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
        Assert.assertTrue(avatarImage.isDisplayed());
    }


    //Scenario: Login Failure with invalid email
    @Then("I should not be taken to the home page")
    public void iShouldNotBeTakenToTheHomePage() {
        Assert.assertFalse("Avatar should not be visible on failed login", isElementVisible(By.cssSelector("img.avatar")));
    }

    private boolean isElementVisible(By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return false;
        } catch (TimeoutException e) {
            return true;
        }
    }

    //Scenario: Login Failure with invalid password
    @And("I enter my invalid password {string}")
    public void iEnterMyInvalidPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    //Scenario: Login Failure with empty Email and Password fields
    @When("I enter empty email {string}")
    public void iEnterEmptyEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.clear();
    }

    @And("I enter empty password {string}")
    public void iEnterEmptyPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.clear();


        }

    //Scenario: User can update email successfully
    @And("User selects edit user profile")
    public void userSelectsViewEditUserProfile() {
        WebElement viewProfileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge > a.view-profile > span")));
        viewProfileLink.click();
    }

    @And("User enters current password")
    public void userEntersCurrentPassword() {
        WebElement currentPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileCurrentPassword")));
        currentPasswordInput.sendKeys("Testpro.io2");
    }

    @And("User clears current email")
    public void userClearsCurrentEmail() {
        WebElement currentEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileEmail")));
        currentEmailInput.clear();
    }

    @And("User enters new email")
    public void userEntersNewEmail() {
        WebElement newEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileEmail")));
        newEmailInput.clear();
        newEmailInput.sendKeys("jason.fenstermaker123@testpro.io");
    }


    @And("User selects Save Button")
    public void userSelectsSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#profileWrapper > div > form > div:nth-child(5) > button")));
        saveButton.click();
    }

    @Then("Profile Updated popup appears")
    public void profileUpdatedPopupAppears() {
        By popupLocator = By.cssSelector("body > div.alertify-logs.top.right > div");

        WebElement profileUpdatePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
        Assert.assertNotNull("Profile Updated popup did not appear.", profileUpdatePopup);

        // Extract message from the popup
        String popupMessage = profileUpdatePopup.getText();

        // Print the actual and expected messages for debugging
        System.out.println("Actual Profile Update Popup Message: " + popupMessage);
        System.out.println("Expected Profile Update Popup Message: Profile Updated.");

        // Assert that the message is "Profile Updated." without case sensitivity
        Assert.assertTrue("Profile Updated message doesn't match expected content",
                popupMessage.equalsIgnoreCase("Profile Updated."));

    }

    //Scenario: Login with new email
    @When("I enter my new email {string}")
    public void iEnterMyNewEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    //Scenario: Not be able to login with old email
    @When("I enter my old email {string}")
    public void iEnterMyOldEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    //Scenario: User can update password successfully

    @And("User enters new password {string}")
    public void userEntersNewPassword(String newPassword) {
        WebElement newPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileNewPassword")));
        newPasswordInput.clear();
        newPasswordInput.sendKeys(newPassword);
    }


}

