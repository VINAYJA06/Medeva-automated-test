package com.pages.appointment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void ClickAddOrViewPatients() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(clickAddOrViewPatients));
        clickAddOrViewPatients.click();
        Thread.sleep(3000);
    }
    public void SelectPatient(String patientName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(patientNameField));
        patientNameField.click();
        Thread.sleep(3000);
        patientNameField.sendKeys(patientName);
        Thread.sleep(3000);
        clickPatient.click();
        Thread.sleep(3000);
    }
    public void EnterVisitID(String visitID) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(enterVisitID));
        enterVisitID.sendKeys(visitID);
        Thread.sleep(3000);
        selectConsultType.click();
        Thread.sleep(3000);
    }
    public void CreateAppointment() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(clickConfirm));
        clickConfirm.click();
        Thread.sleep(3000);
    }
}
