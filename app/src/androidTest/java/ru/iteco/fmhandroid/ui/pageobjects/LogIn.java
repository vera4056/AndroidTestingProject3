package ru.iteco.fmhandroid.ui.pageobjects;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class LogIn {

    public static ViewInteraction loginFieldText = onView(withHint("Login"));
    public static ViewInteraction  passwordFieldId = onView(withHint("Password"));
    /*
    public static ViewInteraction  passwordFieldId = onView(withId(R.id.password_text_input_layout)); */
    public static ViewInteraction  enterButton = onView(allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save")));
    public static ViewInteraction  mainFragment = onView(withId(R.id.container_list_news_include_on_fragment_main));
    public static ViewInteraction wrongAuthorization = onView(allOf(withText("Wrong login or password")));
    public static ViewInteraction emptyAuthorization = onView(allOf(withText("Login or password cannot be empty")));
    public static ViewInteraction emptyAuthField = onView(withText(R.string.empty_login_or_password));
    public static ViewInteraction authorization = onView(allOf(withText("Authorization"),withParent(withParent(withId(R.id.nav_host_fragment)))));
    public static ViewInteraction authorizationButton = onView(withId(R.id.authorization_image_button));


}
