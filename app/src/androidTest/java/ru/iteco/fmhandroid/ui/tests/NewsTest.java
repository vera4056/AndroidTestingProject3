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
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {

    NewsSteps newsSteps = new NewsSteps();
    MainMenuSteps mainMenuSteps = new MainMenuSteps();
    LoginSteps loginSteps = new LoginSteps();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void newsScreenLoad() {

        try {
            loginSteps.waitAuthorizationPage();
            loginSteps.validLogin();
        } catch (Exception e) {
            mainMenuSteps.mainScreenLoad();
        }
    }

    @Test
    public void newsTextIsVisibleTest() {
        newsSteps.checkTextInNews();

    }

    @Test
    public void openNewsCreateFormTest() {
        newsSteps.checkCreateNewsForm();

    }

    @Test
    public void createNewsTest() {
        newsSteps.creatingNews();

    }

    @Test
    public void deleteNewsTest() {
        newsSteps.deletingNews();

    }

    @Test
    public void fillCategoryInNewsTest() {
        newsSteps.newsCategory();

    }

    @Test
    public void fillNewsTitleTest() {
        newsSteps.newsTitle();
    }

    @Test
    public void fillNewsDateTest() {
        newsSteps.newsDate();
    }

    @Test
    public void fillNewsTimeTest() {
        newsSteps.newsTime();
    }
}
