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
public class DynamickeNacitani {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zjavenie.php";


    @ Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void test() throws InterruptedException {
        driver.get(BASE_URL);
        driver.findElement(By.id("showHim")).click();
        //Thread.sleep(9000); pevně nastavený čas

        new WebDriverWait(driver,9).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='brano']")));
        driver.findElement(By.xpath("//img[@class='brano']"));

    }

    @After
    public void tearDone() {

        driver.quit();
    }
}