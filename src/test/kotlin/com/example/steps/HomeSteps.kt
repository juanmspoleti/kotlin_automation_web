package com.example.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.testng.Assert
import com.example.pages.HomePage

class HomeSteps {

    private val homePage: HomePage by lazy { HomePage() }

    @Given("homepage is displayed")
    fun isHomePageDisplayed() {
        Assert.assertTrue(homePage.isDisplayed(), PAGE_NOT_DISPLAYED)
    }

    @When("do the search process with {string}")
    fun doSearchProcess(searchCriteria: String) {
        homePage.setSearchInput(searchCriteria)
        homePage.clickFirstSearchResult()
    }

    companion object {
        private const val PAGE_NOT_DISPLAYED = "Homepage is not visible."
    }
}