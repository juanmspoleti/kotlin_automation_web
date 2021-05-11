package com.example.core.browser

import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.CapabilityType

class Chrome : Browser {
    override fun getDriverClass(): Class<out WebDriver> {
        return ChromeDriver::class.java
    }

    override fun initDriver(): WebDriver {
        return ChromeDriver()
    }

    override fun getCapabilities(): MutableCapabilities {
        val caps = ChromeOptions()
        caps.addArguments("--allow-insecure-localhost")
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true)
        return caps
    }
}