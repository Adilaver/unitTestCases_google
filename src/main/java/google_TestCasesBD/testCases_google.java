package google_TestCasesBD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCases_google {

	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testHomePageLoads() {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void testSearchFunctionality() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium");
        searchInput.submit();
        Assert.assertTrue(driver.getTitle().contains("Selenium"));
    }

    @Test
    public void testSearchSuggestions() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium");
        WebElement firstSuggestion = driver.findElement(By.xpath("//ul[@role='listbox']//li[1]"));
        Assert.assertTrue(firstSuggestion.getText().contains("Selenium"));
    }

    @Test
    public void testImageSearch() {
        driver.get("https://www.google.com");
        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        imagesLink.click();
        Assert.assertEquals(driver.getTitle(), "Google Images");
    }

    @Test
    public void testGoogleAppsMenu() {
        driver.get("https://www.google.com");
        WebElement googleAppsButton = driver.findElement(By.xpath("//div[@id='gbwa']//a[@class='gb_D']"));
        googleAppsButton.click();
        WebElement mapsLink = driver.findElement(By.xpath("//div[@class='gb_ea']//a[@data-pid='8']"));
        Assert.assertEquals(mapsLink.getText(), "Maps");
    }

    @Test
    public void testSignInButton() {
        driver.get("https://www.google.com");
        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        Assert.assertTrue(signInButton.isDisplayed());
    }

    @Test
    public void testLanguageSettings() {
        driver.get("https://www.google.com");
        WebElement settingsLink = driver.findElement(By.linkText("Settings"));
        settingsLink.click();
        WebElement searchLanguage = driver.findElement(By.xpath("//div[@id='sLs']//a"));
        Assert.assertEquals(searchLanguage.getText(), "Search settings");
    }

    @Test
    public void testAdvertisingLink() {
        driver.get("https://www.google.com");
        WebElement advertisingLink = driver.findElement(By.linkText("Advertising"));
        advertisingLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("services.google.com/ads"));
    }

    @Test
    public void testPrivacyLink() {
        driver.get("https://www.google.com");
        WebElement privacyLink = driver.findElement(By.linkText("Privacy"));
        privacyLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("policies.google.com/privacy"));
    }

    @Test
    public void testTermsLink() {
        driver.get("https://www.google.com");
        WebElement termsLink = driver.findElement(By.linkText("Terms"));
        termsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("policies.google.com/terms"));
    }

}
