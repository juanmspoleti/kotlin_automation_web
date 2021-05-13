package com.example

import io.cucumber.testng.AbstractTestNGCucumberTests
import com.example.core.report.ReportService
import org.testng.annotations.AfterClass

class TestNGRunner : AbstractTestNGCucumberTests() {

    @AfterClass
    fun finish() {
        ReportService.calculatePercentage()
        ReportService.publishJsonFile()
    }
}