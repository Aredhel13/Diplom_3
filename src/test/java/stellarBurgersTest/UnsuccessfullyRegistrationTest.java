package stellarBurgersTest;

import Data.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurgersTest.pageObject.LoginPage;
import stellarBurgersTest.pageObject.MainPage;
import stellarBurgersTest.pageObject.RegisterPage;

import java.util.concurrent.TimeUnit;

public class UnsuccessfullyRegistrationTest {

    WebDriver driver;
    User user;
    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver","C:/Users/dina1/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.firefox.driver","C:/Users/Lenovo/WebDriver/bin/geckodriver.exe");
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        user = new User("Name","email@mail.ru","123");
    }

    @Test
    @DisplayName("Ошибка регистрации абонента при некорректном пароле (меньше 6 символов)")
    public void checkRegistrationWithIncorrectPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnElement(mainPage.personalAccountButton);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(loginPage.registrationButton);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputValuesInRegisterFormAndCreateUser(user);

        new WebDriverWait(driver, 3);

        Assert.assertEquals("Ошибка не выведена", "Некорректный пароль", registerPage.getErrorText());
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
