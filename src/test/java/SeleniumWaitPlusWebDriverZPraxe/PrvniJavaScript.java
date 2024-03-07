package SeleniumWaitPlusWebDriverZPraxe;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrvniJavaScript  {
    private final String Url_Base ="http://localhost/";
    private  WebDriver driver ;
    //public WebDriver getWebDriver(){return driver;}
    public String getUrl_Base(){return Url_Base;}

    @Before
    public void setUp() {
        String setProperty = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(getUrl_Base() +"tabulka.php");

    }

    @Test

    public void waitForIt() {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
        for (WebElement row : rows) {
            if (row.getText().contains("Florian")) {
                hightLight(row);
                System.out.println(row.getText());
                new org.openqa.selenium.support.ui.WebDriverWait(driver, 5);

            }
        }
    }

    private void hightLight(WebElement row) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style. border='3px solid red'", row);
    }

    @After
    public void close() {
       // driver.close();
       // driver.quit();

    }
}
