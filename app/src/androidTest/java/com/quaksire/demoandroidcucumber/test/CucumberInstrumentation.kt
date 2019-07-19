package com.quaksire.demoandroidcucumber.test

import android.os.Bundle
import android.support.test.runner.MonitoringInstrumentation
import com.quaksire.demoandroidcucumber.BuildConfig
import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberInstrumentationCore

/**
 * Created by Julio.
 */
@CucumberOptions(
    features = ["features"],
    glue = ["com.quaksire.demoandroidcucumber.test"])
@SuppressWarnings("unused")
class CucumberInstrumentation : MonitoringInstrumentation() {

    private val instrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)

        val tags = BuildConfig.TEST_TAGS
        if (tags.isNotEmpty()) {
            arguments?.putString("tags", tags.replace(",", "--").replace("\\s", ""))
        }

        instrumentationCore.create(arguments)
        start()
    }

    override fun onStart() {
        super.onStart()

        waitForIdleSync()
        instrumentationCore.start()
    }
}