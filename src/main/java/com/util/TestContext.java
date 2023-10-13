package com.util;

import com.factory.WebDriverFactory;
import com.manager.PageObjectManager;

public class TestContext {
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        pageObjectManager = new PageObjectManager(WebDriverFactory.getDriver());
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
