package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.missionTitleText;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.openCloseCardButton;

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
    public void waitLoveIsAllLoad() throws InterruptedException {
        Thread.sleep(7000);
        try {
            loginSteps.waitAuthorizationPage();
            loginSteps.validLogin();
        } catch (Exception e) {
            mainMenuSteps.checkMenuButton();
        }
    }

    @Test
    public void checkLoveIsAllSection() {
        loveIsAllSteps.checkLoveIsAllElements();

    }

    @Test
    public void openLoveIsAllSection() {
        loveIsAllSteps.goToLoveSection();

    }

    @Test
    public void checkQuotesLoveIsAll() {
        loveIsAllSteps.checkOpenQuote(1);
        loveIsAllSteps.checkTextInsideQuote("Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.");
        openCloseCardButton.perform(actionOnItemAtPosition(1, click()));
    }

    @Test
    public void checkBackNavigationLoveIsAll() {
        loveIsAllSteps.backFromLoveToMenuSection();

    }
}


