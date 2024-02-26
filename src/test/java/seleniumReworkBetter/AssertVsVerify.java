package seleniumReworkBetter;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver.Timeouts;

import static org.junit.Assert.fail;

public class AssertVsVerify {

    private WebDriver driver;
    private StringBuffer verificationErrors =new StringBuffer();
    private final String BASE_URL = "http://localhost/";


    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test (){

        driver.get(BASE_URL+"tabulka.php");
        Assert.assertEquals("1",driver.findElement(By.cssSelector("td")).getText());


        try{
            Assert.assertEquals("2",driver.findElement(By.xpath("//tr[2]/td")).getText());

        }
        catch(Error e){
            verificationErrors.append(e.toString());
        }
        System.out.println("Jde to dobře:");
    }

    @After
    public void tearDone (){
        String verificationErrorsString = verificationErrors.toString();
        driver.quit();
        if (!"".equals(verificationErrorsString)){
            fail(verificationErrorsString);
        }

    }

}