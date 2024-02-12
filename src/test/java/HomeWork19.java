import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Class 19 Playlist.\"";

        //Navigate to Koel
        //Login with Name and Password
        provideEmail("jason.fenstermaker1234@testpro.io");
        providePassword("Testpro.io2");
        loginToKoel();
        //Select a playlist to delete
        clickClass19Playlist();
        //Select red "X Playlist" Button
        clickXPlaystlist();
        //Assertion Verify "Deleted playlist {playlist name}
        //Assertion
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMsg);


    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();

    }

    public void clickClass19Playlist() {
        WebElement class19Playlist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        class19Playlist.click();
    }

    public void clickXPlaystlist() {
        WebElement xPlayList = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button"));
        xPlayList.click();
    }



}
