package com.example.core.report

import com.google.gson.GsonBuilder
import io.cucumber.core.api.Scenario
import java.io.File
import java.nio.file.Paths

class ReportService {
    companion object {
        private val reportManager: ReportManager by lazy { ReportManager() }
        private const val REPORT_NAME = "report.json"

        fun addReportInformation(scenario: Scenario) {
            reportManager.addStatusInformation(scenario.status)
        }

        fun calculatePercentage(){
            reportManager.calculatePercentage()
        }

        fun publishJsonFile() {
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            val reportInformation = reportManager.getReportInformation()
            val jsonPretty: String = gsonPretty.toJson(reportInformation)
            writeJsonFile(jsonPretty)
        }

        private fun writeJsonFile(json: String) {
            val path = Paths.get("target", REPORT_NAME)
            File(path.toString()).writeText(json)
        }
    }

}