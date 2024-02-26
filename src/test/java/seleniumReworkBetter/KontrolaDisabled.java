package seleniumReworkBetter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import  org.junit.Assert;


public class KontrolaDisabled {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/nemenne.php";

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
        //System.out.println(driver.findElement(By.id("inputEmail3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("inputEmail3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        //Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());
        //for (int i=1; i<4;i++)
        //System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option["+i+"]")).isEnabled());
            Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
            Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
            Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());
            Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).isEnabled());
            Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).isEnabled());
    }


}