package base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConciseAPI {

    public String genEmail() {
        Random rand = new Random();
        String uid = "";
        for (int i = 0; i < 7; i++) {
            // generates random int between 0 and 9
            int randomNum = rand.nextInt(9 + 1);
            String strRandomNum = String.valueOf(randomNum);
            uid = uid.concat(strRandomNum);
        }
        return "qatest2278+" + uid + "@gmail.com";
    }

    public void hoverAndClick(SelenideElement elemToHover, SelenideElement elemToClick) {
        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(elemToHover);
        builder.build().perform();
        elemToClick.click();
    }
}
