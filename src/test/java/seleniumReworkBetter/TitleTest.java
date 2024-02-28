package seleniumReworkBetter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class TitleTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost";



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
    @After
    public void tearDone ()throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(screenshot,new File("C://tmp//screeshots.pgn"));
        System.out.println(driver.getPageSource());
        driver.quit();

    }

}