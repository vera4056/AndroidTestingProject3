package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.latency.ViewMatcherLatency.waitDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.missionBackgroundImage;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.missionDescriptionText;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.missionTextButton;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.missionTitle;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.missionTitleText;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.openCloseCardButton;
import static ru.iteco.fmhandroid.ui.pageobjects.LoveIsAll.ourMissionButton;
import static ru.iteco.fmhandroid.ui.pageobjects.MainMenu.textMenuButton;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class LoveIsAllSteps {

    public void checkLoveIsAllElements() {
        Allure.step("Проверка элементов экрана Love Is All");
        onView(isRoot()).perform(waitDisplayed(R.id.our_mission_image_button, 10000));
        onView(allOf(ViewMatchers.withText("Our Mission"), ViewMatchers.isDisplayed()));
    }

    public void goToLoveSection() {
        Allure.step("Переход на страницу Love is all");
        ourMissionButton.perform(click());
        missionTextButton.check(matches(isDisplayed()));
        missionBackgroundImage.check(matches(isDisplayed()));
        missionTitle.check(matches(isDisplayed()));
    }

    public void quotesLoveIsAll() {
        Allure.step("Наличие текста внутри цитаты в Love is all");
        ourMissionButton.perform(click());
        openCloseCardButton.perform(click());
        missionTitleText.check(matches(isDisplayed()));
        missionDescriptionText.check(matches(isDisplayed()));
        openCloseCardButton.perform(click());

    }

    public void backFromLoveToMenuSection() {
        Allure.step("Обратный переход со страницы Love is all в основное меню");
        ourMissionButton.perform(click());
        textMenuButton.check(matches(isDisplayed()));

    }
}