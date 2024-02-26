package seleniumReworkBetter;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class SelectTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/vybersi.php";

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

        new Select(driver.findElement(By.className("form-control"))).selectByIndex(1);
        System.out.println("Vybral jsi charmandra");
        new Select(driver.findElement(By.className("form-control"))).selectByValue("02");
        System.out.println("Vybral jsi bulbasaura");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Geodude");
        System.out.println("Vybral jsi geodude");
        Assert.assertTrue(driver.findElement(By.xpath("//div/h3")).getText().contains("Geodude"));
    }


}