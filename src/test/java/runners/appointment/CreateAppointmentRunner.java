package runners.appointment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features={"src/test/resources/features/appointment/CreateAppointment.feature"},
//        tags = "@All",
        glue= {"steps", "hooks"},
        dryRun=false,
        monochrome= true,
        plugin= {"pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class CreateAppointmentRunner {
}