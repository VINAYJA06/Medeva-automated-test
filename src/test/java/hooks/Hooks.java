package hooks;

import com.factory.WebDriverFactory;
import com.helper.Helper;
import com.manager.FileReaderManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    WebDriverFactory webDriverFactory;

    @Before
    public void setupBrowser() throws IOException {
        webDriverFactory = new WebDriverFactory();
        webDriverFactory.init_driver(FileReaderManager.getInstance().getConfigReader().getBrowser());
    }

    @After
    public void quitBrowser() {
        WebDriverFactory.getDriver().quit();
    }

}
