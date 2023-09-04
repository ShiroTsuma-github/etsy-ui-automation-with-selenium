package pl.globallogic.etsy.features;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SearchFeatureVerificationTest {

    @Test
    public void shouldDisplaySearchResultForValidQuery() {
        WebDriver driver = new ChromeDriver();
        String validQuery = "leather bag";

        driver.get("https://www.etsy.com");

        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button"));
        acceptButton.click();

        WebElement searchField = driver.findElement(By.id("global-enhancements-search-query"));
        searchField.sendKeys(validQuery);
        searchField.sendKeys(Keys.ENTER);

        String actualPageTitle = driver.getTitle().toLowerCase();
        driver.quit();

        Assert.assertTrue(actualPageTitle.contains(validQuery));
    }

    @Test
    public void shouldDisplayNotFoundPageForInvalidQuery() {
        WebDriver driver = new ChromeDriver();
        String queryForInvalidResultPage = "asdasdf1239131r09iuq9wjd9adu10id10uf13rujq";

        driver.get("https://etsy.com");
        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button"));
        acceptButton.click();

        WebElement searchField = driver.findElement(By.id("global-enhancements-search-query"));
        searchField.sendKeys(queryForInvalidResultPage + Keys.ENTER);

        WebElement invalidResultMessageHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[1]/div/p"));

        String invalidResultMessage = invalidResultMessageHeading.getText();
        Assert.assertTrue(invalidResultMessage.contains(queryForInvalidResultPage));
    }

}
