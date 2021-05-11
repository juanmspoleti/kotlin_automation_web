package com.example.core.browser

import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType

class Firefox : Browser {
    override fun getDriverClass(): Class<out WebDriver> {
        return FirefoxDriver::class.java
    }

    override fun initDriver(): WebDriver {
        return FirefoxDriver()
    }

    override fun getCapabilities(): MutableCapabilities {
        val caps = FirefoxOptions()
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
        return caps
    }
}