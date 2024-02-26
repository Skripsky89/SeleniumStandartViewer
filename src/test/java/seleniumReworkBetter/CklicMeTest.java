package seleniumReworkBetter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CklicMeTest {

    private WebDriver driver;
    private final String BASE_URL ="http://localhost/clickmebaby.php";

    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void Test(){
        driver.get(BASE_URL);
        //System.out.println(driver.findElement(org.openqa.selenium.By.id("clicks")).getText());
        Assert.assertEquals("Nerestartoval se prohlížeč. Inicializuj:","0",(driver.findElement(org.openqa.selenium.By.id("clicks")).getText()));
        System.out.println("Počáteční hodnota je ve stanovené normě:");
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals(("Špatně přičetlo:"),"1",driver.findElement(By.id("clicks")).getText());
        System.out.println("Jen tak dál:");
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals(("Špatně přičetlo:"),"2",driver.findElement(By.id("clicks")).getText());
        System.out.println("Jen tak dál:");
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals(("Špatně přičetlo:"),"3",driver.findElement(By.id("clicks")).getText());
        System.out.println("Jen tak dál:");
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals(("Špatně přičetlo:"),"4",driver.findElement(By.id("clicks")).getText());
        System.out.println("Jen tak dál:");
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals(("Špatně přičetlo:"),"5",driver.findElement(By.id("clicks")).getText());
        System.out.println("Jen tak dál:");

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
