package base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConciseAPI {
    public void hoverAndClick(SelenideElement elemToHover, SelenideElement elemToClick) {
        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(elemToHover);
        builder.build().perform();
        elemToClick.click();
    }
}
