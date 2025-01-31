package com.example.pages

import com.example.pages.common.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CurrencyPage : BasePage() {

    @FindBy(css = "span[data-role='coin-name']")
    private var cryptocurrencyName: WebElement? = null

    @FindBy(css = "span[data-role='coin-symbol']")
    private var cryptocurrencySymbol: WebElement? = null

    fun getName(): String? {
        waitVisible(cryptocurrencyName)
        return getText(cryptocurrencyName)?.split("\n")?.first()
    }

    fun getSymbol(): String? {
        waitVisible(cryptocurrencySymbol)
        return getText(cryptocurrencySymbol)
    }

}