package com.example.user.testing;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void updateTextView() {

//        find the edittext and update test
        onView(withId(R.id.etMain))
                .perform(replaceText("s"), closeSoftKeyboard());

//        perform the button click
        onView(withId(R.id.btnMain))
                .perform(click());

//        assert the textview for the text entered
        onView(withId(R.id.tvMain))
                .check(matches(withText("s")));
    }
}