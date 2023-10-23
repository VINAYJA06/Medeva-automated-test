package steps.createappointment;

import com.pages.createappointment.CreateAppointmentPage;
import com.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class CreateAppointmentSteps {

    private CreateAppointmentPage createappointmentpage;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    TestContext testContext;

    public CreateAppointmentSteps(TestContext context){
        testContext = context;
        createappointmentpage = testContext.getPageObjectManager().getCreateAppointmentPage();
    }
    @Given("User Clicks On Add Or View Patients Button")
    public void UserClicksOnAddOrViewPatientsButton() throws InterruptedException {
        createappointmentpage.ClickAddOrViewPatients();
    }
    @And("User Search For The Patient By Name And Clicks On Patient (.+)$")
    public void UserSearchForThePatientByNameAndClicksOnPatient(String patientName) throws InterruptedException {
        createappointmentpage.SelectPatient(patientName);
    }
    @And("User Enters Visit ID (.+)$")
    public void UserEntersVisitID(String visitID) throws InterruptedException {
        visitID = RandomStringUtils.randomAlphabetic(5);
        createappointmentpage.EnterVisitID(visitID);
    }
    @Then("User Creates An Appointment")
    public void UserCreatesAnAppointment() throws InterruptedException {
        createappointmentpage.CreateAppointment();

    }
    @Then("User Validates The Created Appointment")
    public void UserValidatesTheCreatedAppointment() {
    }

}
