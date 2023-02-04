package stellarBurgersTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurgersTest.pageObject.LoginPage;
import stellarBurgersTest.pageObject.MainPage;
import stellarBurgersTest.pageObject.RegisterPage;


public class SuccessfullyRegistrationTest extends BaseTest{
    @Test
    @DisplayName("Успешная регистрация абонента")
    public void checkSuccessRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickOnElement(mainPage.personalAccountButton);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(loginPage.registrationButton);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputValuesInRegisterFormAndCreateUser(user);

        new WebDriverWait(driver, 3);

        Assert.assertEquals("Регистрация не выполнена. Переход на страницу авторизации не был выполнен или она не прогрузилась", "Вход", mainPage.getElementText(loginPage.loginHeader));
    }




}
