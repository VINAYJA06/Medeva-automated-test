package com.pages.appointment;

import com.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CreateAppointmentPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[normalize-space()='Add/View Patients']")
    WebElement clickAddOrViewPatients;
    @FindBy(xpath = "//input[@name='name']")
    WebElement patientNameField;
    @FindBy(xpath = "(//div[@role='row'])[3]") //based on row count should change the number, first row==3
    WebElement clickPatient;
    @FindBy(xpath = "//input[@name='visitId']")
    WebElement enterVisitID;
    @FindBy(xpath = "//span[normalize-space()='Tele Consult']")
    WebElement selectConsultType;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement clickConfirm;

    public CreateAppointmentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(100));
        PageFactory.initElements(driver, this);
    }

    public void ClickAddOrViewPatients() throws InterruptedException, IOException {
        Helper.isElementPresent(wait, clickAddOrViewPatients);
        Helper.clickOnElement(clickAddOrViewPatients);
        Helper.captureScreenshot(driver);
        Thread.sleep(3000);
    }
    public void SelectPatient(String patientName) throws InterruptedException {
        Helper.isElementPresent(wait, patientNameField);
        Helper.clickOnElement(patientNameField);

        Thread.sleep(3000);
        patientNameField.sendKeys(patientName);
        Thread.sleep(3000);
        Helper.clickOnElement(clickPatient);
        Thread.sleep(3000);
    }
    public void EnterVisitID(String visitID) throws InterruptedException {
        Helper.isElementPresent(wait, enterVisitID);
        enterVisitID.sendKeys(visitID);
        Thread.sleep(3000);
        Helper.clickOnElement(selectConsultType);
        Thread.sleep(3000);
    }
    public void CreateAppointment() throws InterruptedException {
        Helper.isElementPresent(wait, clickConfirm);
        Helper.clickOnElement(clickConfirm);
        Thread.sleep(3000);
    }
}
