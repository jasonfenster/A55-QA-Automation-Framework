
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static org.bouncycastle.cms.RecipientId.password;

public class BaseTest {
   public ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public WebDriver driver;

    public WebDriverWait wait;

    public Wait<WebDriver> fluentWait;

    public Actions actions;


    public void navigateToPage(String url) {
        driver.get(url);
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        driver = pickBrowser(System.getProperty("browser"));
        //Implicate Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicate Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);

        navigateToPage(baseURL);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.40.46:4444/";

        switch (browser) {
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup(); // Move this line here
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String hubUrl = "https://hub.lambdatest.com/wd/hub";
        String hub= "@hub.lambdaTest.com/wd/hub";
        String userName = "jason.fenstermaker";
        String authKey = "0NZwkk1QmmSd7zNRFTjN1hTmEibBl7LLzqmYNT87IoxLbVt5W4";

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platform", "Windows10");
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("version", "121.0");
//        capabilities.setCapability("resolution", "12024x768");
//        capabilities.setCapability("build", "TestNG with Java");
//        capabilities.setCapability("name", BaseTest.class.getName());
//        capabilities.setCapability("plugin", "java-testNG");


        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("122.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", authKey);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        String hubURL = "https://" + "jason.fenstermaker" + ":" + "0NZwkk1QmmSd7zNRFTjN1hTmEibBl7LLzqmYNT87IoxLbVt5W4" + "@hub.lambdatest.com/wd/hub";

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
        //return new RemoteWebDriver(new URL(hubUrl), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }


    //public void closeBrowser(){
      //  driver.quit();
    //}

    public void loginToKoel(){
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginBtn.click();

    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    //public void navigateToPage(String url) {
        //driver.get(url);
    }




    //@BeforeSuite
    //static void setupClass() {
    //WebDriverManager.chromedriver().setup();
    //note for me: test ran parallel/successful after clearing cache 2/26/23







