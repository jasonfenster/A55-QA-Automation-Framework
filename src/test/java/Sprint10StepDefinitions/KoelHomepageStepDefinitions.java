package Sprint10StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class KoelHomepageStepDefinitions {

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
    @io.cucumber.java.After
    public void closeBrowser() {
        driver.quit();
    }


    @And("I open a login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");

    }

    @When("I enter an email {string}")
    public void iEnterAnEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter a password {string}")
    public void iEnterAPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I click on the-a login button")
    public void iClickOnTheALoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I should be logged in hopefully")
    public void iShouldBeLoggedInHopefully() {
        wait.until(ExpectedConditions.presenceOfElementLocated(userAvatarIcon));

        WebElement avatarImage = wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
        Assert.assertTrue(avatarImage.isDisplayed());
    }

    //Scenario: Welcome message for a new user should be the following: 'Hello, Student!'
    @When("I enter newly registered newEmail {string}")
    public void iEnterNewlyRegisteredEmail(String newEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(newEmail);
    }

    @And("I enter newly registered newPassword {string}")
    public void iEnterNewlyRegisteredPassword(String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(newPassword);
    }


    @Then("Welcome message for a new user should be appear")
    public void welcomeMessageShouldBe() {
        By welcomeMessageLocator = By.cssSelector("#homeWrapper > header > div.heading-wrapper");

        WebElement welcomeMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(welcomeMessageLocator));

        String actualMessage = welcomeMessageElement.getText().trim();

        Assert.assertFalse("Welcome message is not present", actualMessage.isEmpty());
    }


    //Scenario: Recently played songs should be present if user played at least one song
    @And("I select the recently played tab")
    public void iSelectTheRecentlyPlayedTab() {
        By recentlyPlayedTab = By.cssSelector("#playlists > ul > li.playlist.recently-played > a");
        WebElement recentlyPlayedTabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(recentlyPlayedTab));
        recentlyPlayedTabElement.click();
    }

    @Then("I interact with the first song in the playlist")
    public void iInteractWithTheFirstSongInThePlaylist() {
        By firstSongSelector = By.cssSelector("#recentlyPlayedWrapper > div > div > div.item-container > table > tr.song-item.playing.selected");

        try {
            WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(firstSongSelector));
            firstSong.click();
            // Add more actions if needed

        } catch (TimeoutException e) {
            e.printStackTrace(); // Handle timeout exception
        }
    }

//Scenario: 'View All' button should be displayed next to Recently played songs
@Then("{string} button should be displayed next to Recently played songs")
public void viewAllButtonShouldBeDisplayedNextToRecentlyPlayedSongs(String buttonName) {
    By viewAllButton = By.cssSelector("#homeWrapper > div > div.two-cols > section.recent > h1 > button");

    try {
        WebElement viewAllButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllButton));
        Assert.assertTrue(buttonName + " button is displayed next to Recently played songs", viewAllButtonElement.isDisplayed());
    } catch (TimeoutException e) {
        Assert.fail(buttonName + " button is not displayed next to Recently played songs");
    }
}
//Scenario: Recently added songs should be present
@When("User selects {string} button")
public void userSelectsButton(String buttonName) {
    By viewAllButton = By.cssSelector("#homeWrapper > div > div.two-cols > section.recent > h1 > button");

    try {
        WebElement viewAllButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllButton));
        Assert.assertTrue(buttonName + " button is displayed next to Recently played songs", viewAllButtonElement.isDisplayed());
        viewAllButtonElement.click();
    } catch (TimeoutException e) {
        Assert.fail(buttonName + " button is not displayed next to Recently played songs");
    }
}

    @Then("User should be taken to Recently played songs")
    public void userShouldBeTakenToRecentlyPlayedSongs() {
        By recentlyPlayedHeader = By.cssSelector("#recentlyPlayedWrapper > header > div.heading-wrapper > h1");

        try {
            WebElement recentlyPlayedHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(recentlyPlayedHeader));
            Assert.assertEquals("Recently played songs header is not displayed", "Recently Played", recentlyPlayedHeaderElement.getText());
        } catch (TimeoutException e) {
            System.out.println("DEBUG: Exception occurred - " + e.getMessage());
            // Add more debugging information if needed
            Assert.fail("User is not taken to Recently played songs");
        }
    }


    @Then("Recently added songs should be present")
    public void recentlyAddedSongsShouldBePresent() {
        By firstRecentlyPlayedSongSelector = By.cssSelector("#recentlyPlayedWrapper > div > div > div.item-container > table > tr:nth-child(1)");

        try {
            WebElement firstRecentlyPlayedSong = wait.until(ExpectedConditions.presenceOfElementLocated(firstRecentlyPlayedSongSelector));
            Assert.assertTrue("No recently added songs are displayed", firstRecentlyPlayedSong.isDisplayed());
        } catch (TimeoutException e) {
            e.printStackTrace(); // Handle timeout exception
        }
    }


    //Scenario: Album name should be displayed for the Recently added songs
    @Then("Album name should be displayed for the Recently added songs")
    public void albumNameShouldBeDisplayedForTheRecentlyAddedSongs() {
        By albumNameSelector = By.cssSelector("#recentlyPlayedWrapper > div > table > thead > tr > th.album");

        try {
            WebElement albumNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(albumNameSelector));
            Assert.assertTrue("Album name is no displayed for the recently added song", albumNameElement.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("Album name is not displayed for the recently added song");
        }

    }

//Scenario: Download and Shuffle icons should be present for Recently added songs
    @Then("Shuffle icon should be present for Recently added songs")
    public void shuffleIconShouldBePresentForRecentlyAddedSongs() {
        By shuffleIconSelector = By.cssSelector("#recentlyPlayedWrapper > header > div.song-list-controls > span > button.btn-shuffle-all");

        try {
            WebElement shuffleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(shuffleIconSelector));
            Assert.assertTrue("Shuffle icon is present for Recently added songs", shuffleIcon.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("Shuffle icon is not present for Recently added songs");
        }
    }
//Scenario: Search field should be present and accessible fromHomepage
    @Then("Search field should be present and accessible")
    public void searchFieldShouldBePresentAndAccessible() {
        By searchFieldSelector = By.cssSelector("#searchForm > input[type=search]");

        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldSelector));
            Assert.assertTrue("Search field is not present or accessible", searchField.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("Search field is not present or accessible");
        }


    }
    //Scenario: Music panel pages: Home, Current Queue, All Songs, Albums, Artists
    @Then("Musical panel includes Home")
    public void musicalPanelIncludesHome() {
        By homePageLink = By.cssSelector("#sidebar > section.music > ul > li:nth-child(1) > a");
        WebElement homePageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLink));
        Assert.assertTrue("Home link is not present in the Music panel", homePageElement.isDisplayed());
    }


    @And("Musical panel includes Current Queue")
    public void musicalPanelIncludesCurrentQueue() {
        By currentQueueLink = By.cssSelector("#sidebar > section.music > ul > li:nth-child(2) > a");
        WebElement currentQueueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(currentQueueLink));
        Assert.assertTrue("Current Queue link is not present in the Music panel", currentQueueElement.isDisplayed());
    }

    @And("Musical panel includes All Songs")
    public void musicalPanelIncludesAllSongs() {
        By allSongsLink = By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a");
        WebElement allSongsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(allSongsLink));
        Assert.assertTrue("All Songs link is not present in the Music panel", allSongsElement.isDisplayed());
    }

    @And("Musical panel includes Album")
    public void musicalPanelIncludesAlbum() {
        By albumLink = By.cssSelector("#sidebar > section.music > ul > li:nth-child(2) > a");
        WebElement albumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(albumLink));
        Assert.assertTrue("Album link is not present in the Music panel", albumElement.isDisplayed());
    }

    @And("Musical panel includes Artists")
    public void musicalPanelIncludesArtists() {
        By artistsLink = By.cssSelector("#sidebar > section.music > ul > li:nth-child(2) > a");
        WebElement artistsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(artistsLink));
        Assert.assertTrue("Artists link is not present in the Music panel", artistsElement.isDisplayed());
    }
//Scenario: PLAYLISTS panel should include: + button for new playlist
    @Then("Playlist panel includes + button")
    public void playlistPanelIncludesButton() {
        By plusBtnLink = By.cssSelector("#playlists > h1 > i");
        WebElement plusBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(plusBtnLink));
        Assert.assertTrue("Artists link is not present in the Music panel", plusBtnElement.isDisplayed());
    }

    //Scenario: Playlists panel should include: Favorites, Recently played, smart and user's created playlists
    @Then("Playlist panel includes Favorites")
    public void playlistPanelIncludesFavorites() {
        By favoritesPageLink = By.cssSelector("#playlists > ul > li.playlist.favorites > a");
        WebElement favoritesPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(favoritesPageLink));
        Assert.assertTrue("Artists link is not present in the Music panel", favoritesPageElement.isDisplayed());
    }


    @And("Playlist panel includes Recently Played")
    public void playlistPanelIncludesRecentlyPlayed() {
        By recentlyPlayedPageLink = By.cssSelector("#playlists > ul > li.playlist.recently-played > a");
        WebElement recentlyPlayedPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(recentlyPlayedPageLink));
        Assert.assertTrue("Artists link is not present in the Music panel", recentlyPlayedPageElement.isDisplayed());
    }

    @And("Playlist panel includes Smart")
    public void playlistPanelIncludesSmart() {
        By smartPlaylistPageLink = By.cssSelector("#playlists > ul > li.playlist.playlist.smart > a");
        WebElement smartPlaylistPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(smartPlaylistPageLink));
        Assert.assertTrue("Artists link is not present in the Music panel", smartPlaylistPageElement.isDisplayed());
    }

    @And("Playlist panel includes User Created")
    public void playlistPanelIncludesUserCreated() {
        By userCreatedPlaylistPageLink = By.cssSelector("#playlists > ul > li:nth-child(4)");
        WebElement userCreatedPlaylistPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userCreatedPlaylistPageLink));
        Assert.assertTrue("Artists link is not present in the Music panel", userCreatedPlaylistPageElement.isDisplayed());
    }

    //Scenario: Profile link, Logout and About Koel icons should be displayed and linked to correct pages.
    @And("Profile link is displayed")
    public WebElement profileLinkIsDisplayed() {
        By profileIconLink = By.cssSelector("#userBadge > a.view-profile");
        WebElement profileIconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLink));
        Assert.assertTrue("Profile link is not present in the Music panel", profileIconElement.isDisplayed());
        return profileIconElement;
    }

    @And("User selects profile button")
    public void userSelectsProfileButton() {
        WebElement profileLink = profileLinkIsDisplayed();
        profileLink.click();
    }
    @And("User is taken to profile")
    public void userIsTakenToProfile() {
        By profileHeaderSelector = By.cssSelector("#profileWrapper > header > div.heading-wrapper > h1");
        try {
            WebElement profileHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeaderSelector));
            String actualPageName = profileHeaderElement.getText().trim();
            String expectedPageName = "Profile & Preferences";

            Assert.assertEquals("User is not taken to the Profile page", expectedPageName, actualPageName);
        } catch (TimeoutException e) {
            Assert.fail("User is not taken to the Profile page");
        }
    }
    @And("Home tab is displayed")
    public WebElement homeTabIsDisplayed() {
            By homeTabLink = By.cssSelector("#sidebar > section.music > ul > li:nth-child(1) > a");
            WebElement homeTabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homeTabLink));
            Assert.assertTrue("Home tab is not present in the side panel", homeTabElement.isDisplayed());
            return homeTabElement;
    }
    @And("User selects home tab")
    public void userSelectsHomeTab(){
            WebElement homeLink = homeTabIsDisplayed();
            homeLink.click();
        }
    @And("User is taken to home page")
    public void userIsTakenToHomePage() {
        By avatarImageSelector = By.cssSelector("img.avatar");

        try {
            WebElement avatarImageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(avatarImageSelector));
            Assert.assertTrue("User is not taken to the Home page (avatar image not found)", avatarImageElement.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("User is not taken to the Home page (avatar image not found)");
    }

}

    @And("AboutKoel icon is displayed")
    public WebElement aboutkoelIconIsDisplayed() {
        By aboutkeolIconLink = By.cssSelector("#mainHeader > div.header-right > button > i");
        WebElement aboutkoelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutkeolIconLink));
        Assert.assertTrue("AboutKoel icon is not present in the side panel", aboutkoelElement.isDisplayed());
        return aboutkoelElement;
    }

    @And("User selects About Koel Icon")
    public void userSelectsAboutKoelIcon() {
        WebElement aboutkeolIconLink = aboutkoelIconIsDisplayed();
        aboutkeolIconLink.click();
    }
    @And("AboutKoel page is displayed")
    public WebElement aboutkoelPageIsDisplayed() {
        By aboutkeolPageLink = By.cssSelector("#mainWrapper > div > div > header > h1");
        WebElement aboutkoelPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutkeolPageLink));
        Assert.assertTrue("AboutKoel icon is not present in the side panel", aboutkoelPageElement.isDisplayed());
        return aboutkoelPageElement;
    }

    @And("User selects About Koel Close button")
    public void userSelectsAboutKoelCloseButton() {
        WebElement aboutkeolCloseBtn = aboutkoelPageIsDisplayed();
        aboutkeolCloseBtn.click();
    }

    @And("Logout Icon is displayed")
    public WebElement logoutIconIsDisplayed() {
        By logoutIconBtn = By.cssSelector("#userBadge > a.logout.control > i");
        WebElement logoutIconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutIconBtn));
        Assert.assertTrue("Logout icon is not present", logoutIconElement.isDisplayed());
        return logoutIconElement;
    }

    @And("User selects Logout Icons")
    public void userSelectsLogoutIcons() {
        // Find the logout button element using a CSS selector or any other locator strategy
        WebElement logoutIconBtn = driver.findElement(By.cssSelector("#userBadge > a.logout.control"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", logoutIconBtn);

    }

    @Then("User is taken to Login Page")
    public WebElement userIsTakenToLoginPage() {
        By loginPageLink = By.cssSelector("#app > div > div > form > div.logo > img");
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageLink));
        Assert.assertTrue("AboutKoel icon is not present in the side panel", loginPageElement.isDisplayed());
        return loginPageElement;
    }


}


