package com.example.zjazd2;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CalorieCalculatorActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCalculateCalories() {
        // change screen
        Espresso.onView(ViewMatchers.withId(R.id.navigation_notifications))
                .perform(ViewActions.click());

        // Enter weight
        Espresso.onView(ViewMatchers.withId(R.id.weightEditText))
                .perform(ViewActions.typeText("70"), ViewActions.closeSoftKeyboard());

        // Enter height
        Espresso.onView(ViewMatchers.withId(R.id.heightEditText))
                .perform(ViewActions.typeText("175"), ViewActions.closeSoftKeyboard());

        // Enter age
        Espresso.onView(ViewMatchers.withId(R.id.ageEditText))
                .perform(ViewActions.typeText("30"), ViewActions.closeSoftKeyboard());

        // Select gender
        Espresso.onView(ViewMatchers.withId(R.id.maleRadioButton))
                .perform(ViewActions.click());

        // Check result
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Daily calorie intake: 2034.80")));
    }
}