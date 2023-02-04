package stellarBurgersTest.pageObject;

import Data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public final String url = "https://stellarburgers.nomoreparties.site/login";
    //локатор поля "Email"
    public static final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    //локатор поля "Password"
    public static final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    //локатор кнопки "Зарегистрироваться"
    public static final By registrationButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() ='Зарегистрироваться']");
    //локатор кнопки "Войти"
    public static final By loginButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    public static final By loginHeader = By.xpath(".//h2[text() = 'Вход']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void openLoginPage(){
        driver.get(url);
    }
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void inputValuesInRegisterFormAndLoginUser(User user){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginButton).click();
    }

}
