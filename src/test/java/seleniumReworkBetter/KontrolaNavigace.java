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
import java.util.ArrayList;

public class KontrolaNavigace {

    private WebDriver driver;
    private final String BASE_URL ="http://localhost/";

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver =new ChromeDriver();
    }
    @Test
    public void test(){

        String expectedClass = "activ";

        List<String> pages = new ArrayList<>();
        pages.add("vybersi");
        pages.add("tabulka");
        pages.add("zjavenie");

        for (String page :pages){
            driver.get(BASE_URL + "/" + page +".php");
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + ".php']"))
                    .getAttribute("class").contains("activ"));
        }


    }



    @After
    public void tearDown (){
        driver.quit();
    }

}
