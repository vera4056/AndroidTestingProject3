package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.LoginSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class AboutTests {
    LoginSteps loginSteps = new LoginSteps();
    AboutSteps aboutSteps = new AboutSteps();
    MainMenuSteps mainMenuSteps = new MainMenuSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void aboutScreenLoad() throws InterruptedException {
        Thread.sleep(7000);
        try {
            loginSteps.waitAuthorizationPage();
            loginSteps.validLogin();
        } catch (Exception e) {
            mainMenuSteps.checkMenuButton();
        }

    }


    @Test
    public void displayAboutSectionsTest() {
        aboutSteps.displayAboutSection();

    }

    @Test
    public void goToPrivacyPolicyTest() {
        aboutSteps.linkToPrivacyPolicy();

    }

    @Test
    public void goToTermsOfUseTest() {
        aboutSteps.linkToTermsOfUse();

    }

    @Test
    public void backToNewsTest() {
        aboutSteps.backToNews();

    }
}

