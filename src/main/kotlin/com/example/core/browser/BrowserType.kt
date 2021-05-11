package com.example.core.browser

enum class BrowserType : BrowserTypeInterface {
    CHROME {
        override fun getBrowser(): Browser {
            return Chrome()
        }
    },
    FIREFOX {
        override fun getBrowser(): Browser {
            return Firefox()
        }
    };

    companion object {
        fun getBrowser(browser: String): Browser {
            val browserType = values().firstOrNull { it.name.equals(browser, true) }
            return browserType?.getBrowser() ?: kotlin.run { throw RuntimeException("Browser $browser was not found. Available: ${values()}") }
        }
    }
}