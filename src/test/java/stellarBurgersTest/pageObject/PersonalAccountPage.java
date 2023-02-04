package stellarBurgersTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/account/profile";
    //локатор кнопки "Личный кабинет"
    public static final By profileLabel = By.xpath(".//a[@class = 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");
    //локатор кнопки лого "Stellar Burger"
    public static final By logoButton = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    public static final By constructorButton = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2']");
    public static final By logoutButton = By.xpath(".//button[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    public PersonalAccountPage(WebDriver driver) { this.driver = driver;
    }
    public void openPersonalAccountPage(){
        driver.get(url);
    }
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }
}
