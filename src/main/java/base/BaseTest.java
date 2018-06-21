package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.AssertionMode.SOFT;

@Listeners(SoftAsserts.class)
public class BaseTest extends ConciseAPI {

    @BeforeSuite
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.assertionMode = SOFT;
        Configuration.browser = "chrome";
        Configuration.chromeSwitches = "no-sandbox";
        Configuration.baseUrl = "http://automationpractice.com/index.php";
    }

}