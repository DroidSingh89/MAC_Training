package com.example.user.testing;

import android.content.Intent;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by singh on 8/29/17.
 */

public class MainActivityTest {

    int Number1 = 0;
    int Number2 = 0;
    private int result;

    public static final String PACKAGE_NAME = "com.example.user.testing";

//    @Rule
//    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
//
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);



    @Before
    public void setup(){
        Number1 = 9;
        Number2 = 9;
        result = 23;
    }

    @Test
    public void testing_addition_views(){
        onView(withId(R.id.etNumber1))
                .perform(typeText(String.valueOf(Number1)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etNumber2))
                .perform(typeText(String.valueOf(Number2)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnAddition))
                .perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText(String.valueOf(result))));
    }



    @Test
    public void testing_intentValueForTheResult(){
        onView(withId(R.id.etNumber1))
                .perform(typeText(String.valueOf(Number1)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etNumber2))
                .perform(typeText(String.valueOf(Number2)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnAddition))
                .perform(click());

        onView(withId(R.id.btnToSecond))
                .perform(click());


        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage(PACKAGE_NAME),
        hasExtra(MainActivity.KEY_RESULT, String.valueOf(23))));


    }

}
