package seleniumReworkBetter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class TitleTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @After
    public void tearDone (){

        driver.quit();

    }
    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void test (){
        driver.get(BASE_URL);
        //System.out.println(driver.getTitle());
        List<WebElement> pages = driver.findElements(By.xpath("//nav//ul/li/a"));
        List<String> pageUrls =new ArrayList<>();
        for (WebElement page:pages){
            //System.out.println(page.getAttribute("href"));
            pageUrls.add(page.getAttribute("href"));
        }

        for (String pageUrl : pageUrls){
            driver.get(pageUrl);
            String expectedTitle = pageUrl.substring(pageUrl.lastIndexOf("/")+1,pageUrl.indexOf(".php"));
            //System.out.println(expectedTitle);
           //System.out.println(driver.getTitle());
            Assert.assertTrue(driver.getTitle().contains(expectedTitle.substring(0,1).toUpperCase()+expectedTitle.substring(1)));
            //System.out.println(expectedTitle.substring(0,1).toUpperCase()+expectedTitle.substring(1));
        }

    }


}