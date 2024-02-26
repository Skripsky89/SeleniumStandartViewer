package seleniumReworkBetter;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class RRadioButton {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zenaalebomuz.php";


    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void test (){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@value= 'wurst']")).click();
        driver.findElement(By.xpath("//input[@value= 'wurst']")).getText();
        System.out.println( driver.findElement(By.xpath("//input[@value= 'wurst']")).getText());
    }

    @After
    public void tearDone (){

        driver.quit();

    }


}