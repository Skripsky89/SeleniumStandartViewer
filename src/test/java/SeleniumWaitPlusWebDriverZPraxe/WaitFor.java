package SeleniumWaitPlusWebDriverZPraxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor extends Waitwait {

    @Before
    public void setUp () {
        driver.get(getUrl_Base() +"waitforit.php");
    }


    @Test
    public void waitForInputText () {


        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));
        System.out.println(driver.findElement(By.id("waitForTextInput") ).getAttribute("value"));

    }
    @Test
//div/ul/li/a[contains(@href,'minions.php')]
    public void waitForClass(){
        driver.findElement(By.id("startWaitForProperty")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.attributeContains(By.id("waitForProperty"),"class","error"));
        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty") ).isEnabled());
    }

}