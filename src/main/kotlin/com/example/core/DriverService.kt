package com.example.core

import io.github.bonigarcia.wdm.WebDriverManager
import com.example.core.browser.Browser
import com.example.core.browser.BrowserType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL
import java.util.concurrent.TimeUnit


class DriverService {
    companion object {
        private val driver = ThreadLocal<WebDriver>()

        private fun createDriver(): WebDriver {
            val browser = BrowserType.getBrowser(PropertyManager.getProperty("browser"))
            WebDriverManager.getInstance(browser.getDriverClass()).clearDriverCache().setup()
            val driver = initDriver(browser)

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
            driver.manage().window().maximize()
            return driver
        }

        private fun initDriver(browser: Browser): WebDriver {
            val hub = PropertyManager.getProperty("driver.hub")
            return if (hub.isEmpty()) {
                browser.initDriver()
            } else {
                val caps = browser.getCapabilities()
                val url = URL(hub)
                RemoteWebDriver(url, caps)
            }
        }

        fun dismissDriver() {
            driver.get().quit()
            driver.remove()
        }

        fun getInstance(): WebDriver {
            if (driver.get() == null) {
                driver.set(createDriver())
            }
            return driver.get()
        }
    }
}