package hooks;

import com.factory.WebDriverFactory;
import com.manager.FileReaderManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import java.io.IOException;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriverFactory webDriverFactory;
    WebDriver driver;

    @Before
    public void setupBrowser() throws IOException {
        webDriverFactory = new WebDriverFactory();
        webDriverFactory.init_driver(FileReaderManager.getInstance().getConfigReader().getBrowser());
    }

    @After(order = 0)
    public void quitBrowser(){
        WebDriverFactory.getDriver().quit();
    }

}
