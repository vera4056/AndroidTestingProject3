package ru.iteco.fmhandroid.ui.tests;


import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.LogOutSteps;
import ru.iteco.fmhandroid.ui.steps.LoginSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LogInLogOutTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);



    @Before
    public void waitForLoginFieldId () throws InterruptedException {
        Thread.sleep(7000);
        try {
            loginSteps.waitAuthorizationPage();
        } catch (Exception e) {

            logOutSteps.logOut();
            loginSteps.waitAuthorizationPage();

        }
    }

    LoginSteps loginSteps = new LoginSteps();
    LogOutSteps logOutSteps = new LogOutSteps();

    MainMenuSteps mainMenuSteps = new MainMenuSteps();


   @Test
    public void testCheckScreenElements() {

       loginSteps.isLogInElements();
    }

    @Test
    public void logInWithValidDataTest()  {
        loginSteps.validLogin();
        mainMenuSteps.checkMenuButton();

    }

    @Test
    public void logInWithUnValidDataTest() {
        loginSteps.invalidLoginOrPassword();
        mainMenuSteps.checkMenuButton();

    }

    @Test
    public void logInWithEmptyDataTest() {
        loginSteps.emptyLoginData();

    }

    @Test
    public void logOutTest() {
        loginSteps.validLogin();
        logOutSteps.logOut();


    }
}

