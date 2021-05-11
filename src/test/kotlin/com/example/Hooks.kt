package com.example

import com.example.core.DriverService
import com.example.core.PropertyManager
import io.cucumber.core.api.Scenario
import io.cucumber.core.event.Status
import io.cucumber.java.After
import io.cucumber.java.Before
import org.apache.log4j.Logger
import com.example.core.report.ReportService

class Hooks {

    @Before
    fun beforeScenario(scenario: Scenario) {
        Logger.getLogger(javaClass).info(">>>Running scenario: ${scenario.name}")
        DriverService.getInstance().get(PropertyManager.getProperty("base.url"))
    }

    @After
    fun afterScenario(scenario: Scenario) {
        Logger.getLogger(javaClass).info(">>>Ending scenario: ${scenario.name}")
        ReportService.addReportInformation(scenario)
        DriverService.dismissDriver()
    }
}