package seleniumReworkBetter;

import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestTable2 {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        java.util.List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        //System.out.println(rows);
        for (WebElement row : rows) {
            System.out.println(row.getText());

        }

    }

    @After
    public void tearDone() {
    //driver.quit();
    }
}