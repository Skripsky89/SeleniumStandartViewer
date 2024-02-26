package seleniumReworkBetter;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertFalse;


public class TableTest {

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

    System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
    int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());

    for (int i = 1; i < rows +1; i++ ) {
        driver.findElement(By.xpath("//table/tbody/tr["+i+"]"));
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText());
        Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText().isEmpty());
        //System.out.println(driver.findElement(By.xpath()));
        }

    }

    @After
    public void tearDone() {
        //driver.quit();

    }
}