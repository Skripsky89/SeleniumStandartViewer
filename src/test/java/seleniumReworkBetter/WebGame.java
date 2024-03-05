package seleniumReworkBetter;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebElement;

public class WebGame {

    private WebDriver driver;
    private final String Base_Url = "https://webgame.cz/wg/service.php?p=regplayer";
    private final String Email ="znnz@gmail.com";
    private final String JmenoVladce ="znnz";
    private final String Login = "Novak";
    private final String Heslo = "fafawrf2378fd";
    private final String Reheslo = "fafawrf2378fd";
    //Zde napište místo Michal umístění na vašem disku
    private String mojeSlozka ="C:\\Users\\Michal\\";
    Date datum = new Date();
    SimpleDateFormat formatdatum = new SimpleDateFormat("yyyy_MMMM_dd_HH_mm_ss");
    String currentDateTime = formatdatum.format(datum);

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Base_Url);



    }
    @Test
    public void testCheckbox() throws IOException {


        seleniumReworkBetter.WebGame.Result result = Wgresult();
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Nebylo zadáno přihlašovací jméno (login)!" );
        extracted(mojeSlozka+"KontrolatestCheckbox"+currentDateTime+".png");




    }
    @Test
    public void testName  ()throws IOException{


        seleniumReworkBetter.WebGame.Result rresult = Wgresult();
        rresult.Pjmeno.sendKeys(Login);
        rresult.SomRobot.click();
        rresult.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Přihlašovací jméno novak už existuje!" );
        extracted(mojeSlozka+"KontrolaTestName"+currentDateTime+".png");


    }
    @Test
    public void testEmail ()throws IOException{

        seleniumReworkBetter.WebGame.Result result = Wgresult();
        result.Pemail.sendKeys(Email);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Nebylo zadáno přihlašovací jméno (login)!" );
        extracted(mojeSlozka+"KontrolaTestEmail"+currentDateTime+".png");


    }
    @Test
    public void testPrijmeni ()throws IOException{

        seleniumReworkBetter.WebGame.Result result = Wgresult();
        result.Pjmenovladce().sendKeys(JmenoVladce);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Nebylo zadáno přihlašovací jméno (login)!" );
        extracted(mojeSlozka+"KontrolaTestPrijmeni"+currentDateTime+".png");


    }
    @Test
    public void testEmailVelkaPismo ()throws IOException{

        WebGame.Result result = Wgresult();
        result.Pjmeno.sendKeys(Login);
        result.Pjmenovladce.sendKeys(JmenoVladce);
        result.Pemail.sendKeys("ZNNZ@gmail.com");
        result.Pheslo.sendKeys(Heslo);
        result.Preheslo.sendKeys(Reheslo);
        result.SomRobot.click();
        result.Pregistrace.click();
        org.openqa.selenium.WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        org.junit.Assert.assertEquals(TextVysledku,"Přihlašovací jméno novak už existuje!" );
        extracted(mojeSlozka+"KontrolaTestEmailVelkaPismena"+currentDateTime+".png");


    }
    @Test
    public void testRuzneHela ()throws IOException{


        Result result = Wgresult();
        result.Pheslo.sendKeys(Heslo);
        result.Preheslo.sendKeys("fjaio");
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Nebylo zadáno přihlašovací jméno (login)!" );
        extracted(mojeSlozka+"KontrolaTestRuznaHesla"+currentDateTime+".png");


    } @Test
    public void testHappy ()throws IOException{

        seleniumReworkBetter.WebGame.Result result = Wgresult();
        result.Pjmeno().sendKeys(Login);
        result.Pjmenovladce().sendKeys(JmenoVladce);
        result.Pemail().sendKeys("NOVA@gmail");
        result.Pheslo().sendKeys(Heslo);
        result.Preheslo().sendKeys(Reheslo);
        result.SomRobot().click();
        result.Pregistrace().click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));

        String TextVysledku = Vysledek.getText();
        Assert.assertEquals(TextVysledku,"Přihlašovací jméno novak už existuje!" );
        extracted(mojeSlozka+"KontrolaTestHappy"+currentDateTime+"png");


    }
    @Test
    public void testSpatnyEmailBezPripony()throws IOException{
        seleniumReworkBetter.WebGame.Result result = Wgresult();
        result.Pjmeno().sendKeys(Login);
        result.Pjmenovladce().sendKeys(JmenoVladce);
        result.Pemail().sendKeys("NOVA@gmail");
        result.Pheslo().sendKeys(Heslo);
        result.Preheslo().sendKeys(Reheslo);
        result.SomRobot().click();
        result.Pregistrace().click();
        WebElement Vysledek = driver.findElement(By.xpath("//div/p[contains(@class, 'warn')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Přihlašovací jméno novak už existuje!" );
        extracted(mojeSlozka+"KontrolaTestSpatnyEmailBezPripony"+currentDateTime+".png");



    }

    private seleniumReworkBetter.WebGame.Result Wgresult() {
        WebElement Pemail = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Pjmenovladce = driver.findElement(By.xpath("//input[@name='pname0']"));
        WebElement Plogin = driver.findElement(By.xpath("//input[@name='login']"));
        WebElement Pheslo = driver.findElement(By.xpath("//input[@name='pasw0']"));
        WebElement Preheslo = driver.findElement(By.xpath("//input[@name='pasw1']"));
        WebElement SomRobot = driver.findElement(By.id("terms_consent"));
        WebElement Pregistrace = driver.findElement(By.xpath("//input[@name='action']"));
        seleniumReworkBetter.WebGame.Result skladd = new seleniumReworkBetter.WebGame.Result((Pemail), Plogin, Pjmenovladce, Pheslo, Preheslo, SomRobot, Pregistrace);
        return skladd;
    }


    private record Result(WebElement Pemail,WebElement Pjmeno,WebElement Pjmenovladce, WebElement Pheslo, WebElement Preheslo, WebElement SomRobot,WebElement Pregistrace) {
    }
    private void extracted(String VarPath) throws IOException {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(VarPath));

    }
    @After
    public void tearDone () throws IOException {

        driver.close();
        driver.quit();

    }
}