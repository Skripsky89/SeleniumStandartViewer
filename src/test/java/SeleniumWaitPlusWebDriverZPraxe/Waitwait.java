package SeleniumWaitPlusWebDriverZPraxe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Waitwait {
    private final String Url_Base ="http://localhost/";
    public WebDriver driver;
    public String getUrl_Base(){return Url_Base;}

   @Before
   public void openBase(){
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
       driver = new ChromeDriver();
   }
    @Test
    public void waitForInputText(){

        WebDriver driver = new ChromeDriver();



    }
    @After
    public void close(){
        driver.close();
        driver.quit();
    }
}
