package com.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    WebElement enterUsername;
    @FindBy(xpath = "//input[@id='password']")
    WebElement enterPassword;
    @FindBy(xpath = "//input[@id='medTermsCheckbox']")
    WebElement checkTermsCon;
    @FindBy(xpath = "//input[@id='kc-login']")
    WebElement clickSignIn;
    @FindBy(xpath = "//p[contains(text(),'Medeva Healthcare, Delhi, 5-9-92/A/1, Chapel Rd, N')]")
    WebElement selectLocation;
    @FindBy(xpath = "//button[normalize-space()='Go']")
    WebElement clickGo;
    @FindBy(xpath = "//a[normalize-space()='Add/View Patients']")
    WebElement actualDashboardText;
    @FindBy(xpath = "//h4[normalize-space()='Sign In']")
    WebElement validateLoginPage;
    @FindBy(xpath = "//mat-error[contains(.,'Email is required')]")
    WebElement validateUserName;
    @FindBy(xpath = "//mat-error[contains(.,'Password is required')]")
    WebElement validatePassword;
    @FindBy(xpath = "//span[@class='notification-msg']")
    WebElement invalidLoginMsg;
//    Logout attributes
    @FindBy(xpath = "//mat-icon[@aria-haspopup='menu']")
    WebElement logoutUserDropdown;
    @FindBy(xpath = "(//button[@role='menuitem'])[2]")
    WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(100));
        PageFactory.initElements(driver, this);
    }
    public void EnterValidUsername(String username) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(enterUsername));
        enterUsername.sendKeys(username);
        Thread.sleep(3000);
    }
    public void EnterValidPassword(String username) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(enterPassword));
        enterPassword.sendKeys(username);
        Thread.sleep(3000);
    }
    public void ClickTermsCodCheckBox() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(checkTermsCon));
        checkTermsCon.click();
        Thread.sleep(3000);
    }
    public void ClickLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(clickSignIn));
        clickSignIn.click();
        Thread.sleep(3000);
    }
    public void SelectLocation() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(selectLocation));
        selectLocation.click();
        Thread.sleep(3000);
        clickGo.click();
        Thread.sleep(5000);
    }
    public String ActualDashboardText() {
        wait.until(ExpectedConditions.visibilityOf(actualDashboardText));
        String actualPageText = actualDashboardText.getText();
        return actualPageText;
    }
    public String ExpectedDashboardText() {
        String expectedPageText;
        expectedPageText = "ADD/VIEW PATIENTS";
        return expectedPageText;
    }
    public String ValidateLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(validateLoginPage));
        String validateSignIn = validateLoginPage.getText();
        return validateSignIn;
    }
    public String ExpectedLoginMsg() {
        String expectedLoginText;
        expectedLoginText = "Sign In";
        return expectedLoginText;
    }
    public String ValidateLoginUsername() {
        wait.until(ExpectedConditions.visibilityOf(validateUserName));
        String validateSignInUsername = validateUserName.getText();
        return validateSignInUsername;
    }
    public String ExpectedLoginUsername() {
        String expectedSignInUsername;
        expectedSignInUsername = "Email is required";
        return expectedSignInUsername;
    }
    public String ValidateLoginPassword() {
        wait.until(ExpectedConditions.visibilityOf(validatePassword));
        String validateSignInPassword = validatePassword.getText();
        return validateSignInPassword;
    }
    public String ExpectedLoginPassword() {
        String expectedSignInPassword;
        expectedSignInPassword = "Password is required";
        return expectedSignInPassword;
    }
    public String InvalidLoginMsg() {
        wait.until(ExpectedConditions.visibilityOf(invalidLoginMsg));
        String inValidateSignIn = invalidLoginMsg.getText();
        return inValidateSignIn;
    }
    public String ExpectedInvalidMsg() {
        String expectedInvalidMsg;
        expectedInvalidMsg = "Invalid user id or password";
        return expectedInvalidMsg;
    }
    public void ClickUserDropdown() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(logoutUserDropdown));
        logoutUserDropdown.click();
        Thread.sleep(3000);
    }
    public void ClickLogoutButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        Thread.sleep(3000);
    }


}






