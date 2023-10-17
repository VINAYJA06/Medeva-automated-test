package hooks;

import com.factory.WebDriverFactory;
import com.manager.FileReaderManager;
import io.cucumber.java.*;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriverFactory webDriverFactory;
    static WebDriver driver;

    @Before
    public void setupBrowser() throws IOException {
        webDriverFactory = new WebDriverFactory();
        webDriverFactory.init_driver(FileReaderManager.getInstance().getConfigReader().getBrowser());
    }
//    @After(order = 1)
//    public static void addScreenshot(Scenario scenario) {
//        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot,"image/png", "image");
//    }
    @After(order = 0)
    public void quitBrowser(){
        WebDriverFactory.getDriver().quit();
    }

}
