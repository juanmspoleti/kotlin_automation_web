package com.example.core.report

data class ReportModel(
    var total: Long = 0L,
    var pass: Long = 0L,
    var fail: Long = 0L,
    var skip: Long = 0L,
    var pending: Long = 0L,
    var pass_percentage: String = "0%",
    var fail_percentage: String = "0%"
) {
    fun addTotal() {
        total += 1
    }

    fun addPass() {
        pass += 1
    }

    fun addFail() {
        fail += 1
    }

    fun addSkip() {
        skip += 1
    }

    fun addPending() {
        pending += 1
    }

    fun calculatePassPercentage(){
        val percentage: Long = (pass * 100) / total
        pass_percentage = "$percentage%"
    }

    fun calculateFailPercentage(){
        val percentage: Long = (fail * 100) / total
        fail_percentage = "$percentage%"
    }
}


