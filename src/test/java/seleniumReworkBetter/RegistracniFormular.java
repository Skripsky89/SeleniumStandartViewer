package seleniumReworkBetter;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistracniFormular {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";
    private final String Email ="nova@gmail.com";
    private final String Jmeno = "Novak";
    private final String Prijmeni = "Karel";
    private final String Heslo = "fafawrf2378fd";
    private final String Reheslo = "fafawrf2378fd";

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);

    }
    @Test
    public void testCheckbox()  {


        seleniumReworkBetter.RegistracniFormular.Result result = getResult();
        result.SomRobot.click();
        result.Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    }
    @Test
    public void testName (){


        seleniumReworkBetter.RegistracniFormular.Result result = getResult();

        result.Pjmeno.sendKeys(Jmeno);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    }
    @Test
    public void testEmail (){

        seleniumReworkBetter.RegistracniFormular.Result result = getResult();

        result.Pemail.sendKeys(Email);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    }
    @Test
    public void testPrijmeni (){

        seleniumReworkBetter.RegistracniFormular.Result result = getResult();

        result.Pprimeni.sendKeys(Prijmeni);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    }
    @Test
    public void testEmailVelkaPismo (){

        seleniumReworkBetter.RegistracniFormular.Result result = getResult();

        result.Pjmeno.sendKeys(Jmeno);
        result.Pprimeni.sendKeys(Prijmeni);
        result.Pemail.sendKeys("NOVA@gmail.com");
        result.Pheslo.sendKeys(Heslo);
        result.Preheslo.sendKeys(Reheslo);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'success')]"));
        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia uspesna!" );

    }
    @Test
    public void testRuzneHela (){


        seleniumReworkBetter.RegistracniFormular.Result result = getResult();

        result.Pheslo.sendKeys(Heslo);
        result.Preheslo.sendKeys("fjaio");
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    } @Test
    public void testHappy (){

        seleniumReworkBetter.RegistracniFormular.Result result = getResult();
        result.Pjmeno().sendKeys(Jmeno);
        result.Pprimeni().sendKeys(Prijmeni);
        result.Pemail().sendKeys("NOVA@gmail");
        result.Pheslo().sendKeys(Heslo);
        result.Preheslo().sendKeys(Reheslo);
        result.SomRobot().click();
        result.Pregistrace().click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia uspesna!" );

    }
     @Test
    public void testSpatnyEmailBezPripony() throws InterruptedException, IOException {


        seleniumReworkBetter.RegistracniFormular.Result result = getResult();

         result.Pjmeno().sendKeys(Jmeno);
         result.Pprimeni().sendKeys(Prijmeni);
         result.Pemail().sendKeys("NOVA@gmail");
         result.Pheslo().sendKeys(Heslo);
         result.Preheslo().sendKeys(Reheslo);
         result.SomRobot().click();
         result.Pregistrace().click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia uspesna!" );
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(scrFile, new File("C:\\Users\\Michal\\AppData\\Local\\Temp\\screenshot.png"));

    }

    private seleniumReworkBetter.RegistracniFormular.Result getResult() {
        org.openqa.selenium.WebElement Pemail = driver.findElement(org.openqa.selenium.By.xpath("//input[@name='email']"));
        org.openqa.selenium.WebElement Pjmeno = driver.findElement(org.openqa.selenium.By.xpath("//input[@name='name']"));
        org.openqa.selenium.WebElement Pprimeni = driver.findElement(org.openqa.selenium.By.xpath("//input[@name='surname']"));
        org.openqa.selenium.WebElement Pheslo = driver.findElement(org.openqa.selenium.By.xpath("//input[@name='password']"));
        org.openqa.selenium.WebElement Preheslo = driver.findElement(org.openqa.selenium.By.xpath("//input[@name='password-repeat']"));
        org.openqa.selenium.WebElement SomRobot = driver.findElement(org.openqa.selenium.By.id("checkbox"));
        org.openqa.selenium.WebElement Pregistrace = driver.findElement(org.openqa.selenium.By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));
        seleniumReworkBetter.RegistracniFormular.Result sklad = new seleniumReworkBetter.RegistracniFormular.Result(Pemail, Pjmeno, Pprimeni, Pheslo, Preheslo, SomRobot, Pregistrace);
        return sklad;
    }

    private record Result(WebElement Pemail,WebElement Pjmeno,WebElement Pprimeni, WebElement Pheslo, WebElement Preheslo, WebElement SomRobot,WebElement Pregistrace) {
    }

    @After
    public void tearDone (){

        driver.close();
        driver.quit();

    }
}