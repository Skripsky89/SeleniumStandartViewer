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
public class BackForwardRefresh {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

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
        String email ="nova@gmail.com";
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();
        driver.navigate().back();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        //System.out.println(driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
        Assert.assertEquals(email,driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
        driver.navigate().forward();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());
        driver.navigate().back();
        driver.navigate().refresh();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        //System.out.println(driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
        Assert.assertEquals("",driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
    }


}