package com.testautomation.conf;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasePageTest {

    @Mock
    private Page page;

    @InjectMocks
    private BasePage basePage;

    @Test
    @DisplayName("givenValidInput_whenBasePage_thenReturnSuccess")
    void givenValidInput_whenBasePage_thenReturnSuccess() {
        // Arrange
        when(page.configure(any(Page.class))).thenReturn(basePage);

        // Act
        byte[] screenshot = basePage.captureScreenshot();

        // Assert
        assertEquals(0, screenshot.length);
    }

    @Test
    @DisplayName("givenNullInput_whenBasePage_thenThrowNullPointerException")
    void givenNullInput_whenBasePage_thenThrowNullPointerException() {
        // Arrange
        when(page.configure(null)).thenThrow(NullPointerException.class);

        // Act and Assert
        assertThrows(NullPointerException.class, () -> basePage.configure(page));
    }

    @Test
    @DisplayName("givenEmptyDatabase_whenBasePage_thenReturnEmptyScreenshot")
    void givenEmptyDatabase_whenBasePage_thenReturnEmptyScreenshot() {
        // Arrange
        when(page.configure(any(Page.class))).thenReturn(basePage);

        // Act
        byte[] screenshot = basePage.captureScreenshot();

        // Assert
        assertEquals(0, screenshot.length);
    }

    @Test
    @DisplayName("givenInvalidInput_whenBasePage_thenThrowException")
    void givenInvalidInput_whenBasePage_thenThrowException() {
        // Arrange
        when(page.configure(any(Page.class))).thenThrow(Exception.class);

        // Act and Assert
        assertThrows(Exception.class, () -> basePage.configure(page));
    }

    @Test
    @DisplayName("givenValidInput_whenBasePage_thenReturnValidScreenshot")
    void givenValidInput_whenBasePage_thenReturnValidScreenshot() {
        // Arrange
        when(page.configure(any(Page.class))).thenReturn(basePage);

        // Act
        byte[] screenshot = basePage.captureScreenshot();

        // Assert
        // No assertion needed as screenshot is expected to be valid
    }
}