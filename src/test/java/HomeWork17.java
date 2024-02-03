
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Homework 17.\"";

        //Navigate to Koel
        //navigateToPage("https://qa.koel.app/");
        //Enter Credentials
        provideEmail("jason.fenstermaker1234@testpro.io");
        providePassword("Testpro.io2");
        loginToKoel();
        Thread.sleep(5000);
        //Search for song
        searchSong("You");
        Thread.sleep(5000);
        //Select "View All"
        clickViewAllBtn();
        Thread.sleep(5000);
        //Select first song
        clickFirstSong();
        Thread.sleep(5000);
        //Click "Add to all" button
        clickToAddAllBtn();
        Thread.sleep(5000);
        //Add to "Homework 17" playlist
        choosePlaylist();
        Thread.sleep(5000);
        //Assertions
        Assert.assertTrue(getAddToPlaylistMessage().contains(expectedSongAddedMessage));
        Thread.sleep(5000);
    }
    public String getAddToPlaylistMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }



    public void choosePlaylist() {
        WebElement choosePlayList = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        choosePlayList.click();
    }

    public void clickToAddAllBtn() {
        WebElement clickAddToAllBtn = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        clickAddToAllBtn.click();
    }

    public void clickFirstSong() {
        WebElement clickFirstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        clickFirstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        clickViewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"searchForm\"]/input"));
        searchField.clear();
        searchField.sendKeys(songName);

    }
    }
