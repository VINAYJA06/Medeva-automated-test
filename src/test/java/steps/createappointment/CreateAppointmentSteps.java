package steps.createappointment;

import com.pages.createappointment.CreateAppointmentPage;
import com.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class CreateAppointmentSteps {

    private CreateAppointmentPage createappointmentpage;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    TestContext testContext;

    public CreateAppointmentSteps(TestContext context){
        testContext = context;
        createappointmentpage = testContext.getPageObjectManager().getCreateAppointmentPage();
    }

    @And("User Is In The Dashboard Page")
    public void UserIsInTheDashboardPage() {
    }

    @Given("User Clicks On Add Or View Patients Button")
    public void UserClicksOnAddOrViewPatientsButton() {
    }

    @And("User Search For The Patient By Name")
    public void UserSearchForThePatientByName() {
    }

    @And("User Select The Patient Of Search And Clicks On Patient")
    public void UserSelectThePatientOfSearchAndClicksOnPatient() {
    }

    @And("User Enters Visit ID")
    public void UserEntersVisitID() {
    }

    @And("User Selects Type Of Consult")
    public void UserSelectsTypeOfConsult() {
    }

    @Then("User Click On Confirm Button")
    public void UserClickOnConfirmButton() {
    }

    @Then("User Creates An Appointment")
    public void UserCreatesAnAppointment() {
    }

    @Then("User Validates The Created Appointment")
    public void UserValidatesTheCreatedAppointment() {
    }

}
