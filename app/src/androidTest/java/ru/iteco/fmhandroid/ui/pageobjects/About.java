package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class About {
    public static ViewInteraction aboutTextButton = onView(withText("About"));
    public static ViewInteraction privacyPolicyLink = onView(withText("https://vhospice.org/#/privacy-policy/"));
    public static ViewInteraction termsOfUseLink = onView(withText("https://vhospice.org/#/terms-of-use"));
    public static ViewInteraction aboutCompany = onView(withText("© I-Teco, 2022"));
    public static ViewInteraction versionInfo = onView(withText("1.0.0"));
    public static ViewInteraction aboutBackButton = onView(withId(R.id.about_back_image_button));
    public static ViewInteraction aboutUs = onView(withId(R.id.about_company_info_label_text_view));



}



