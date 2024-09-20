package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.latency.ViewMatcherLatency.waitDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.About.aboutBackButton;
import static ru.iteco.fmhandroid.ui.pageobjects.About.aboutCompany;
import static ru.iteco.fmhandroid.ui.pageobjects.About.aboutTextButton;
import static ru.iteco.fmhandroid.ui.pageobjects.About.privacyPolicyLink;
import static ru.iteco.fmhandroid.ui.pageobjects.About.termsOfUseLink;
import static ru.iteco.fmhandroid.ui.pageobjects.About.versionInfo;
import static ru.iteco.fmhandroid.ui.pageobjects.MainMenu.menuButton;
import static ru.iteco.fmhandroid.ui.pageobjects.News.newsOnMain;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutSteps {



    public void checkAppDeveloper() {
        Allure.step("Ожидание загрузки страницы About");
        onView(isRoot()).perform(waitDisplayed(R.id.about_version_title_text_view, 10000));
        onView(allOf(withId(R.id.about_version_title_text_view), withText("1.0.0"))).check(matches(isDisplayed()));

    }

    public void displayAboutSection() {
        Allure.step("Отображение страницы About с ссылками на Privacy Policy и Terms of use");
        menuButton.perform(click());
        aboutTextButton.perform(click());
        privacyPolicyLink.check(matches(isDisplayed()));
        termsOfUseLink.check(matches(isDisplayed()));
        aboutCompany.check(matches(isDisplayed()));
        versionInfo.check(matches(isDisplayed()));
    }

    public void linkToPrivacyPolicy() {
        Allure.step("Переход к Privacy Policy");
        menuButton.perform(click());
        aboutTextButton.perform(click());
        privacyPolicyLink.perform(click());
    }

    public void linkToTermsOfUse() {
        Allure.step("Переход к Terms of use");
        menuButton.perform(click());
        aboutTextButton.perform(click());
        termsOfUseLink.perform(click());
    }

    public void backToNews() {
        Allure.step("Обратный переход в раздел News");
        menuButton.perform(click());
        aboutTextButton.perform(click());
        aboutBackButton.perform(click());
        newsOnMain.check(matches(isDisplayed()));
    }


}
