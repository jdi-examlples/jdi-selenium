package selenium.seleniumPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.entities.User;

public class LoginForm extends BasePage  {
    public LoginForm(WebDriver driver) { super(driver);}

    @FindBy(css="form #Name")      WebElement userName;
    @FindBy(css="form #Password")  WebElement password;

    @FindBy(css="form [type=submit]") WebElement enter;

    void loginAs(User user) {
        userName.sendKeys(user.userName);
        password.sendKeys(user.password);
        enter.click();
    }
}
