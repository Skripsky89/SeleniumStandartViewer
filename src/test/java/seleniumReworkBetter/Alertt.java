package seleniumReworkBetter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertt {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/redalert.php";


    @ Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        driver.findElement(By.id("alert1")).click();
        Alert alert =driver.switchTo().alert();
        alert.accept();
        //Kirov reporting
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());


        driver.findElement(By.id("alert2")).click();
        Alert alertA =driver.switchTo().alert();
        //Jeden Second alert
        Assert.assertEquals("Second alert!",alertA.getText());
        System.out.println(alertA.getText());
        alertA.dismiss();

        // negativ
        Assert.assertEquals("Negative",driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());

        driver.findElement(By.id("alert3")).click();
        Alert alertB =driver.switchTo().alert();
        alertB.sendKeys("Yuri");
        alert.accept();
        //Celá hláška
        Assert.assertEquals("Waiting for your commands Yuri",driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());
        //Obsahuje slovo Yuri
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText().contains("Yuri"));
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/h1")).getText());

    }

    @After
    public void tearDone() {

        driver.quit();
    }
}