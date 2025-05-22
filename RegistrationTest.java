package com.calley.automation.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.calley.automation.base.BaseClass;

import pompages.LoginPage;
import pompages.RegistrationPage;

public class RegistrationTest extends BaseClass {
    @Test(priority = 0)
    public void testRegistration() throws InterruptedException  {
        driver.get(properties.getProperty("registrationUrl"));
        PageFactory.initElements(driver, RegistrationPage.class);
        
        RegistrationPage.registerUser(
            properties.getProperty("firstName"),
            properties.getProperty("email"),
            properties.getProperty("phone"),
            properties.getProperty("password")
        );
         
        if (RegistrationPage.isRegistrationSuccessful()) {
            System.out.println("PASSED: Registration success link found");
        } else {
            System.out.println("FAILED: Registration success link not found");
        }
        
    }
    @Test(priority = 1)
    public void userLogin()
    {
       driver.get(properties.getProperty("loginUrl"));
       PageFactory.initElements(driver, LoginPage.class);
 
        LoginPage.login(
        		properties.getProperty("email"),
        		properties.getProperty("password")
        		);
    	
        if (LoginPage.isLoginSuccessful()) {
            System.out.println("PASSED: Login success");
        } else {
            System.out.println("FAILED: Login Fail");
        }
    }
}