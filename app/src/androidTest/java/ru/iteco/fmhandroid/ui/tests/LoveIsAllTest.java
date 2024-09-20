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
import ru.iteco.fmhandroid.ui.steps.LoveIsAllSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LoveIsAllTest {

    LoveIsAllSteps loveIsAllSteps = new LoveIsAllSteps();
    LoginSteps loginSteps = new LoginSteps();
    MainMenuSteps mainMenuSteps = new MainMenuSteps();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void waitLoveIsAllLoad() {

        try {
            loginSteps.waitAuthorizationPage();
            loginSteps.validLogin();
        } catch (Exception e) {
            mainMenuSteps.mainScreenLoad();
        }
    }

    @Test
    public void openLoveIsAllSection() {
        loveIsAllSteps.goToLoveSection();

    }

    @Test
    public void checkQuotesLoveIsAll() {
        loveIsAllSteps.quotesLoveIsAll();

    }

    @Test
    public void checkBackNavigationLoveIsAll() {
        loveIsAllSteps.backFromLoveToMenuSection();

    }
}


