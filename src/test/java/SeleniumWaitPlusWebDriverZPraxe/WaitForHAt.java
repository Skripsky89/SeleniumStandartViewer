package SeleniumWaitPlusWebDriverZPraxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.*;

public class WaitForHAt  extends Waitwait{

    @Before
    public void setUp () {
        driver.get(getUrl_Base() +"prestige.php");
    }
    @Test

    public void waitForInputText () {


       driver.findElement(cssSelector("div.hat img")).click();
       new WebDriverWait(driver,5).
               until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.hat img")));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.hat img")).isDisplayed());

        new WebDriverWait(driver,5).
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.hat img")));
        Assert.assertTrue(driver.findElement(By.cssSelector("div.hat img")).isDisplayed());
    }

}

