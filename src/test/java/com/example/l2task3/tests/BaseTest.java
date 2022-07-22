package com.example.l2task3.tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected final ISettingsFile testData = new JsonSettingsFile("testData.json");

    @BeforeMethod
    protected void before() {
        ISettingsFile urls = new JsonSettingsFile("urls.json");
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(urls.getValue("/mainUrl").toString());
    }

    @AfterMethod
    protected void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
