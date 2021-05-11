package com.example.core

import org.apache.log4j.Logger
import java.io.IOException
import java.util.*

class PropertyManager {
    companion object {
        private const val PROPERTY_FILE_NAME = "config.properties"
        private val properties = ThreadLocal<Properties>()

        private fun getProperties(): Properties {
            if (properties.get() == null) {
                try {
                    loadProperties()
                } catch (var1: IOException) {
                    Logger.getLogger(PropertyManager::class.java)
                        .error(">>>Properties file could not be loaded: " + var1.localizedMessage)
                    throw RuntimeException("Properties file could not be loaded")
                }
            }
            return properties.get()
        }

        fun getProperty(propertyKey: String): String {
            return getProperties().getProperty(propertyKey)?.let { configProperty -> configProperty } ?: run {
                System.getProperty(propertyKey)?.let { systemProperty -> systemProperty } ?: run {
                    throw RuntimeException("You need to declare this property in config.properties: $propertyKey")
                }
            }
        }

        @Throws(IOException::class)
        private fun loadProperties() {
            properties.set(Properties())
            val inputStream = PropertyManager::class.java.classLoader.getResourceAsStream(PROPERTY_FILE_NAME)
            properties.get()?.load(inputStream)
        }
    }
}