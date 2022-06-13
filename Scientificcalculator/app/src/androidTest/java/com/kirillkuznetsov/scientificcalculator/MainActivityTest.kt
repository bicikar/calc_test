package com.kirillkuznetsov.scientificcalculator

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

import org.junit.Rule
import androidx.test.rule.ActivityTestRule

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_window() {
        onView(withId(R.id.b1)).perform(click())
        onView(withId(R.id.bplus)).perform(click())
        onView(withId(R.id.b3)).perform(click())
        onView(withId(R.id.bminus)).perform(click())
        onView(withId(R.id.b2)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("1+3-2")))
        onView(withId(R.id.bequal)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("2.0")))
        onView(withId(R.id.idTVSecondary)).check(matches(withText("1+3-2")))
    }

    @Test
    fun test_button_c() {
        onView(withId(R.id.b1)).perform(click())
        onView(withId(R.id.bplus)).perform(click())
        onView(withId(R.id.b3)).perform(click())
        onView(withId(R.id.bequal)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("4.0")))
        onView(withId(R.id.bc)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("4.")))
        onView(withId(R.id.idTVSecondary)).check(matches(withText("1+3")))
    }

    @Test
    fun test_button_ac() {
        onView(withId(R.id.b1)).perform(click())
        onView(withId(R.id.bplus)).perform(click())
        onView(withId(R.id.b3)).perform(click())
        onView(withId(R.id.bequal)).perform(click())
        onView(withId(R.id.bac)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("")))
        onView(withId(R.id.idTVSecondary)).check(matches(withText("")))
    }

    @Test
    fun test_cos() {
        onView(withId(R.id.bcos)).perform(click())
        onView(withId(R.id.b0)).perform(click())
        onView(withId(R.id.bequal)).perform(click())
        onView(withId(R.id.idTVSecondary)).check(matches(withText("cos0")))
        onView(withId(R.id.idTVprimary)).check(matches(withText("1.0")))
    }

    @Test
    fun test_cos_square() {
        onView(withId(R.id.bcos)).perform(click())
        onView(withId(R.id.bbrac1)).perform(click())
        onView(withId(R.id.b0)).perform(click())
        onView(withId(R.id.bbrac2)).perform(click())
        onView(withId(R.id.bsquare)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("1.0")))
    }

    @Test
    fun test_inv() {
        onView(withId(R.id.b1)).perform(click())
        onView(withId(R.id.b0)).perform(click())
        onView(withId(R.id.binv)).perform(click())
        onView(withId(R.id.bequal)).perform(click())
        onView(withId(R.id.idTVprimary)).check(matches(withText("0.1")))
        onView(withId(R.id.idTVSecondary)).check(matches(withText("10^(-1)")))
    }

}