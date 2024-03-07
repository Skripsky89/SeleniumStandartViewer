package SeleniumWaitPlusWebDriverZPraxe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bleur {
    private final String Url_Base ="http://localhost/";
    private WebDriver driver ;
    public final String getUrl_Base(){return Url_Base;}
        @Before
        public void setUp () {
            String setProperty = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(getUrl_Base() +"waitforit.php");
            driver.manage().window().maximize();

        }
        @Test

        public void testBluer(){

            driver.findElement(By.id("waitForBlur")).sendKeys("Ahoj co se stane");
            // dvě možné cesty kliknu na jinačí ikonu (lehčí, ale ne vždy funkční)
            //driver.findElement(By.id("startWaitForText")).click();
            ((JavascriptExecutor)driver).executeScript("arguments[0].blur()",driver.findElement(By.id("waitForBlur")));
            new WebDriverWait(driver,10).
                   until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForBlur")),"value","blured!"));
        }
    @Test
    public void testClick(){
        driver.findElement(By.id("waitForBlur")).sendKeys("Ahoj co se stane");
        //nefunguje .click(), ale funguje .focus()
        ((JavascriptExecutor)driver).executeScript("arguments[0].focus()",driver.findElement(By.id("startWaitForText")));
        // další možnost, ale ne ideální
        // driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver,10).
                until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForBlur")),"value","blured!"));
    }

        @After
    public void finish(){
       driver.close();
        }


    }



