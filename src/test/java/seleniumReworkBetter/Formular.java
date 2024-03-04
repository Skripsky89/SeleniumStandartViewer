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

public class Formular {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";
    private final String Email ="nova@gmail.com";
    private final String Jmeno = "Novak";
    private final String Prijmeni = "Karel";
    private final String Heslo = "fafawrf2378fd";
    private final String Reheslo = "fafawrf2378fd";
    private String mojeSlozka ="C:\\Users\\Michal\\";
    Date datum = new Date();
    SimpleDateFormat formatdatum = new SimpleDateFormat("yyyy_MMMM_dd_HH_mm_ss");
    String currentDateTime = formatdatum.format(datum);

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michal\\Desktop\\JAVA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);



    }
    @Test
    public void testCheckbox() throws IOException {

        //System.out.println(datum);
        //System.out.println(formatdatum);
        //System.out.println(formatdatum.format(datum));

        seleniumReworkBetter.Formular.Result result = getResult();
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );
        extracted(mojeSlozka+"KontrolatestCheckbox"+currentDateTime+".png");




    }
    @Test
    public void testName  ()throws IOException{


        seleniumReworkBetter.Formular.Result result = getResult();
        result.Pjmeno.sendKeys(Jmeno);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );
        extracted(mojeSlozka+"KontrolaTestName"+currentDateTime+".png");


    }
    @Test
    public void testEmail ()throws IOException{

        seleniumReworkBetter.Formular.Result result = getResult();
        result.Pemail.sendKeys(Email);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );
        extracted(mojeSlozka+"KontrolaTestEmail"+currentDateTime+".png");


    }
    @Test
    public void testPrijmeni ()throws IOException{

        seleniumReworkBetter.Formular.Result result = getResult();
        result.Pprimeni.sendKeys(Prijmeni);
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );
        extracted(mojeSlozka+"KontrolaTestPrijmeni"+currentDateTime+".png");


    }
    @Test
    public void testEmailVelkaPismo ()throws IOException{

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
        extracted(mojeSlozka+"KontrolaTestEmailVelkaPismena"+currentDateTime+".png");


    }
    @Test
    public void testRuzneHela ()throws IOException{


        seleniumReworkBetter.Formular.Result result = getResult();
        result.Pheslo.sendKeys(Heslo);
        result.Preheslo.sendKeys("fjaio");
        result.SomRobot.click();
        result.Pregistrace.click();
        WebElement Vysledek = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String TextVysledku = Vysledek.getText();

        Assert.assertEquals(TextVysledku,"Registracia neuspesna!" );
        extracted(mojeSlozka+"KontrolaTestRuznaHesla"+currentDateTime+".png");


    } @Test
    public void testHappy ()throws IOException{

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
        extracted(mojeSlozka+"KontrolaTestHappy"+currentDateTime+"png");


    }
     @Test
    public void testSpatnyEmailBezPripony()throws IOException{

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
        extracted(mojeSlozka+"KontrolaTestSpatnyEmailBezPripony"+currentDateTime+".png");



     }

    private void extracted(String VarPath) throws IOException {

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(VarPath));

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
    public void tearDone () throws IOException {

        driver.close();
        driver.quit();

    }
}