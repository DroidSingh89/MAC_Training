package com.example.user.testing;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by singh on 12/5/17.
 */

public class MainActivityTest {

    String stringToBeTyped;

    @Before
    public void setup(){
        stringToBeTyped = "this is the string";
    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void should_update_textview(){

        onView(withId(R.id.etName))
                .perform(typeText(stringToBeTyped)
                , ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnUpdateText))
                .perform(click());

        onView(withId(R.id.tvName))
                .check(matches(withText(stringToBeTyped)));


    }

}
