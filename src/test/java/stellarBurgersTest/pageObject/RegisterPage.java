package stellarBurgersTest.pageObject;

import Data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/register";
    //локатор поля "Имя"
    public static final By nameField = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    //локатор поля "Email"
    public static final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    //локатор поля "Пароль"
    public static final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    //локатор кнопки "Зарегистрироваться"
    public static final By registerButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //локатор кнопки "Войти"
    public static final By loginButton = By.xpath(".//a[@class = 'Auth_link__1fOlj']");
    public static final By errorMessage = By.xpath(".//p[@class = 'input__error text_type_main-default']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void openRegisterPage(){
        driver.get(url);
    }

    public void inputValuesInRegisterFormAndCreateUser(User user){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(user.getName());

        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());

        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());

        driver.findElement(registerButton).click();
    }

    public String getErrorText(){
        return driver.findElement(errorMessage).getText();
    }

}
