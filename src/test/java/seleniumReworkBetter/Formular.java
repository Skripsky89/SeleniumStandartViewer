package seleniumReworkBetter;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;

public class Formular {

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
    public void testCheckbox() throws  IOException  {


        seleniumReworkBetter.Formular.Result result = getResult();
        result.SomRobot.click();
        result.Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

        extracted();

    }
    @Test
    public void testName  ()throws  IOException {


        seleniumReworkBetter.Formular.Result result = getResult();

        result.Pjmeno.sendKeys(Jmeno);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

        extracted();

    }
    @Test
    public void testEmail ()throws  IOException {

        seleniumReworkBetter.Formular.Result result = getResult();

        result.Pemail.sendKeys(Email);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

        extracted();

    }
    @Test
    public void testPrijmeni ()throws  IOException {

        seleniumReworkBetter.Formular.Result result = getResult();

        result.Pprimeni.sendKeys(Prijmeni);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

        extracted();

    }
    @Test
    public void testEmailVelkaPismo ()throws IOException {

        seleniumReworkBetter.Formular.Result result = getResult();

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

        extracted();

    }
    @Test
    public void testRuzneHela ()throws IOException {


        seleniumReworkBetter.Formular.Result result = getResult();

        result.Pheslo.sendKeys(Heslo);
        result.Preheslo.sendKeys("fjaio");
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

        extracted();

    } @Test
    public void testHappy ()throws IOException {

        seleniumReworkBetter.Formular.Result result = getResult();
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

        extracted();

    }
     @Test
    public void testSpatnyEmailBezPripony() throws IOException {


        seleniumReworkBetter.Formular.Result result = getResult();

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

        extracted();

     }

    private void extracted() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Michal\\AppData\\Local\\Temp\\screenshot.png"));
    }

    private seleniumReworkBetter.Formular.Result getResult() {
        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));
        seleniumReworkBetter.Formular.Result sklad = new seleniumReworkBetter.Formular.Result(Pemail, Pjmeno, Pprimeni, Pheslo, Preheslo, SomRobot, Pregistrace);
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