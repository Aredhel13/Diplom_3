package stellarBurgersTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public final String url = "https://stellarburgers.nomoreparties.site/";
    //локатор кнопки "Конструктор"
    public static final By constructorButton = By.className("AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo");
    //локатор кнопки "Войти в аккаунт"
    public static final By loginButtonMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    //локатор кнопки "Личный аккаунт"
    public static final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //локатор кнопки "Оформить заказ"
    public static final By makeOrderButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    //локатор "Собери бургер"
    public static final By burgerConstructorLabel = By.xpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']");
    //локатор таба "Соусы"
    public static final By sauceButton = By.xpath(".//span[text() = 'Соусы']/parent::div");
    //локатор таба "Булки"
    public static final By bunButton = By.xpath(".//span[text() = 'Булки']/parent::div");
    //локатор таба "Начинки"
    public static final By ingredientsButton = By.xpath(".//span[text() = 'Начинки']/parent::div");
    //конструктор класса
    public MainPage (WebDriver driver){
        this.driver = driver;
    }
    //открыть главную страницу
    public void openMainPage(){
        driver.get(url);
    }
    //кликнуть по элементу
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }
    public String getElementText(By element){
        return driver.findElement(element).getText();
    }

}
