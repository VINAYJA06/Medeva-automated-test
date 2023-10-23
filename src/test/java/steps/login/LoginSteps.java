package steps.login;

import com.factory.WebDriverFactory;
import com.manager.FileReaderManager;
import com.pages.login.LoginPage;
import com.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class LoginSteps {
    private final LoginPage loginPage;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    //    Logger log = Logger.getLogger(LoginSteps.class.getName());
    TestContext testContext;

    public LoginSteps(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }
    @Given("User Is In The Login Page")
    public void UserIsInTheLoginPage() throws IOException {
        WebDriverFactory.getDriver().get(FileReaderManager.getInstance().getConfigReader().getTestingUrl());
        log.info("URL Fetched Successfully");
    }
    @When("User Enters Valid Username")
    public void UserEntersValidUsername() throws InterruptedException, IOException {
        loginPage.EnterValidUsername(FileReaderManager.getInstance().getConfigReader().getValidTestingUsername());
        log.info("Valid Username is Entered");
    }
    @And("User Enters Valid Password")
    public void UserEntersValidPassword() throws InterruptedException, IOException {
        loginPage.EnterValidPassword(FileReaderManager.getInstance().getConfigReader().getValidTestingPassword());
        log.info("Valid Password is Entered");
    }
    @And("User Select Terms And Conditions")
    public void UserSelectTermsAndConditions() throws InterruptedException {
        loginPage.ClickTermsCodCheckBox();
        log.info("Terms and Conditions is Checked");
    }
    @And("User Clicks On SignIn")
    public void UserClicksOnSignIn() throws InterruptedException {
        loginPage.ClickLoginButton();
        log.info("SignIn Button is Clicked");
    }
    @And("User Select Hospital Location And Click On Go")
    public void UserSelectHospitalLocationAndClickOnGo() throws InterruptedException {
        loginPage.SelectLocation();
        log.info("(Medeva Healthcare, Delhi, 5-9-92/A/1, Chapel Rd, N) - Hospital is Selected");
    }
    @And("User Is In The Dashboard Page")
    public void UserIsInTheDashboardPage(){
        log.info("User entered into the Dashboard Page");
    }
    @And("User Enters InValid Username")
    public void UserEntersInValidUsername() throws IOException, InterruptedException {
        loginPage.EnterValidUsername(FileReaderManager.getInstance().getConfigReader().getInvalidTestingUsername());
        log.info("Wrong Username is Entered");
    }
    @And("User Enters Invalid Password")
    public void UserEntersInvalidPassword() throws IOException, InterruptedException {
        loginPage.EnterValidPassword(FileReaderManager.getInstance().getConfigReader().getInvalidTestingingPassword());
        log.info("Wrong Password is Entered");
    }
    @And("User Enters Empty Username")
    public void UserEntersEmptyUsername() throws IOException, InterruptedException {
        log.info("Username is not Entered");
    }
    @And("User Enters Empty Password")
    public void UserEntersEmptyPassword() throws IOException, InterruptedException {
        log.info("Password is not Entered");
    }
    @Then("User Validates Valid Login")
    public void UserValidatesValidLogin() {
        Assert.assertEquals(loginPage.ExpectedDashboardText(), loginPage.ActualDashboardText());
        log.info("User Login Validation is Successful and reads dashboard data of : "+loginPage.ActualDashboardText());
    }
    @Then("User Validates Empty Username")
    public void UserValidatesEmptyUsername() {
        Assert.assertEquals(loginPage.ExpectedLoginUsername(), loginPage.ValidateLoginUsername());
        log.info(loginPage.ValidateLoginUsername());
    }
    @Then("User Validates Empty Password")
    public void UserValidatesEmptyPPPassword() {
        Assert.assertEquals(loginPage.ExpectedLoginPassword(), loginPage.ValidateLoginPassword());
        log.info("Password is Empty");
        log.info(loginPage.ValidateLoginPassword());
    }
    @Then("User Validates Invalid Login Page")
    public void UserValidatesInvalidLoginPage() {
        Assert.assertEquals(loginPage.ExpectedInvalidMsg(), loginPage.InvalidLoginMsg());
        log.info("Login is not Successful");
        log.info("Actual Message : "+ loginPage.InvalidLoginMsg());
        log.info("Expected Message : "+loginPage.ExpectedInvalidMsg());
    }

    //Logout
    @When("User Clicks On User Dropdown And Logout From Application Successfully")
    public void UserClicksOnUserDropdownAndLogoutFromApplicationSuccessfully() throws InterruptedException {
        loginPage.ClickUserDropdown();
        log.info("clicks on user dropdown");
        loginPage.ClickLogoutButton();
        log.info("clicks on Logout");
    }
    @Then("User Should Redirect Back To The Login Page And Validates Login Page")
    public void UserShouldRedirectBackToTheLoginPage() throws InterruptedException {
        Assert.assertEquals(loginPage.ExpectedLoginMsg(), loginPage.ValidateLoginPage());
        log.info("User Redirected back to the SignIN Page ");
        log.info("Expected : "+loginPage.ExpectedLoginMsg());
        log.info("Actual : "+loginPage.ValidateLoginPage());
    }


}
