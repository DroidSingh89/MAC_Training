package com.example.user.testing;

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
 * Created by singh on 10/3/17.
 */

public class MainActivityTest {


    int firstNumber = 0;
    int secondNumber= 0;
    int actualResult = 0;

    @Before
    public void setup(){

        firstNumber = 10;
        secondNumber = 20;
        actualResult = 30;

    }

    //starts the activity on the emulator/physical device to test the UIs
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void should_test_addition_of_input_numbers(){

        //typing the value firstNumber in etFirstNumber
        onView(withId(R.id.etFirstNumber))
                .perform(typeText(String.valueOf(firstNumber)),
                        ViewActions.closeSoftKeyboard());

        //typing the value secondNumber in etSecondNumber
        onView(withId(R.id.etSecondNumber))
                .perform(typeText(String.valueOf(secondNumber)),
                        ViewActions.closeSoftKeyboard());

        //perform button click for adding the input values
        onView(withId(R.id.btnAddition))
                .perform(click());


        //create an assertion for the addition function
        onView(withId(R.id.tvResult))
                .check(matches(withText(String.valueOf(actualResult))));



    }





}
