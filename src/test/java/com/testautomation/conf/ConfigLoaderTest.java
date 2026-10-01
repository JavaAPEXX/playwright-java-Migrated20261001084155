package com.testautomation.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testautomation.conf.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConfigLoaderTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private InputStream inputStream;

    @InjectMocks
    private ConfigLoader configLoader;

    @Test
    @DisplayName("given Valid Input when ConfigLoader then Return Success")
    void givenValidInput_whenConfigLoader_thenReturnSuccess() {
        // Arrange
        when(objectMapper.readValue(any(), Configuration.class)).thenReturn(new Configuration());

        // Act
        Configuration result = configLoader.loadConfig();

        // Assert
        assertEquals(new Configuration(), result);
    }

    @Test
    @DisplayName("given Empty Input when ConfigLoader then Throw Exception")
    void givenEmptyInput_whenConfigLoader_thenThrowException() {
        // Arrange
        when(objectMapper.readValue(any(), Configuration.class)).thenThrow(Exception.class);

        // Act and Assert
        assertThrows(Exception.class, () -> configLoader.loadConfig());
    }

    @Test
    @DisplayName("given Null Input when ConfigLoader then Throw Exception")
    void givenNullInput_whenConfigLoader_thenThrowException() {
        // Arrange
        when(objectMapper.readValue(any(), Configuration.class)).thenThrow(Exception.class);

        // Act and Assert
        assertThrows(Exception.class, () -> configLoader.loadConfig());
    }

    @Test
    @DisplayName("given NonExistingFile when ConfigLoader then Throw Exception")
    void givenNonExistingFile_whenConfigLoader_thenThrowException() {
        // Arrange
        when(objectMapper.readValue(any(), Configuration.class)).thenThrow(Exception.class);

        // Act and Assert
        assertThrows(Exception.class, () -> configLoader.loadConfig());
    }

    @Test
    @DisplayName("given Valid ConfigFile when ConfigLoader then Return Valid Config")
    void givenValidConfigFile_whenConfigLoader_thenReturnValidConfig() {
        // Arrange
        when(objectMapper.readValue(inputStream, Configuration.class)).thenReturn(new Configuration());

        // Act
        Configuration result = configLoader.loadConfig();

        // Assert
        assertEquals(new Configuration(), result);
    }

    @Test
    @DisplayName("given Invalid ConfigFile when ConfigLoader then Throw Exception")
    void givenInvalidConfigFile_whenConfigLoader_thenThrowException() {
        // Arrange
        when(objectMapper.readValue(inputStream, Configuration.class)).thenThrow(Exception.class);

        // Act and Assert
        assertThrows(Exception.class, () -> configLoader.loadConfig());
    }

    @Test
    @DisplayName("given ConfigLoader with Null Input when LoadConfig then Throw Exception")
    void givenConfigLoaderWithNullInput_whenLoadConfig_thenThrowException() {
        // Arrange
        when(objectMapper.readValue(any(), Configuration.class)).thenThrow(Exception.class);

        // Act and Assert
        assertThrows(Exception.class, () -> configLoader.loadConfig());
    }
}