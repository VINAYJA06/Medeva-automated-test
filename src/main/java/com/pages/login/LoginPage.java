package com.pages.login;

import com.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
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
    public WebElement validateDashboardText;
    @FindBy(xpath = "//h1[contains(normalize-space(),'Sign in to your account')]")
    public WebElement validateLoginPage;
    @FindBy(xpath = "//span[contains(.,'Invalid username or password.')]")
    public WebElement invalidLoginPage;
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
    public void ClickTermsCodCheckBox() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.visibilityOf(checkTermsCon));
        Helper.clickOnElement(checkTermsCon);
        Helper.captureScreenshot(driver);
        Thread.sleep(3000);
    }
    public void ClickLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(clickSignIn));
        Helper.clickOnElement(clickSignIn);
        Thread.sleep(3000);
    }
    public void SelectLocation() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(selectLocation));
        Helper.clickOnElement(selectLocation);
        Thread.sleep(3000);
        Helper.clickOnElement(clickGo);
        Thread.sleep(5000);
    }
    public void ClickUserDropdown() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(logoutUserDropdown));
        Helper.clickOnElement(logoutUserDropdown);
        Thread.sleep(3000);
    }
    public void ClickLogoutButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        Helper.clickOnElement(logoutButton);
        Thread.sleep(3000);
    }


}






