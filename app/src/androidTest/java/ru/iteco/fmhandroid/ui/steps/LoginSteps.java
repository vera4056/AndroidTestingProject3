package ru.iteco.fmhandroid.ui.steps;

import static android.os.Build.VERSION_CODES.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.latency.ViewMatcherLatency.waitDisplayed;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.authorization;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.emptyAuthField;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.emptyAuthorization;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.enterButton;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.loginFieldText;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.passwordFieldId;
import static ru.iteco.fmhandroid.ui.pageobjects.LogIn.wrongAuthorization;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;

import ru.iteco.fmhandroid.R;

public class LoginSteps {

    public void waitAuthorizationPage() {
        Allure.step("Загрузка страницы авторизации");
        onView(isRoot()).perform(waitDisplayed(R.id.enter_button, 15000));
        onView(allOf(withId(R.id.enter_button), withText("SIGN IN"))).check(matches(isDisplayed()));


    }

    public void isLogInElements() {
        Allure.step("Проверка наличия данных авторизации");
        authorization.check(matches(isDisplayed()));
        loginFieldText.check(matches(isDisplayed()));
        passwordFieldId.check(matches(isDisplayed()));
        enterButton.check(matches(isDisplayed()));

    }

    public void validLogin() {
        Allure.step("Авторизация с валидными данными");
        loginFieldText.perform(typeText("login2"), closeSoftKeyboard());
        passwordFieldId.perform(typeText("password2"), closeSoftKeyboard());
        enterButton.perform(click());

    }


    public void invalidLoginOrPassword() {
        Allure.step("Авторизация с невалидными данными, тест должен падать");
        loginFieldText.perform(typeText("login3"), closeSoftKeyboard());
        passwordFieldId.perform(typeText("password3"), closeSoftKeyboard());
        enterButton.perform(click());


    }

    public void emptyLoginData() {
        Allure.step("Авторизация с пустым полем логин и паролем");
        enterButton.perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 10_000));

    }
}




