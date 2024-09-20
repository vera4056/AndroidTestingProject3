package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.latency.ViewMatcherLatency.waitDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.LogOut.authImage;
import static ru.iteco.fmhandroid.ui.pageobjects.LogOut.logOutButton;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class LogOutSteps {
    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 7000));
    }

    public void logOut() {
        Allure.step("Выход из учетной записи");
        waitingPageLoad();
        authImage.perform(click());
        onView(isRoot()).perform(waitDisplayed(android.R.id.title, 7000));
        logOutButton.check(matches(isDisplayed()));
        logOutButton.perform(click());
        /*authorization.check(matches(isDisplayed()));*/


    }
}
