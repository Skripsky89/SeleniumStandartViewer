package seleniumReworkBetter;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class CklicMeTests {

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
        //System.out.println(driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("Nerestartoval se prohlížeč. Inicializuj:","0",(driver.findElement(By.id("clicks")).getText()));
        System.out.println("Počáteční hodnota je ve stanovené normě:");

        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(("Špatně přičetlo:"),String.valueOf(i),driver.findElement(By.id("clicks")).getText());
            System.out.println("Jen tak dál:");
            if (i == 1){
                Assert.assertEquals("klik",driver.findElement(By.className("description") ).getText());
            }


            if (i >= 2 && i<=4){
                Assert.assertEquals("kliky",driver.findElement(By.className("description") ).getText());
            }


            if (i > 4){
                Assert.assertEquals("klikov",driver.findElement(By.className("description") ).getText());
            }
            System.out.println( driver.findElement(By.className("description")).getText());

        }
        System.out.println("Cyklus se ti podařil:");



    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
