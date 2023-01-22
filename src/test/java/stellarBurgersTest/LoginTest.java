package stellarBurgersTest;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurgersTest.pageObject.LoginPage;
import stellarBurgersTest.pageObject.MainPage;
import stellarBurgersTest.pageObject.PasswordRecoveryPage;
import stellarBurgersTest.pageObject.RegisterPage;

public class LoginTest extends BaseTest{
    LoginPage loginPage;

   @Step("Ввод данных и проверка входа")
    public void inputDataAndLogin(){
        loginPage = new LoginPage(driver);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginHeader));

        loginPage.inputValuesInRegisterFormAndLoginUser(userData);

        new WebDriverWait(driver, 3);

        Assert.assertEquals("Авторизация не была выполнена", "Оформить заказ", mainPage.getElementText(mainPage.makeOrderButton));

    }
    @Test
    @DisplayName("Успешная авторизация абонента из формы регистрации")
    public void checkLoginFromRegistrationForm() {
        createUser(user);

        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();

        driver.findElement(registerPage.loginButton).click();

        inputDataAndLogin();

    }

    @Test
    @DisplayName("Успешная авторизация абонента через кнопку \"Личный кабинет\"")
    public void checkLoginFromPersonalAccountButton() {
        createUser(user);

        mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.clickOnElement(mainPage.personalAccountButton);

        inputDataAndLogin();

    }

    @Test
    @DisplayName("Успешная авторизация абонента на главной странице")
    public void checkLoginFromMainPage() {
        createUser(user);

        mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.clickOnElement(mainPage.loginButtonMainPage);

        inputDataAndLogin();

    }

    @Test
    @DisplayName("Успешная авторизация абонента через форму восстановления пароля")
    public void checkLoginFromPasswordRecovery() {
        createUser(user);
        mainPage = new MainPage(driver);
        PasswordRecoveryPage passwordRecovery = new PasswordRecoveryPage(driver);
        passwordRecovery.openPasswordRecovery();

        passwordRecovery.clickOnElement(passwordRecovery.loginButton);

        inputDataAndLogin();

    }

}
