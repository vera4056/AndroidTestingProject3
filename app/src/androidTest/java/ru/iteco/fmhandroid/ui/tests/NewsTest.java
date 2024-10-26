package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsCardButton;

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
    public void newsScreenLoad() throws InterruptedException {
        Thread.sleep(7000);
        try {
            loginSteps.waitAuthorizationPage();
            loginSteps.validLogin();
        } catch (Exception e) {
            mainMenuSteps.checkMenuButton();
        }
    }
    @Test
    public void goToNewsSectionTest() {
        newsSteps.newsListLoad();
    }

    @Test
    public void newsTextIsVisibleTest() {
        newsSteps.openNews(3);
        newsSteps.checkTextInsideNews("test");
        newsCardButton.perform(actionOnItemAtPosition(3, click()));
    }


    @Test
    public void filterNewsCategory() {
        newsSteps.checkFilterNews("Зарплата");
    }

    @Test
    public void filterNewsDateTest() {
        newsSteps.filterDateNews();
    }

    @Test
    public void cancelNewsFilterTest() {
        newsSteps.cancelFilter();
    }

    @Test
    public void createNewsTest() {
        newsSteps.creatingNews();

    }

    @Test
    public void deleteNewsTest() {
        newsSteps.deletingNews();

    }


}
