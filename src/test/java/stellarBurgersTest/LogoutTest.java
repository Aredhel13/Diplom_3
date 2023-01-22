package stellarBurgersTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurgersTest.pageObject.LoginPage;
import stellarBurgersTest.pageObject.PersonalAccountPage;

public class LogoutTest extends BaseTest{
    PersonalAccountPage personalAccountPage;
    LoginPage loginPage;
    @Test
    public void checkLogoutOperation(){
        goToPersonalAccount();
        personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickOnElement(personalAccountPage.logoutButton);

        new WebDriverWait(driver, 3);
        loginPage = new LoginPage(driver);

        Assert.assertEquals("Выход из аккаунта не выполнен. Переход на страницу авторизации не был выполнен или она не прогрузилась", "Вход", mainPage.getElementText(loginPage.loginHeader));

    }
}
