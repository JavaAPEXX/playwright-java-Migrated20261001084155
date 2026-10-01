```java
package com.testautomation.conf;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BaseTestTest {

    @Mock
    private Page page;

    @Mock
    private Browser browser;

    @Mock
    private Configuration configuration;

    @Mock
    private BrowserType browserType;

    @Mock
    private LaunchOptions launchOptions;

    @BeforeAll
    static void doInitialSetup() {
        // Arrange
        // Given
        // When
        // Then
        configuration = ConfigLoader.loadConfig();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(launchOptions);
        appUrl = configuration.getAppUrl();
    }

    @BeforeEach
    void createContextAndPage() {
        // Arrange
        // Given
        // When
        // Then
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 850));
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        // Arrange
        // Given
        // When
        // Then
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        // Arrange
        // Given
        // When
        // Then
        playwright.close();
    }

    @Test
    @DisplayName("givenValidInput_whenBaseTest_thenReturnSuccess()")
    void givenValidInput_whenBaseTest_thenReturnSuccess() {
        // Arrange
        // Given
        // When
        // Then
        BasePage basePage = createInstance(BasePage.class);
        basePage.execute("executeCommand").execute("executeCommand").execute("executeCommand");
        assertEquals("Success", basePage.getOutput());
    }

    @Test
    @DisplayName("givenInvalidInput_whenBaseTest_thenThrowException()")
    void givenInvalidInput_whenBaseTest_thenThrowException() {
        // Arrange
        // Given
        // When
        // Then
        BasePage basePage = createInstance(BasePage.class);
        assertThrows(Exception.class, () -> basePage.execute("executeCommand"));
    }

    @Test
    @DisplayName("givenNullInput_whenBaseTest_thenThrowException()")
    void givenNullInput_whenBaseTest_thenThrowException() {
        // Arrange
        // Given
        // When
        // Then
        BasePage basePage = createInstance(BasePage.class);
        assertThrows(Exception.class, () -> basePage.execute(null));
    }

    @Test
    @DisplayName("givenEmptyDatabase_whenBaseTest_thenReturnEmptyList()")
    void givenEmptyDatabase_whenBaseTest_thenReturnEmptyList() {
        // Arrange
        // Given
        // When
        // Then
        BasePage basePage = createInstance(BasePage.class);
        basePage.execute("executeCommand").execute("executeCommand").execute("executeCommand");
        assertEquals("", basePage.getOutput());
    }

    @Test
    @DisplayName("givenNonExistingUserId_whenGetUser_thenThrowUserNotFoundException()")
    void givenNonExistingUserId_whenGetUser_thenThrowUserNotFoundException() {
        // Arrange
        // Given
        // When
        // Then
        User user = createInstance(User.class);
        assertThrows(UserNotFoundException.class, () -> user.get("nonExistingId"));
    }

    @Test
    @DisplayName("givenValidRequest_whenCreateOrder_thenReturnCreatedOrder()")
    void givenValidRequest_whenCreateOrder_then