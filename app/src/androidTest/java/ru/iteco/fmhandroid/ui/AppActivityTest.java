package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void appActivityTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(7, click()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("���"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView.check(matches(withText("���")));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(7, click()));

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_material_card_view),
                                        0),
                                15),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("���"),
                        withParent(withParent(withId(R.id.news_item_title_text_input_layout))),
                        isDisplayed()));
        editText.check(matches(withText("���")));

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("���"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("���"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("gfgh"));

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("gfgh"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction compoundButton = onView(
                allOf(withId(R.id.sort_news_material_button),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        compoundButton.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("����"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView2.check(matches(withText("����")));

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.sort_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView4.perform(actionOnItemAtPosition(0, click()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
