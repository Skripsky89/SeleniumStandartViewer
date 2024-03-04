package seleniumReworkBetter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KontrolaZobrazeniElenetu {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zjavenie.php";

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
        driver.findElement(By.id("showHim")).click();
       /* new WebDriverWait(driver,9).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='brano']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
        -----------------------------------------------------------------------------------------------------------------------
        visibility ceka jetli je element zobrazený v kode a presence kontroluje element v kodě
        ---------------------------------------------------------------------------------------------------------------------
        */

        new WebDriverWait(driver,9).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='brano']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());

    }


}