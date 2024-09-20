package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.latency.ViewMatcherLatency.waitDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.MainMenu.menuButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.addDescription;
import static ru.iteco.fmhandroid.ui.pageobjects.News.addNewsButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.allNewsCardsBlock;
import static ru.iteco.fmhandroid.ui.pageobjects.News.categoryButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.categoryText;
import static ru.iteco.fmhandroid.ui.pageobjects.News.changeTitle;
import static ru.iteco.fmhandroid.ui.pageobjects.News.confirmationButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.createdNewsDateView;
import static ru.iteco.fmhandroid.ui.pageobjects.News.doesNotExist;
import static ru.iteco.fmhandroid.ui.pageobjects.News.editNewsButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsCardButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsDate;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsDeleteButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsDescription;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsFillDescription;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsOnMain;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsTime;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsTitle;
import static ru.iteco.fmhandroid.ui.pageobjects.News.saveButton;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsSteps {

    public void newsListLoad() {
        Allure.step("Загрузка списка новостей");
        onView(isRoot()).perform(waitDisplayed(R.id.all_news_cards_block_constraint_layout, 10000));
        onView(allOf(withId(R.id.all_news_cards_block_constraint_layout), withText("News"))).check(matches(isDisplayed()));
    }

    public void checkTextInNews() {
        Allure.step("Проверка на наличие текста в блоке News");
        menuButton.perform(click());
        newsOnMain.perform(click());
        newsCardButton.perform(click());
        newsDescription.perform(click());
        newsDescription.check(matches(isDisplayed()));
        newsCardButton.perform(click());
        allNewsCardsBlock.check(matches(isDisplayed()));

    }

    public void checkCreateNewsForm() {
        Allure.step("Открытие формы для создания новости в News");
        menuButton.perform(click());
        newsOnMain.perform(click());
        editNewsButton.check(matches(isDisplayed()));
        editNewsButton.perform(click());
        addNewsButton.check(matches(isDisplayed()));
        addNewsButton.perform(click());

    }

    public void creatingNews() {
        Allure.step("Создание новости ");
        categoryButton.perform(click());
        categoryText.perform(click());
        newsTitle.check(matches(isDisplayed()));
        newsDate.perform(click());
        newsTime.perform(click());
        newsFillDescription.perform(replaceText("celebrating bd"));
        saveButton.perform(click());
        createdNewsDateView.check(matches(isDisplayed()));
    }

    public void deletingNews() {
        Allure.step("Удаление новости  в News");
        newsOnMain.perform(click());
        newsOnMain.perform(click());
        editNewsButton.perform(click());
        newsDeleteButton.perform(click());
        confirmationButton.perform(click());
        doesNotExist.check(matches(isDisplayed()));

    }

    public void newsCategory() {
        Allure.step("Заполнение поля Category");
        categoryText.perform(scrollTo(), click());
    }

    public void newsTitle() {
        Allure.step("Заполнение поля Title");
        newsTitle.perform((replaceText(changeTitle.toString())));
    }

    public void newsDate() {
        Allure.step("Выбор текущей даты для новости");
        newsDate.perform(click());
        confirmationButton.perform(click());
    }

    public void newsTime() {
        Allure.step("Выбор текущего времени для новости");
        newsTime.perform(scrollTo(), click());
        confirmationButton.perform(scrollTo(), click());

    }

    public void newsDescription() {
        Allure.step("Заполнение поля Description");
        newsFillDescription.perform((replaceText(addDescription.toString())));
        saveButton.perform(click());

    }
}


