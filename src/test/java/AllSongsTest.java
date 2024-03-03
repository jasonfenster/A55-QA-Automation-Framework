import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {
//    @Test
//    public void playSong() throws InterruptedException {
//        //Login
//        //navigateToPage();
//        provideEmail("jason.fenstermaker1234@testpro.io");
//        providePassword("Testpro.io2");
//        loginToKoel();
//
//        //click on Play
//        clickPlay();
//
//        //Assertion
//        Assert.assertTrue(isSongPlaying());
//
//    }

    @Test
    public void playSongHomeWork23() throws InterruptedException {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();

        homePage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlay();

        //Assertion
        Assert.assertTrue(allSongsPage.isSongPlaying());

    }

    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]"));
        WebElement playButton = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/span/span[2]"));
        playNextButton.click();
        playButton.click();
    }

    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div"));
        return soundBar.isDisplayed();
    }

}


