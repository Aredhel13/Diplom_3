package stellarBurgersTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;
    public final String url = "https://stellarburgers.nomoreparties.site/forgot-password";
    //локатор поля "Email"
    public static final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    //локатор кнопки "Войти"
    public static final By loginButton = By.xpath(".//a[@class = 'Auth_link__1fOlj']");

    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }
    public void openPasswordRecovery(){
        driver.get(url);
    }
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

}
