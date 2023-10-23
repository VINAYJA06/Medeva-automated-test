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
    WebElement validateDashboardText;
    @FindBy(xpath = "//h1[contains(normalize-space(),'Sign in to your account')]")
    WebElement validateLoginPage;
    @FindBy(xpath = "//span[contains(.,'Invalid username or password.')]")
    WebElement invalidLoginPage;
    //    Logout attributes
    @FindBy(xpath = "//mat-icon[normalize-space()='arrow_drop_down']")
    WebElement logoutUserDropdown;
    @FindBy(xpath = "//button[contains(.,'LOGOUT')]")
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
    public String ValidateDashboardText() {
        wait.until(ExpectedConditions.visibilityOf(validateDashboardText));
        String actualPageText = validateDashboardText.getText();
        return actualPageText;
    }
    public String ValidateLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(validateLoginPage));
        String validateSignInUsername = validateLoginPage.getText();
        return validateSignInUsername;
    }
    public String InvalidLoginMsg() {
        wait.until(ExpectedConditions.visibilityOf(invalidLoginPage));
        String inValidateSignIn = invalidLoginPage.getText();
        return inValidateSignIn;
    }


}






