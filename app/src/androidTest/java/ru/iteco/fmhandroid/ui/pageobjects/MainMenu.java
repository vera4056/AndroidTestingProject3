package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainMenu {


    public static ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction textMenuButton = onView(withText("Main"));
    public static ViewInteraction missionButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction textMissionButton = onView(withText("Our Mission"));
    public static ViewInteraction authorizationButton = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction textAuthorizationButton = onView(withText("Authorization"));
    public static ViewInteraction logoMark = onView(withId(R.id.trademark_image_view));


}