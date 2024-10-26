package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.latency.ViewMatcherLatency.waitDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.MainMenu.menuButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.addNewsButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.cancelFilterButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.checkableImageButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.confirmationButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.doesNotExist;
import static ru.iteco.fmhandroid.ui.pageobjects.News.editNewsButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.filterButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.filterEndDate;
import static ru.iteco.fmhandroid.ui.pageobjects.News.filterStartDate;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsCardButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsDeleteButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsFilterButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsOnMain;
import static ru.iteco.fmhandroid.ui.pageobjects.News.placeHolder;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsSteps {

    public void newsListLoad() {
        Allure.step("Загрузка списка новостей");
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 10000));
    }

    public void openNews(int number) {
        Allure.step("Проверка на наличие текста в блоке News");
        menuButton.perform(click());
        newsOnMain.perform(click());
        newsCardButton.check(matches(isDisplayed()));
        newsCardButton.perform(actionOnItemAtPosition(number, click()));


    }
    public void checkTextInsideNews(String text){
        onView(allOf(withId(R.id.news_item_description_text_view),
                withText(text),
                isCompletelyDisplayed())).check(matches(isDisplayed()));

    }


    public void checkFilterNews(String text) {
        Allure.step("Заполнение поля Category - выбираем - Зарплата");
        menuButton.perform(click());
        newsOnMain.perform(click());
        newsFilterButton.perform(click());
        checkableImageButton.check(matches(isDisplayed()));
        checkableImageButton.perform(click());
        filterButton.perform(click());


    }
    public void filterDateNews() {
        Allure.step("Выбор даты в фильтре новостей");
        menuButton.perform(click());
        newsOnMain.perform(click());
        newsFilterButton.perform(click());
        filterStartDate.perform(click(), scrollTo());
        filterEndDate.perform(click(), scrollTo());
        filterButton.perform(click());
        onView(allOf(withId(R.id.empty_news_list_text_view ), withText("There is nothing here yet"))).check(matches(isDisplayed()));
    }

    public void cancelFilter() {
        Allure.step("Отмена фильтрации в форме фильтрации новостей");
        menuButton.perform(click());
        newsOnMain.perform(click());
        newsFilterButton.perform(click());
        cancelFilterButton.perform(click());
        editNewsButton.check(matches(isDisplayed()));

    }

    public void creatingNews() {
        Allure.step("Создание новости c валидными данными");
        newsOnMain.check(matches(isDisplayed()));
        editNewsButton.perform(click());
        addNewsButton.perform(click());
        placeHolder.perform(replaceText("celebrating bd"));
        placeHolder.perform(click(), scrollTo());



        /*newsTitle.check(matches(isDisplayed()));
        newsDate.perform(click());
        newsTime.perform(click());
        newsFillDescription.perform(replaceText("celebrating bd"));
        saveButton.perform(click());
        createdNewsDateView.check(matches(isDisplayed()));*./

         */
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

}


