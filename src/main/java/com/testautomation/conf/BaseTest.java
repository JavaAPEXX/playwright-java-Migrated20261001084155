package com.testautomation.conf;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    static Playwright playwright;
    static Browser browser;
    protected static Configuration configuration;
    static String appUrl;
    protected BrowserContext context;
    protected Page page;

    protected <T extends BasePage> T createInstance(Class<T> basePage) {
        return PageFactory.createInstance(page, basePage);
    }

    @BeforeAll
    static void doInitialSetup() {

        configuration = ConfigLoader.loadConfig();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(configuration.isHeadlessMode())
                .setSlowMo(configuration.getSlowMo()));
        appUrl = configuration.getAppUrl();

    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 850));
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }
}
