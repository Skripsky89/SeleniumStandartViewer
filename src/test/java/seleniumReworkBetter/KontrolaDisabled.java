package seleniumReworkBetter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;


public class KontrolaDisabled {

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
        System.out.println(driver.findElement(By.id("inputEmail3")).isEnabled());
    }


}