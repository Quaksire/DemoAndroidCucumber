package com.quaksire.demoandroidcucumber.test

import android.app.Activity
import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*

import android.support.test.rule.ActivityTestRule
import com.quaksire.demoandroidcucumber.LoginActivity
import com.quaksire.demoandroidcucumber.R

import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert
import org.junit.Rule

/**
 * Created by Julio.
 */
class LoginActivitySteps {

    @Rule
    val activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    private lateinit var activity: Activity

    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
        activity = activityTestRule.activity
    }

    @After
    fun tearDown() {
        activityTestRule.finishActivity()
    }

    @Given("^A user is at the login screen")
    fun verifyActivityIsCreated() {
        Assert.assertNotNull(activity)
    }

    @When("^Insert username (.*)")
    fun insertUsername(username: String) {
        onView(withId(R.id.login_username_input))
            .check(matches(isDisplayed()))
            .perform(typeText(username))
    }

    @When("^Insert password (.*)")
    fun insertPassword(password: String) {
        onView(withId(R.id.login_password_input))
            .check(matches(isDisplayed()))
            .perform(typeText(password))
    }

    @When("^Press login button")
    fun pressLoginButton() {
        onView(withId(R.id.login_button))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    @Then("^Error message is displayed")
    fun verifyErrorMessageIsDisplayed() {
        onView(withText(R.string.login_fail))
            .check(matches(isDisplayed()))
    }

    @Then("^Success message is displayed")
    fun verifySuccessMessageIsDisplayed() {
        onView(withText(R.string.login_success))
            .check(matches(isDisplayed()))
    }
}