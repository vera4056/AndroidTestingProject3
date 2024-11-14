package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class News {
    public static ViewInteraction newsOnMain = onView(withText("News"));
    public static ViewInteraction allNewsLayout = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction newsCardButton = onView(withId(R.id.news_item_material_card_view));
    public static ViewInteraction descriptionText = onView(allOf(withId(R.id.news_item_description_text_input_edit_text)));
    public static ViewInteraction materialTextView = onView(allOf(withId(android.R.id.title), withText("News")));
    public static ViewInteraction editNewsButton = onView(allOf(withId(R.id.edit_news_material_button)));
    public static ViewInteraction addNewsButton = onView(allOf(withId(R.id.add_news_image_view)));
    public static ViewInteraction titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction categoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction publishDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction timeText = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction newsFilterButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction checkableImageButton = onView(allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public static ViewInteraction cancelFilterButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction titleTextView = onView(withId(R.id.news_item_title_text_view));
    public static ViewInteraction deleteButton = onView(withId(R.id.delete_news_item_image_view));
    public static ViewInteraction okButtonMessage = onView(withText("OK"));
    public static ViewInteraction viewButton = onView(withId(R.id.view_news_item_image_view));
    public static ViewInteraction recyclerView = onView(withId(R.id.news_list_recycler_view));
}

