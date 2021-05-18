import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Testy
{
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        driver.navigate().to("https://www.mediaexpert.pl/");
        driver.manage().window().maximize();

    }

    @Test
    public void openPage()
    {
        Assert.assertEquals(driver.getTitle(), "Media Expert | Sklep internetowy RTV, AGD, komputery");
    }

    @Test
    public void closeCookies()
    {

        WebElement closeCookies = driver.findElement(By.xpath("//a[normalize-space()='Zamknij']"));
        closeCookies.click();

    }

    @Test
    public void registerAccount()
    {
        WebElement closeCookies = driver.findElement(By.xpath("//a[normalize-space()='Zamknij']"));
        closeCookies.click();

        WebElement twojeKonto = driver.findElement(By.xpath("//span[normalize-space()='Twoje konto']"));
        twojeKonto.click();

        WebElement zarejestrujSie = driver.findElement(By.xpath("//a[contains(text(),'Zarejestruj się')]"));
        zarejestrujSie.click();

        WebElement imie = driver.findElement(By.xpath("//input[@id='enp_customer_registration_form_type_address_firstName']"));
        imie.sendKeys("Adam");

        WebElement nazwisko = driver.findElement(By.xpath("//input[@id='enp_customer_registration_form_type_address_lastName']"));
        nazwisko.sendKeys("Ryszkowski");

        WebElement email = driver.findElement(By.xpath("//input[@id='enp_customer_registration_form_type_email']"));
        email.sendKeys("xyz@wp.pl");

        WebElement haslo = driver.findElement(By.xpath("//input[@id='enp_customer_registration_form_type_plainPassword']"));
        haslo.sendKeys("ASDFg1111");

        WebElement zaznaczWszystkie = driver.findElement(By.xpath("//div[normalize-space()='Zaznacz wszystkie']"));
        zaznaczWszystkie.click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@value,'Załóż konto')]")));

        WebElement zalozKonto = driver.findElement(By.xpath("//input[contains(@value,'Załóż konto')]"));
        zalozKonto.click();

    }

    @After
    public void tearDown()
    {
        // driver.quit();
    }


}