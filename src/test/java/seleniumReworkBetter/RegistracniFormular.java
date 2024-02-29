package seleniumReworkBetter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
public class RegistracniFormular {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";
    private String Email ="nova@gmail.com";
    private String Jmeno = "Novak";
    private String Prijmení = "Karel";
    private String Heslo = "fafawrf2378fd";
    private String Reheslo = "fafawrf2378fd";

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);

    }
    @Test
    public void testCheckbox()  {

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));
        SomRobot.click();
        Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    } @Test
    public void testName (){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

        Pjmeno.sendKeys("");
        SomRobot.click();

        Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    } @Test
    public void testEmail (){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

        Pemail.sendKeys(Email);
        SomRobot.click();
        Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    } @Test
    public void testPrijmeni (){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

        Pprimeni.sendKeys(Prijmení);
        SomRobot.click();
        Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    } @Test
    public void testEmailVelkaPismo (){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

        Pjmeno.sendKeys(Jmeno);
        Pprimeni.sendKeys(Prijmení);
        Pemail.sendKeys("NOVA@gmail.com");
        Pheslo.sendKeys(Heslo);
        Preheslo.sendKeys(Reheslo);
        SomRobot.click();
        Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia uspesna!" );

    } @Test
    public void testRuzneHela (){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

        Pheslo.sendKeys(Heslo);
        Preheslo.sendKeys("fjaio");
        SomRobot.click();
        Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );

    } @Test
    public void testHappy (){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

        Pjmeno.sendKeys(Jmeno);
        Pprimeni.sendKeys(Prijmení);
        Pemail.sendKeys(Email);
        Pheslo.sendKeys(Heslo);
        Preheslo.sendKeys(Reheslo);
        SomRobot.click();
        Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia uspesna!" );

    }
     @Test
    public void testSpatnyEmailBezPripony(){

        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmeno = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement Pprimeni = driver.findElement(By.xpath("//input[@name='surname']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='password-repeat']"));
        WebElement SomRobot = driver.findElement(By.id("checkbox"));
        WebElement Pregistrace = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']"));

         Pjmeno.sendKeys(Jmeno);
         Pprimeni.sendKeys(Prijmení);
         Pemail.sendKeys("NOVA@gmail");
         Pheslo.sendKeys(Heslo);
         Preheslo.sendKeys(Reheslo);
         SomRobot.click();
         Pregistrace.click();

        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Registracia uspesna!" );

    }

    @After
    public void tearDone (){
        driver.close();
        driver.quit();

    }
}