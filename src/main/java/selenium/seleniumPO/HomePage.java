package selenium.seleniumPO;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) { super(driver);}

    private String url = "https://epam.github.io/JDI/index.html";
    public void open() {
        driver.navigate().to(url);
    }

    @FindBy(css = ".sidebar-menu [ui=label]") List<WebElement> navigation;
    public void navigateTo(int num) {
        try {
            navigation.get(num).click();
        } catch (StaleElementReferenceException ex) {
            driver.findElements(By.cssSelector(".sidebar-menu [ui=label]")).get(num).click();
        }
    }
    public void navigateTo(String text) {
        List<WebElement> navigations = driver.findElements(By.cssSelector(".sidebar-menu [ui=label]"));
        for (WebElement el : navigations) {
            if (el.getText().equals(text)) {
                el.click();
                return;
            }
        }
    }
    @FindBy(css = ".profile-photo") WebElement profilePhoto;
    @FindBy(css = ".profile-photo [ui=label]") WebElement userName;

}
