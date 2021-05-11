package com.example.pages

import com.example.pages.common.BasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CurrencyPage : BasePage() {

    @FindBy(css = "#__next img + h2")
    private var cryptocurrencyName: WebElement? = null

    @FindBy(css = "#__next img + h2 > small")
    private var cryptocurrencySymbol: WebElement? = null

    fun getName(): String? {
        return getText(cryptocurrencyName)?.split("\n")?.first()
    }

    fun getSymbol(): String? {
        return getText(cryptocurrencySymbol)
    }

}