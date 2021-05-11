package com.example.pages

import com.example.core.DriverService
import com.example.pages.common.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePage : BasePage() {

    @FindBy(css = "div[class='q0coyt-1 fOZYHf']")
    private var searchDiv: WebElement? = null

    @FindBy(css = "#tippy-49  input[type='text']")
    private var searchInput: WebElement? = null

    private val searchResultsLocator: By = By.cssSelector("div[role='tooltip'] a[class='cmc-link']")

    fun isDisplayed(): Boolean {
        return isVisible(searchDiv)
    }

    fun setSearchInput(searchCriteria: String) {
        click(searchDiv)
        setInput(searchInput, searchCriteria)
    }

    fun clickFirstSearchResult() {
        val result = getElements(searchResultsLocator).first()
        click(result)
    }
}