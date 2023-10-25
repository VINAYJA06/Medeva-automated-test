package com.manager;

import com.pages.appointment.CreateAppointmentPage;
import com.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;
    private LoginPage loginPage;
    private CreateAppointmentPage createappointmentpage;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public CreateAppointmentPage getCreateAppointmentPage() {
        return (createappointmentpage == null) ? createappointmentpage = new CreateAppointmentPage(driver) : createappointmentpage;
    }
}
