package stellarBurgersTest;

import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

public class SwitchPageTest extends BaseTest{

    @Test
    @DisplayName("Проверяем переход в личный кабинет")
    public void checkOpenPersonalAccountPage() {
        goToPersonalAccount();

        Assert.assertEquals("Переход в личный кабинет не был выполнен", "Профиль", driver.findElement(personalAccountPage.profileLabel).getText());
    }

    @Test
    @DisplayName("Проверяем переход в конструктор из личного кабинета через кнопку \"Конструктор\"")
    public void checkOpenConstructorPage() {
        goToPersonalAccount();
        personalAccountPage.clickOnElement(personalAccountPage.constructorButton);

        Assert.assertEquals("Переход на главную страницу с конструктором не выполнен", "Соберите бургер", driver.findElement(mainPage.burgerConstructorLabel).getText());
    }

    @Test
    @DisplayName("Проверяем переход на главную страницу из личного кабинета через логотип")
    public void checkOpenMainPageThroughLogo() {
        goToPersonalAccount();
        personalAccountPage.clickOnElement(personalAccountPage.logoButton);

        Assert.assertEquals("Переход на главную страницу с конструктором не выполнен", "Соберите бургер", driver.findElement(mainPage.burgerConstructorLabel).getText());
    }
}
