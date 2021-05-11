package com.example.core.report

import io.cucumber.core.event.Status

class ReportManager {
    private val reportModel by lazy { ReportModel() }

    fun addStatusInformation(status: Status) {
        when (status) {
            Status.FAILED -> reportModel.addFail()
            Status.PASSED -> reportModel.addPass()
            Status.SKIPPED -> reportModel.addSkip()
            Status.PENDING -> reportModel.addPending()
        }
        reportModel.addTotal()
    }

    fun calculatePercentage() {
        reportModel.calculatePassPercentage()
        reportModel.calculateFailPercentage()
    }

    fun getReportInformation(): ReportModel {
        return reportModel
    }
}