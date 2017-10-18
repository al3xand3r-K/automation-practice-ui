package base;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends ConciseAPI {

    @BeforeSuite
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
        Configuration.chromeSwitches = "no-sandbox";
        Configuration.baseUrl = "http://automationpractice.com/index.php";
    }

}