package ru.iteco.fmhandroid.ui.pageobjects;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LogOut {

    public static ViewInteraction authImage = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction logOutButton = onView(allOf(withId(android.R.id.title), withText("Log out")));
    public static ViewInteraction checkLogOut = onView(withId(R.id.nav_host_fragment));


}


