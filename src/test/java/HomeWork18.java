import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        //Login
        //navigateToPage();
        provideEmail("jason.fenstermaker1234@testpro.io");
        providePassword("Testpro.io2");
        loginToKoel();
        Thread.sleep(5000);
        //click on Play
        clickPlay();
        Thread.sleep(5000);
        //Assertion
        Assert.assertTrue(isSongPlaying());

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
