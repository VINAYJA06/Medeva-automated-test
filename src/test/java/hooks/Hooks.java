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
    @After()
    public void quitBrowser(){
        WebDriverFactory.getDriver().quit();
    }

}
