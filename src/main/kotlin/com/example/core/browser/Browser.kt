package com.example.core.browser

import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver

interface Browser {

    fun getDriverClass(): Class<out WebDriver>

    fun initDriver(): WebDriver

    fun getCapabilities(): MutableCapabilities
}