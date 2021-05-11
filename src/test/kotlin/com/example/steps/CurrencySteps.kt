package com.example.steps

import io.cucumber.java.en.Then
import com.example.pages.CurrencyPage
import org.testng.Assert

class CurrencySteps {

    private val currencyPage: CurrencyPage by lazy { CurrencyPage() }

    @Then("cryptocurrency name is {string}")
    fun isCryptocurrencyNameCorrect(name: String) {
        Assert.assertEquals(currencyPage.getName(), name, "$NAME_INCORRECT $name")
    }

    @Then("cryptocurrency symbol is {string}")
    fun isCryptocurrencySymbolCorrect(symbol: String) {
        Assert.assertEquals(currencyPage.getSymbol(), symbol, "$SYMBOL_INCORRECT $symbol")
    }

    companion object {
        private const val NAME_INCORRECT = "Cryptocurrency title is not"
        private const val SYMBOL_INCORRECT = "Cryptocurrency symbol is not"
    }
}