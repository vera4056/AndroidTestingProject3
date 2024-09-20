package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class News {
    public static ViewInteraction newsOnMain = onView(withText("News"));
    public static ViewInteraction  allNewsLayout = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction newsCardButton = onView(withId(R.id.news_item_material_card_view));
    public static ViewInteraction newsDescription = onView(withId(R.id.news_item_description_text_view));
    public static ViewInteraction allNewsCardsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction addNewsButton = onView(withText("Add news button"));
    public static ViewInteraction categoryButton = onView(withText("Show dropdown menu"));
    public static ViewInteraction categoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction newsTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction newsDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction newsTime = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction newsFillDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction createdNewsDateView = onView(withId(R.id.news_item_publication_date_text_view));
    public static ViewInteraction newsDeleteButton = onView(withId(R.id.delete_news_item_image_view));
    public static ViewInteraction  confirmationButton = onView(withId(android.R.id.button1));
    public static ViewInteraction doesNotExist = onView(withText("На удаление"));
    public static ViewInteraction changeTitle = onView(withText("Тест"));
    public static ViewInteraction addDescription = onView(withText("Новая новость"));


}

