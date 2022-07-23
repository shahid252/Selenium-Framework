package com.mystore.testscripts;

import com.mystore.pages.SignupPage;
import com.mystore.testcases.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Signup extends TestBase {

    SignupPage signupPage;

    @BeforeClass
    public void setup() throws IOException {
        invoke();

        signupPage = new SignupPage(driver);
    }

    @Test
    public void Method() throws InterruptedException {
        signupPage.clickSignUplink();
        signupPage.EnterFullName("Ali");
        signupPage.EnterPhoneNumber("03452764252");
        signupPage.Enterpassword("abcd9876");
        signupPage.Month();
        Thread.sleep(2000);
        signupPage.MonthSelect();
        signupPage.Day();
        Thread.sleep(2000);
        signupPage.DaySelect();
        signupPage.Year();
        signupPage.Gender();
        signupPage.lgnBtn();
    }
}
