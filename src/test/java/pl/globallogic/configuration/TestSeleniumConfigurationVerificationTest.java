package pl.globallogic.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSeleniumConfigurationVerificationTest {

    @Test
    public void shouldNavigateToGoogleAndVerifyPageTitle() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String pageTitle = driver.getTitle();
        driver.quit();
        Assert.assertEquals(pageTitle, "Google");


    }
}
