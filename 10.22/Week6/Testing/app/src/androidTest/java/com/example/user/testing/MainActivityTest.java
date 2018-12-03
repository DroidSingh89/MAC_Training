package com.example.user.testing;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.rule.ActivityTestRule;

public class MainActivityTest {


    private String stringTobeTyped;

    @Before
    public void setUp() throws Exception {

        stringTobeTyped = "Sample text";
    }

    @After
    public void tearDown() throws Exception {
    }

//    Rule is used for launching the activity we are testing
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void updateTextView1() {

        //type text in the etMain
        onView(withId(R.id.etMain)).perform(typeText(stringTobeTyped));

        //perform button click
        onView(withId(R.id.btnMain)).perform(click());


        //assert the text on tvMain
        onView(withId(R.id.tvMain)).check(matches(withText(stringTobeTyped)));

    }
}