package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();

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
        assertFalse(TemperatureConverter.isExtremeTemperature(-40));
        assertFalse(TemperatureConverter.isExtremeTemperature(50));
    }
}
