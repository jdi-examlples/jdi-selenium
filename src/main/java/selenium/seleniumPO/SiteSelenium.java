package selenium.seleniumPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.entities.User;

import static org.openqa.selenium.support.PageFactory.*;

public class SiteSelenium {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static HomePage homePage = initElements(getDriver(), HomePage.class);
    public static PerformancePage performancePage = initElements(getDriver(), PerformancePage.class);
    public static LoginForm loginForm = initElements(getDriver(), LoginForm.class);

    public static void login(User user) {
        if (!homePage.userName.isDisplayed()) {
            homePage.profilePhoto.click();
            loginForm.loginAs(user);
        }
    }
}
