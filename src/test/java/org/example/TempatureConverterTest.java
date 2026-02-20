package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();
    double DELTA = 0.001;

    @Test
    void testFahrenheitToCelsius() {
        double result = converter.fahrenheitToCelsius(100);
        assertEquals(38, Math.round(result));
    }

    @Test
    void testCelsiusToFahrenheit() {
        double result = converter.celsiusToFahrenheit(20);
        assertEquals(68, result);
    }

    @Test
    void testExtremeTemperatureLow() {
        assertTrue(converter.isExtremeTemperature(-50));
    }

    @Test
    void testExtremeTemperatureHigh() {
        assertTrue(converter.isExtremeTemperature(60));
    }

    @Test
    void testNotExtremeTemperatureNormalRange() {
        assertFalse(converter.isExtremeTemperature(20));
    }

    @Test
    void testBoundaryValues() {
        assertFalse(converter.isExtremeTemperature(-40));
        assertFalse(converter.isExtremeTemperature(50));
    }

    @ParameterizedTest
    @CsvSource({"0, -273.15", "100, -173.15", "300, 26.85"})
    void testKelvinToCelsius(double kelvin, double celsius) {
        double result = converter.kelvinToCelsius(kelvin);
            assertEquals(celsius, result, DELTA, "kelvin to celsius failed");

    }
}
