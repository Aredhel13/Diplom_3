package stellarBurgersTest;

import java.util.concurrent.TimeUnit;

import Data.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurgersTest.pageObject.LoginPage;
import stellarBurgersTest.pageObject.MainPage;
import stellarBurgersTest.pageObject.PersonalAccountPage;
import stellarBurgersTest.pageObject.RegisterPage;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public WebDriver driver;
    public PersonalAccountPage personalAccountPage;
    public MainPage mainPage;
    public RegisterPage registerPage;
    public User user;
    public User userData;
    private final String name = "Тоширо Хицугайя";
    private final String email = "Toshi@yandex.ru";
    private final String password = "password";

    @Before
    public void preSettings(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Yandex
//        System.setProperty("webdriver.chrome.driver","C:/Users/dina1/chromedriver_win32/chromedriver-2.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:/Users/dina1/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        user = new User(name,email,password);
        userData = new User(email,password);
    }

   @Step("Регистрация пользователя")
    public Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");
    }

    @Step("Авторизация пользователя")
    public Response loginUser(User userDataForLogin) {
        return  given()
                .header("Content-type", "application/json")
                .body(userDataForLogin)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");
    }

    @Step("Удаление пользователя")
    public void deleteUser(String token){
        given()
                .header("Authorization", token)
                .header("Content-type", "application/json")
                .and()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
    }

    @Step("Авторизация пользователя в вебе")
    public void loginUserInWeb(){
        createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.inputValuesInRegisterFormAndLoginUser(userData);

        new WebDriverWait(driver, 3);
    }

    @Step("Переход в Личный кабинет")
    public void goToPersonalAccount(){
        loginUserInWeb();
        mainPage = new MainPage(driver);
        mainPage.clickOnElement(mainPage.personalAccountButton);
        personalAccountPage = new PersonalAccountPage(driver);
    }
    @After
    public void teardown(){
        driver.quit();
        String accessToken = loginUser(userData).then().extract().path("accessToken");
        deleteUser(accessToken);
    }
}
