package com.example.pages.common

import org.apache.log4j.Logger
import com.example.core.DriverService
import com.example.core.PropertyManager
import org.openqa.selenium.*
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

abstract class BasePage {
    init {
        PageFactory.initElements(DriverService.getInstance(), this)
    }

    private fun getWait(timeout: Long? = null): WebDriverWait {
        return timeout?.let { WebDriverWait(getDriver(), timeout) }
            ?: run { WebDriverWait(getDriver(), PropertyManager.getProperty("element.timeout").toLong()) }
    }

    private fun waitClickable(element: WebElement?) {
        getWait().until(ExpectedConditions.elementToBeClickable(element))
    }

    fun waitVisible(element: WebElement?) {
        getWait().until(ExpectedConditions.visibilityOf(element))
    }

    fun waitInvisible(element: WebElement?) {
        getWait().until(ExpectedConditions.invisibilityOf(element))
    }

    fun isVisible(element: WebElement?): Boolean {
        return try {
            element?.isDisplayed ?: false
        } catch (e: NoSuchElementException) {
            Logger.getLogger(this.javaClass).info("$ELEMENT_NOT_PRESENT: ${e.localizedMessage}")
            false
        } catch (e: StaleElementReferenceException) {
            Logger.getLogger(this.javaClass).info("$ELEMENT_NOT_PRESENT: ${e.localizedMessage}")
            false
        }
    }

    fun findElementByText(parentElement: WebElement? = null, text: String): WebElement? {
        return parentElement?.let { it.findElement(byText(text)) }
            ?: kotlin.run { getDriver().findElement(byText(text)) }
    }

    fun getElements(locator: By): List<WebElement> {
        return getDriver().findElements(locator)
    }

    private fun byText(text: String) = By.xpath("//*[text()='$text']")

    fun click(element: WebElement?) {
        waitClickable(element)
        scroll(element)
        element?.click()
    }

    fun setInput(element: WebElement?, value: String){
        element?.clear()
        element?.sendKeys(value)
    }

    fun getText(element: WebElement?): String? {
        return element?.text
    }

    private fun scroll(element: WebElement?) {
        val jse: JavascriptExecutor = getDriver() as JavascriptExecutor
        jse.executeScript("arguments[0].scrollIntoView()", element)
    }

    private fun getDriver(): WebDriver {
        return DriverService.getInstance()
    }

    companion object {
        private const val ELEMENT_NOT_PRESENT = "Element was not even present"
    }
}