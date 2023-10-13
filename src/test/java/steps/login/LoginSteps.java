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
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

public class LoginSteps {
    private LoginPage loginPage;
//    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    Logger log = Logger.getLogger(LoginSteps.class.getName());
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
        loginPage.EnterValidUsername(FileReaderManager.getInstance().getConfigReader().getTestingUsername());
        log.info("Username is Entered");
    }
    @And("User Enters Valid Password")
    public void UserEntersValidPassword() throws InterruptedException, IOException {
        loginPage.EnterValidPassword(FileReaderManager.getInstance().getConfigReader().getTestingPassword());
        log.info("Password is Entered");
    }
    @And("User Select Terms And Conditions")
    public void UserSelectTermsAndConditions() throws InterruptedException {
        loginPage.ClickTermsCodCheckBox();
        log.info("Terms and Conditions is Checked");
    }
    @And("User Clicks On SignIn")
    public void UserClicksOnSignIn() throws InterruptedException {
        loginPage.ClickLoginButton();
        log.info("Clicked SignIn Button");
    }
    @And("User Select Hospital Location And Click On Go")
    public void UserSelectHospitalLocationAndClickOnGo() throws InterruptedException {
        loginPage.SelectLocation();
        log.info("(Medeva Healthcare, Delhi, 5-9-92/A/1, Chapel Rd, N) - Hospital is Selected");
    }
    @And("User Navigated To Dashboard Page")
    public void UserNavigatedToDashboardPage(){
        log.info("User in the Login Page");
    }
    @Then("User Validates Valid Login")
    public void UserValidatesValidLogin() {
        Assert.assertEquals(loginPage.ExpectedDashboardText(), loginPage.ActualDashboardText());
        log.info("User Login Validation is Successful");
    }
    @When("User Validates Empty Username And Password")
    public void UserValidatesEmptyUsernameAndPassword() {
        Assert.assertEquals(loginPage.ExpectedLoginUsername(), loginPage.ValidateLoginUsername());
        Assert.assertEquals(loginPage.ExpectedLoginPassword(), loginPage.ValidateLoginPassword());
        System.out.println(" ");
        System.out.println(loginPage.ValidateLoginUsername());
        System.out.println(loginPage.ValidateLoginPassword());
    }
    @Then("User Validates Empty Username")
    public void UserValidatesEmptyPPUsername() {
        Assert.assertEquals(loginPage.ExpectedLoginUsername(), loginPage.ValidateLoginUsername());
        System.out.println(" ");
        System.out.println("Username is Empty");
        System.out.println(loginPage.ValidateLoginUsername());
    }
    @Then("User Validates Empty Password")
    public void UserValidatesEmptyPPPassword() {
        Assert.assertEquals(loginPage.ExpectedLoginPassword(), loginPage.ValidateLoginPassword());
        System.out.println(" ");
        System.out.println("Password is Empty");
        System.out.println(loginPage.ValidateLoginPassword());
    }
    //Logout
    @When("User Clicks On User Dropdown And Logout From Application Successfully")
    public void UserClicksOnUserDropdownAndLogoutFromApplicationSuccessfully() throws InterruptedException {
        loginPage.ClickUserDropdown();
        loginPage.ClickLogoutButton();
    }
    @Then("User Should Redirect Back To The Login Page And Validates Login Page")
        public void UserShouldRedirectBackToTheLoginPage() throws InterruptedException {
        Assert.assertEquals(loginPage.ExpectedLoginMsg(), loginPage.ValidateLoginPage());
        System.out.println(" ");
        System.out.println("User Redirected back to the SignIN Page ");
        System.out.println(" ");
    }
    @Then("User Validates Invalid Login Page")
        public void UserValidatesInvalidLoginPage() {
        Assert.assertEquals(loginPage.ExpectedInvalidMsg(), loginPage.InvalidLoginMsg());
        System.out.println(" ");
        System.out.println("Login is not Successful");
        System.out.println("Message: "+ loginPage.InvalidLoginMsg());
    }


}
