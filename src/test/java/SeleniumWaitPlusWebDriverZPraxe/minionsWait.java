package SeleniumWaitPlusWebDriverZPraxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


public class minionsWait extends Waitwait {
    @Before
    public void setUp () {
        driver.get(getUrl_Base() +"waitforit.php");

    }
    @Test

public void waitMinions(){
        int numberOfMinions = 6;
    driver.findElement(By.xpath("//div/ul/li/a[contains(@href,'minions.php')]")).click();
    driver.findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(numberOfMinions));
    driver.findElement(By.xpath("//button[@class='btn btn-warning btn-block']")).click();

    new WebDriverWait(driver,numberOfMinions+10)
            .withMessage("Timeout waitingfor number of minions to be "+ numberOfMinions)
            .until(org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"),numberOfMinions));
    Assert.assertEquals(numberOfMinions, driver.findElement(By.xpath("//div[@class='minions']//img")).getSize());

}
}
