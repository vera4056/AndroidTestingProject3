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
import static ru.iteco.fmhandroid.ui.pageobjects.News.categoryText;
import static ru.iteco.fmhandroid.ui.pageobjects.News.checkableImageButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.deleteButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.descriptionText;
import static ru.iteco.fmhandroid.ui.pageobjects.News.editNewsButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.filterButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.materialTextView;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsFilterButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsOnMain;
import static ru.iteco.fmhandroid.ui.pageobjects.News.okButtonMessage;
import static ru.iteco.fmhandroid.ui.pageobjects.News.publishDate;
import static ru.iteco.fmhandroid.ui.pageobjects.News.recyclerView;
import static ru.iteco.fmhandroid.ui.pageobjects.News.timeText;
import static ru.iteco.fmhandroid.ui.pageobjects.News.titleText;

import androidx.test.espresso.action.ViewActions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;


public class NewsSteps {

    private final int saveButtonId = R.id.save_button;

    public void newsListLoad() {
        Allure.step("Загрузка списка новостей");
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 10000));
    }

    public void openNews(int number, String text) {
        Allure.step("Проверка на наличие текста в блоке News");
        menuButton.perform(click());
        newsOnMain.perform(click());
        recyclerView.perform(actionOnItemAtPosition(number, click()));
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
        onView(withText(text)).check(matches(isDisplayed()));

    }


    public void cancelFilter() {
        Allure.step("Отмена фильтрации в форме фильтрации новостей");
        menuButton.perform(click());
        newsOnMain.perform(click());
        newsFilterButton.perform(click());
        cancelFilterButton.perform(click());
        editNewsButton.check(matches(isDisplayed()));

    }

    public void newsCategory(String text) {
        Allure.step("Ввод данных в поле Category");
        categoryText.perform(replaceText(text), ViewActions.closeSoftKeyboard());
    }

    public void newsTitle(String text) {
        Allure.step("Ввод данных в поле Title");
        titleText.perform(replaceText(text), ViewActions.closeSoftKeyboard());
    }

    public void publicationDate(String text) {
        Allure.step("Ввод данных в поле Date");
        publishDate.perform(replaceText(text), ViewActions.closeSoftKeyboard());
    }

    public void selectTime(String time) {
        Allure.step("Выбрать время в поле Time");
        timeText.perform(replaceText(time), ViewActions.closeSoftKeyboard());
    }

    public void newsDescription(String description) {
        Allure.step("Ввод данных в поле Description");
        descriptionText.perform(replaceText(description), ViewActions.closeSoftKeyboard());
    }

    public void clickSaveButtonWithScroll() {
        Allure.step("Клик со скроллом по кнопке c id: " + saveButtonId);
        onView((withId(saveButtonId))).perform(scrollTo(), click());
    }


    public void createNews(String category, String title, String date,
                           String time, String description) {
        Allure.step("Создать новость с валидными данными на кириллице");
        newsOnMain.check(matches(isDisplayed()));
        menuButton.perform(click());
        materialTextView.perform(click());
        editNewsButton.perform(click());
        addNewsButton.perform(click());
        newsCategory(category);
        newsTitle(title);
        publicationDate(date);
        selectTime(time);
        newsDescription(description);
        clickSaveButtonWithScroll();
        onView(withText("Вечеринка")).check(matches(isDisplayed()));


    }


    public void createEmptyNews(String category, String title, String date,
                                String time, String description) {
        Allure.step("Создать новость с пустыми полями в форме для создания новости. Негативный тест, должен падать");
        newsOnMain.check(matches(isDisplayed()));
        menuButton.perform(click());
        materialTextView.perform(click());
        editNewsButton.perform(click());
        addNewsButton.perform(click());
        newsCategory(category);
        newsTitle(title);
        publicationDate(date);
        selectTime(time);
        newsDescription(description);
        clickSaveButtonWithScroll();
        onView(withText("Fill empty fields")).check(matches(isDisplayed()));

    }

    public void deletingNews(String category, String title, String date,
                             String time, String description) {
        Allure.step("Удаление новости  в News. Негативный тест, должен падать");
        newsOnMain.check(matches(isDisplayed()));
        menuButton.perform(click());
        materialTextView.perform(click());
        editNewsButton.perform(click());
        newsCategory(category);
        newsTitle(title);
        publicationDate(date);
        selectTime(time);
        newsDescription(description);
        clickSaveButtonWithScroll();
        onView(withText("Дружба")).check(matches(isDisplayed()));
        deleteButton.perform(click());
        okButtonMessage.perform(click());
        onView(withText("Дружба")).check(matches(isDisplayed()));

    }

    public void editingNews() {
        Allure.step("Редактирование новости");
        newsOnMain.check(matches(isDisplayed()));
        menuButton.perform(click());
        materialTextView.perform(click());
        onView(withText("Вечеринка")).check(matches(isDisplayed()));
        titleText.perform(replaceText("Ужин"));
        onView(withText("Ужин")).check(matches(isDisplayed()));

    }
}




