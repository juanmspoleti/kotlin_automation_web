package com.example.pages

import com.example.pages.common.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePage : BasePage() {

    @FindBy(css = "div[class*='search-input-static']")
    private var searchButton: WebElement? = null

    @FindBy(css = "div[class*='Search_container'] input[type='text']")
    private var searchInput: WebElement? = null

    @FindBy(css = "div[class*='Search_container'] a[href*='/currencies/']")
    private val searchResultsLabel: List<WebElement>? = null

    fun isDisplayed(): Boolean {
        return isVisible(searchButton)
    }

    fun setSearchInput(searchCriteria: String) {
        click(searchButton)
        waitVisible(searchInput)
        setInput(searchInput, searchCriteria)
    }

    fun clickFirstSearchResult() {
        waitToHaveRecords(searchResultsLabel)
        click(searchResultsLabel?.first())
    }
}