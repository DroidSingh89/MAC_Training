package com.example.user.testing;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by singh on 1/5/18.
 */

public class MainActivityTest {

    String stringToBeTyped;

    @Before
    public void setup() {
        stringToBeTyped = "String to be typed";

    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void should_update_textView() {

        //type the text in the edittext
        onView(withId(R.id.editText))
                .perform(typeText(stringToBeTyped)
                        , ViewActions.closeSoftKeyboard());


        //perform button click
        onView(withId(R.id.button))
                .perform(click());

        //check if the textview has the text
        onView(withId(R.id.textView))
                .check(matches(withText(stringToBeTyped)));


    }


}
