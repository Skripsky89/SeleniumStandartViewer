package seleniumReworkBetter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class SSemafor {
private org.openqa.selenium.WebDriver driver;
private final String BASE_URL = "http://localhost/semafor.php";

@org.junit.After
public void tearDone (){

    driver.quit();

}
@org.junit.Before
public void setUp (){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
    driver = new org.openqa.selenium.chrome.ChromeDriver();

}
@org.junit.Test
public void test (){
    driver.get(BASE_URL);
    String expectedGreen = "rgba(10, 129, 0, 1)";
    String expectedRed ="rgba(205, 58, 63, 1)";
    String expectedYellow = "rgba(191, 111, 7, 1)";
    WebElement traficlight = driver.findElement(By.className("light"));
    String redColor = traficlight.getCssValue("background-color");
    //System.out.println(redColor);
    Assert.assertEquals(expectedRed,redColor);

    Actions actions = new Actions(driver);
    actions.moveToElement(traficlight).build().perform();
    String greenColor = traficlight.getCssValue("background-color");
    Assert.assertEquals(expectedGreen,greenColor);

    Actions action = new Actions(driver);
    action.clickAndHold(traficlight).build().perform();
    String yellowColor = traficlight.getCssValue("background-color");
    System.out.println(yellowColor);
    Assert.assertEquals(expectedYellow,yellowColor);
}


}