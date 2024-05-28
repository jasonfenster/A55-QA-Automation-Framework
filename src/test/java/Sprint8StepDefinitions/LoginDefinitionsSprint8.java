package Sprint8StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginDefinitionsSprint8 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenTheWebBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-new-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void iCloseTheWebBrowser(){
        driver.quit();
    }

    @And("I open the Koel login page")
    public void iOpenTheKoelLoginPage() {
        driver.get("https://qa.koel.app/");
    }


    @When("I enter my Koel email {string}")
    public void iEnterMyKoelEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);

    }

    @And("I enter my Koel password {string}")
    public void iEnterMyKoelPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);

    }

    @And("I hit the Koel submit button")
    public void iHitTheKoelSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();

    }

    @Then("I am taken to the Koel homepage")
    public void iAmTakenToTheKoelHomepage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    //Scenario: 3.1 User should be able to navigate to Current Queue page
    // in Koel after successful login.
    @And("I select the Current Queue tab")
    public void iSelectTheCurrentQueueTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > section.music > ul > li:nth-child(2) > a"))).click();
    }

    @Then("I am taken to the Current Queue Page")
    public void iAmTakenToTheCurrentQueuePage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#queueWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }

    //Scenario: 3.2 User should be able to navigate to All Songs page in Koel
    //after successful login.
    @And("I select the All Songs tab")
    public void iSelectTheAllSongsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a"))).click();
    }

    @Then("I am taken to the All Songs Page")
    public void iAmTakenToTheAllSongsPage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }

    //    Scenario: 3.3 User should be able to navigate to Albums page in Koel
    //    after successful login.
    @And("I select the Albums tab")
    public void iSelectTheAlbumsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > section.music > ul > li:nth-child(4) > a"))).click();
    }

    @Then("I am taken to the Albums Page")
    public void iAmTakenToTheAlbumsPage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#albumsWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }
    //Scenario: 3.4 User should be able to navigate to Artists page in Koel
    //after successful login.
    @And("I select the Artists tab")
    public void iSelectTheArtistsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > section.music > ul > li:nth-child(5) > a"))).click();
    }

    @Then("I am taken to the Artists Page")
    public void iAmTakenToTheArtistsPage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#artistsWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }

    //Scenario: 3.5 User should be able to navigate to Favorites page in Koel
    //after successful login.
    @And("I select the Favorites tab")
    public void iSelectTheFavoritesTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li.playlist.favorites > a"))).click();
    }

    @Then("I am taken to the Favorites Page")
    public void iAmTakenToTheFavoritesPage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#favoritesWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }

    //Scenario: 3.6 User should be able to navigate to Recently Played page in Koel
    //after successful login.
    @And("I select the Recently tab")
    public void iSelectTheRecentlyTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li.playlist.recently-played > a"))).click();
    }

    @Then("I am taken to the Recently Page")
    public void iAmTakenToTheRecentlyPage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#recentlyPlayedWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }

    //Scenario: 3.7 User should be able to navigate to User's Created Playlist page in Koel
    //after successful login.
    @And("I select the Created Playlist tab")
    public void iSelectTheCreatedPlaylistTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a"))).click();
    }

    @Then("I am taken to the Created Playlist Page")
    public void iAmTakenToTheCreatedPlaylistPage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlistWrapper > header > div.heading-wrapper > h1"))).isDisplayed());
    }

    //Scenario: 4. User should be taken to a last visited page
    //  (All Songs) after logging out and logging in again.
    @And("I log out of Koel")
    public void iLogOutOfKoel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge > a.logout.control > i"))).click();
    }

    //Scenario: 5. User should be able to log in with the updated email
    //and the old email should not work

    @And("I select the profile button")
    public void iSelectTheProfileButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge > a.view-profile > span"))).click();
    }

    @And("I replace the current email")
    public void iClearTheCurrentEmail() {
        WebElement currentEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileEmail")));
        currentEmailInput.clear();
        currentEmailInput.sendKeys("jason.fenstermaker123@testpro.io");
    }

    @And("I enter the current password")
    public void iEnterTheCurrentPassword() {
        WebElement currentPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileCurrentPassword")));
        currentPasswordInput.sendKeys("Testpro.io2");
    }

    @And("I select the save button")
    public void iSelectTheSaveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#profileWrapper > div > form > div:nth-child(5) > button"))).click();
    }

    @And("I sign out")
    public void iSignOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge > a.logout.control > i"))).click();

    }

    @And("I am taken to the login page")
    public void iAmTakenToTheLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div > div > form > div.logo > img"))).isDisplayed();
    }

    @And("I enter the new email {string}")
    public void iEnterTheNewEmail(String newEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(newEmail);

    }

    //Scenario: 5.2 User should not be able to log in with the old email
    @Then("User should still be on the login screen")
    public void userShouldStillBeOnTheLoginScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div > div > form > div.logo > img"))).isDisplayed();
    }

    //Scenario: 6.1 User should be able to login with an updated password
    @And("I enter the new password")
    public void iEnterTheNewPassword() {
        WebElement newPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputProfileNewPassword")));
        newPasswordInput.clear();
        newPasswordInput.sendKeys("Testpro.io1");
    }

    @And("I enter my New Koel password {string}")
    public void iEnterMyNewKoelPassword(String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys("newPassword");
    }

    //Scenario 6.2 Old Password should not work

    @And("I am still on the login screen")
    public void iAmStillOnTheLoginScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div > div > form > div.logo > img"))).isDisplayed();
    }

    //Scenario: 7.1 - 3
    @When("I enter email without @ symbol {string}")
    public void iEnterEmailWithoutSymbol(String missingSymbolEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(missingSymbolEmail);
    }

    @When("I enter email without dot {string}")
    public void iEnterEmailWithoutDot(String missingDotEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(missingDotEmail);
    }

    @When("I enter email without domain {string}")
    public void iEnterEmailWithoutDomain(String missingDomainEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(missingDomainEmail);
    }

    @Then("Message {string} appears")
    public void messageAppears(String expectedMessage) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue("Expected error message not found in page source",
                pageSource.contains(expectedMessage));
    }

}
