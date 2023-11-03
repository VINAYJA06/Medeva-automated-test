package steps.login;

import com.factory.WebDriverFactory;
import com.helper.Helper;
import com.manager.FileReaderManager;
import com.pages.login.LoginPage;
import com.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {
    private final LoginPage loginPage;
    TestContext testContext;

    public LoginSteps(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }
    @Given("User Is In The Login Page")
    public void UserIsInTheLoginPage() throws IOException {
        WebDriverFactory.getDriver().get(FileReaderManager.getInstance().getConfigReader().getTestingUrl());
        Helper.Logger("URL Fetched Successfully");
    }
    @When("User Enters Valid Username")
    public void UserEntersValidUsername() throws IOException {
        loginPage.EnterValidUsername(FileReaderManager.getInstance().getConfigReader().getValidTestingUsername());
        Helper.Logger("Valid Username is Entered");
    }
    @And("User Enters Valid Password")
    public void UserEntersValidPassword() throws IOException {
        loginPage.EnterValidPassword(FileReaderManager.getInstance().getConfigReader().getValidTestingPassword());
        Helper.Logger("Valid Password is Entered");
    }
    @And("User Select Terms And Conditions")
    public void UserSelectTermsAndConditions() throws IOException {
        loginPage.ClickTermsCodCheckBox();
        Helper.Logger("Terms and Conditions is Checked");
    }
    @And("User Clicks On SignIn")
    public void UserClicksOnSignIn() throws IOException {
        loginPage.ClickLoginButton();
        Helper.Logger("SignIn Button is Clicked");
    }
    @And("User Select Hospital Location And Click On Go")
    public void UserSelectHospitalLocationAndClickOnGo() throws IOException {
        loginPage.SelectLocation();
        Helper.Logger("(Medeva Healthcare, Delhi, 5-9-92/A/1, Chapel Rd, N) - Hospital is Selected");
    }
    @And("User Is In The Dashboard Page")
    public void UserIsInTheDashboardPage(){
        Helper.Logger("User entered into the Dashboard Page");
    }
    @And("User Enters InValid Username")
    public void UserEntersInValidUsername() throws IOException {
        loginPage.EnterValidUsername(FileReaderManager.getInstance().getConfigReader().getInvalidTestingUsername());
        Helper.Logger("Wrong Username is Entered");
    }
    @And("User Enters Invalid Password")
    public void UserEntersInvalidPassword() throws IOException {
        loginPage.EnterValidPassword(FileReaderManager.getInstance().getConfigReader().getInvalidTestingPassword());
        Helper.Logger("Wrong Password is Entered");
    }
    @And("User Enters Empty Username")
    public void UserEntersEmptyUsername() {
        Helper.Logger("Username is not Entered");
    }
    @And("User Enters Empty Password")
    public void UserEntersEmptyPassword() {
        Helper.Logger("Password is not Entered");
    }
    @Then("User Validates Valid Login")
    public void UserValidatesValidLogin() {
        Helper.assertSingleFieldVal("ADD/VIEW PATIENTS", loginPage.validateDashboardText.getText());
    }
    @Then("User Validates Empty Username")
    public void UserValidatesEmptyUsername() {
        Helper.assertSingleFieldVal("Invalid username or password.",loginPage.invalidLoginPage.getText());
    }
    @Then("User Validates Empty Password")
    public void UserValidatesEmptyPassword() {
        Helper.assertSingleFieldVal("Invalid username or password.",loginPage.invalidLoginPage.getText());
    }
    @Then("User Validates Empty Username And Password")
    public void UserValidatesEmptyUsernameAndPassword() {
        Helper.assertSingleFieldVal("Invalid username or password.",loginPage.invalidLoginPage.getText());
    }
    @Then("User Validates Invalid Login Page")
    public void UserValidatesInvalidLoginPage() {
        Helper.assertSingleFieldVal("Invalid username or password.",loginPage.invalidLoginPage.getText());
        Helper.Logger("Login is not Successful");
    }

    //Logout
    @When("User Clicks On User Dropdown And Logout From Application Successfully")
    public void UserClicksOnUserDropdownAndLogoutFromApplicationSuccessfully() throws IOException {
        loginPage.ClickUserDropdown();
        Helper.Logger("clicks on user dropdown");
        loginPage.ClickLogoutButton();
        Helper.Logger("clicks on Logout");
    }
    @Then("User Should Redirect Back To The Login Page And Validates Login Page")
    public void UserShouldRedirectBackToTheLoginPage() {
        Helper.assertSingleFieldVal("Sign in to your account",loginPage.validateLoginPage.getText());
        Helper.Logger("User Redirected back to the SignIN Page ");
    }


}
