import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    String newPlaylistName = "Sample Edited Playlist";

    @Test
    public void renamePlaylist() throws InterruptedException {


        String updatedPlaylistSuccessMsg = "Updated playlist \"Sample Edited Playlist.\"";

        //Log in to Koel
        provideEmail("jason.fenstermaker1234@testpro.io");
        providePassword("Testpro.io2");
        loginToKoel();

        //Double click
        doubleClickPlaylist();

        //Enter new name
        enterNewName();

        //assertion
        Assert.assertEquals(getRenamePlayListSuccessMsg(), updatedPlaylistSuccessMsg);


    }
    public String getRenamePlayListSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", playListInputField);
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
/*
    public void choosePlaylistByName(String playListName) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("a[contains(text(), '" + playListName"')]"))).click();

    }*/

}

