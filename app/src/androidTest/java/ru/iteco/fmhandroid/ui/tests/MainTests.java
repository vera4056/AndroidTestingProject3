package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.LoginSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainTests {

    MainMenuSteps mainMenuSteps = new MainMenuSteps();
    LoginSteps loginSteps = new LoginSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void mainScreenLoad() {

        try {
            loginSteps.waitAuthorizationPage();
            loginSteps.validLogin();
        } catch (Exception e) {
            mainMenuSteps.mainScreenLoad();
        }
    }

    @Test
    public void displayMainMenuTest() {
        mainMenuSteps.menuButtons();


    }

    @Test
    public void goToNewsPageTest() {


        mainMenuSteps.goToNews();

    }

    @Test
    public void goToAboutPageTest() {

        mainMenuSteps.goToAbout();
    }
}