package seleniumReworkBetter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
public class KontrolaBarvy {
    private WebDriver driver;
    private final String BASE_URL ="http://localhost/stroopeffect.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
       /* List<WebElement> H_1 = driver.findElements(By.xpath("//div[contains(@class,'colours')]/h1"));
        for (WebElement title: H_1){
            System.out.println(title.getText());
            System.out.println(title.getCssValue("color"));
            System.out.println(title.getCssValue("font-size"));
            String hexColor = Color.fromString(title.getCssValue("color")).asHex();
            System.out.println(hexColor);
            System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1")).getText());*/
            // System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getText());
            //System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color"));
        String rgb = driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1")).getCssValue("color");
        String hexColor = Color.fromString(rgb).asHex();
        Assert.assertEquals(hexColor, "#ff0e0e");
    }

    @After
    public void tearDown(){
    driver.quit();
    }

}
