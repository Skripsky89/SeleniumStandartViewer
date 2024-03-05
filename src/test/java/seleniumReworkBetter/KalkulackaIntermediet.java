package seleniumReworkBetter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class KalkulackaIntermediet {



    private WebDriver driver;
    private final String Base_Url = "http://localhost/kalkulacka.php";


    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Base_Url);


    }
    @Test
    public void testSun (){
        checksSum("5","2","7");
        checksSum("7","3","10");
        checksSum("87","29","116");
        checksSum("72","37","109");
        checksSum("79","39","118");

    }
    @Test
    public void testDeduct(){
        checksDeduct("5","2","3");
        checksDeduct("7","3","4");
        checksDeduct("87","29","58");
        checksDeduct("72","37","35");
        checksDeduct("79","39","40");
    }
    @Test
    public void Nesmysl(){
        vstupy("7","2");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());
    }
    @Test
    public void Nesmysl2(){
        vstupy("gost","zombie");
        driver.findElement(By.id("count")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
                .getAttribute("class").contains("has-error"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
                .getAttribute("class").contains("has-error"));
    }

    private void checksSum(String s1, String s2,String expected) {
        driver.findElement(org.openqa.selenium.By.id("firstInput")).clear();
        driver.findElement(org.openqa.selenium.By.id("firstInput")).sendKeys(s1);
        driver.findElement(org.openqa.selenium.By.id("secondInput")).clear();
        driver.findElement(org.openqa.selenium.By.id("secondInput")).sendKeys(s2);
        driver.findElement(org.openqa.selenium.By.id("count")).click();
        Assert.assertEquals(expected,driver.findElement(By.id("result")).getText());
    }
    private void checksDeduct(String s11, String s22,String expecteded) {
        driver.findElement(org.openqa.selenium.By.id("firstInput")).clear();
        driver.findElement(org.openqa.selenium.By.id("firstInput")).sendKeys(s11);
        driver.findElement(org.openqa.selenium.By.id("secondInput")).clear();
        driver.findElement(org.openqa.selenium.By.id("secondInput")).sendKeys(s22);
        driver.findElement(org.openqa.selenium.By.id("deduct")).click();
        Assert.assertEquals(expecteded,driver.findElement(By.id("result")).getText());
    }
    private void vstupy(String firstInput,String secondtInput){
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(secondtInput);

    }

    @After
    public void tearDone () throws java.io.IOException {

        driver.close();
        driver.quit();
    }
}