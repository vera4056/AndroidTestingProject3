package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LoveIsAll {
    public static ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction missionTextButton = onView(withText("Our Mission"));
    public static ViewInteraction missionBackgroundImage = onView(withText("app background image"));
    public static ViewInteraction missionTitle = onView(withText("Love is all"));
    public static ViewInteraction openCloseCardButton = onView(withId(R.id.our_mission_item_material_card_view));
    public static ViewInteraction missionTitleText = onView(withId(R.id.our_mission_item_title_text_view));
    public static ViewInteraction missionDescriptionText = onView(withId(R.id.our_mission_item_description_text_view));


}
