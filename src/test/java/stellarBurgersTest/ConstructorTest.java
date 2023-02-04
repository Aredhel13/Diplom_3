package stellarBurgersTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurgersTest.pageObject.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorTest{
    WebDriver driver;

    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver","C:/Users/dina1/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    @DisplayName("Проверяем переключение на вкладку \"Соусы\"")
    public void checkSwitchOnTabSauce(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String noSelectedClass = driver.findElement(mainPage.sauceButton).getAttribute("class");
        new WebDriverWait(driver, 3);
        driver.findElement(mainPage.sauceButton).click();

        Assert.assertNotEquals("Не было переключения на вкладку \"Соусы\"", noSelectedClass, driver.findElement(mainPage.sauceButton).getAttribute("class"));
    }

    @Test
    @DisplayName("Проверяем переключение на вкладку \"Булки\"")
    public void checkSwitchOnTabBuns(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        driver.findElement(mainPage.sauceButton).click();
        String noSelectedClass = driver.findElement(mainPage.bunButton).getAttribute("class");
        new WebDriverWait(driver, 3);
        driver.findElement(mainPage.bunButton).click();

        Assert.assertNotEquals("Не было переключения на вкладку \"Булки\"", noSelectedClass, driver.findElement(mainPage.bunButton).getAttribute("class"));
    }

    @Test
    @DisplayName("Проверяем переключение на вкладку \"Начинки\"")
    public void checkSwitchOnTabIngredients(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String noSelectedClass = driver.findElement(mainPage.bunButton).getAttribute("class");
        new WebDriverWait(driver, 3);
        driver.findElement(mainPage.sauceButton).click();

        Assert.assertNotEquals("Не было переключения на вкладку \"Начинки\"", noSelectedClass, driver.findElement(mainPage.bunButton).getAttribute("class"));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
