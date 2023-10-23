package steps.createappointment;

import com.helper.Helper;
import com.pages.createappointment.CreateAppointmentPage;
import com.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateAppointmentSteps {

    private final CreateAppointmentPage createappointmentpage;
    TestContext testContext;

    public CreateAppointmentSteps(TestContext context){
        testContext = context;
        createappointmentpage = testContext.getPageObjectManager().getCreateAppointmentPage();
    }
    @Given("User Clicks On Add Or View Patients Button")
    public void UserClicksOnAddOrViewPatientsButton() throws InterruptedException {
        createappointmentpage.ClickAddOrViewPatients();
        Helper.Logger("Add/View Patients button is clicked");
    }
    @And("User Search For The Patient By Name And Clicks On Patient (.+)$")
    public void UserSearchForThePatientByNameAndClicksOnPatient(String patientName) throws InterruptedException {
        createappointmentpage.SelectPatient(patientName);
        Helper.Logger("Patient name is Searched");
        Helper.Logger("Patient name is clicked");
    }
    @And("User Enters Visit ID (.+)$")
    public void UserEntersVisitID(String visitID) throws InterruptedException {
        visitID = RandomStringUtils.randomAlphabetic(5);
        createappointmentpage.EnterVisitID(visitID);
        Helper.Logger("Visit ID is Entered");
    }
    @Then("User Creates An Appointment")
    public void UserCreatesAnAppointment() throws InterruptedException {
        createappointmentpage.CreateAppointment();
        Helper.Logger("Appointment is created");

    }
    @Then("User Validates The Created Appointment")
    public void UserValidatesTheCreatedAppointment() {
    }

}
