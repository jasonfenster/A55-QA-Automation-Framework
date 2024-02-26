package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By firstSongInSongsList = By.cssSelector(".all-songs tr.song.item:nth-child(1)");

    By playOption = By.cssSelector("li.playback");

    public void contextClickFirstSong(){
        WebElement firstSongElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#songsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title")));
        //findElement(firstSongInSongsList);
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlay() {
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    findElement(playOption).click();
    }

}
