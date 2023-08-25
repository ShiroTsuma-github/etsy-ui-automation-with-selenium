package pl.globallogic.etsy.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SearchFeatureVerificationTest {
    @Test
public void shouldSearchForValidQuery() {
        //given
        WebDriver driver = new ChromeDriver();

        String validQuery = "Leather bag";
        driver.get("https://www.etsy.com");
        WebElement acceptButton = driver.findElement(By.xpath("//button[@data-gdpr-single-choice-accept='true']"));
        acceptButton.click();

        WebElement searchInput = driver.findElement(By.id("global-enhancements-search-query"));
        searchInput.sendKeys(validQuery);
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-id='gnav-search-submit-button']"));
        searchButton.click();

        //when
        String pageTitle = driver.getTitle();

        //then
        Assert.assertTrue(pageTitle.contains(validQuery));
        driver.quit();
    }


    @Test
        public void shouldSearchForInvalidQuery() {
            //given
            WebDriver driver = new ChromeDriver();

            String invalidQuery = "fijosjd;7677566576757566dfskjddfsnfdsnjfsdkfdsl";
            driver.get("https://www.etsy.com");
            WebElement acceptButton = driver.findElement(By.xpath("//button[@data-gdpr-single-choice-accept='true']"));
            acceptButton.click();

            WebElement searchInput = driver.findElement(By.id("global-enhancements-search-query"));
            searchInput.sendKeys(invalidQuery);
            WebElement searchButton = driver.findElement(By.xpath("//button[@data-id='gnav-search-submit-button']"));
            searchButton.click();

            //when
            boolean exists = !driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[10]/div[2]/div[9]/div[4]/p")).isEmpty();
//            Assert.assertTrue(exists);
            String text = driver.findElement(By.xpath("/html/body/main/div[1]/div/div/div/div[1]/div[4]/p")).getText();
            Assert.assertTrue(text.contains("any results for"));

            driver.quit();
    }

}
