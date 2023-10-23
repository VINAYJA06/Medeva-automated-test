package runners.createappointment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features={"src/test/resources/features/createappointment/CreateAppointment.feature"},
        glue= {"steps", "hooks"},
        dryRun=false,
        monochrome= true,
        plugin= {"pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class CreateAppointmentRunner {
}