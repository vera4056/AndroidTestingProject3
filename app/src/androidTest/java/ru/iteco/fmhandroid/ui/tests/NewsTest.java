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
        newsSteps.openNews(2, "Consequuntur architecto ducimus.");
    }

    @Test
    public void filterNewsCategory() {
        newsSteps.checkFilterNews("Зарплата");

    }

    @Test
    public void cancelNewsFilterTest() {
        newsSteps.cancelFilter();
    }


    @Test
    public void createNewsTest() {
        newsSteps.createNews("Объявление", "Объявление", "12.12.2024",
                "06:00", "party");

    }

    @Test
    public void createNewsWithEmptyDataTest() {
        newsSteps.createEmptyNews("", "", "", "", "");

    }

    @Test
    public void deleteNewsTest() {
        newsSteps.deletingNews("Ш");

    }

    @Test
    public void editingNewsTest() {
        newsSteps.editingNews("gfgh", "КуКу");

    }

}
