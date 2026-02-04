package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TemperatureConverterTest {


    // fahrenheitToCelsius
    @Test
    void testFahrenheitToCelsiusFreezingPoint() {
        assertEquals(0.0,
                TemperatureConverter.fahrenheitToCelsius(32),
                0.001);
    }

    @Test
    void testFahrenheitToCelsiusBoilingPoint() {
        assertEquals(100.0,
                TemperatureConverter.fahrenheitToCelsius(212),
                0.001);
    }

    @Test
    void testFahrenheitToCelsiusNegative() {
        assertEquals(-40.0,
                TemperatureConverter.fahrenheitToCelsius(-40),
                0.001);
    }


    // celsiusToFahrenheit
    @Test
    void testCelsiusToFahrenheitFreezingPoint() {
        assertEquals(32.0,
                TemperatureConverter.celsiusToFahrenheit(0),
                0.001);
    }

    @Test
    void testCelsiusToFahrenheitBoilingPoint() {
        assertEquals(212.0,
                TemperatureConverter.celsiusToFahrenheit(100),
                0.001);
    }

    @Test
    void testCelsiusToFahrenheitNegative() {
        assertEquals(-40.0,
                TemperatureConverter.celsiusToFahrenheit(-40),
                0.001);
    }



    // isExtremeTemperature
    @Test
    void testExtremeTemperatureLow() {
        assertTrue(TemperatureConverter.isExtremeTemperature(-50));
    }

    @Test
    void testExtremeTemperatureHigh() {
        assertTrue(TemperatureConverter.isExtremeTemperature(60));
    }

    @Test
    void testNotExtremeTemperatureNormalRange() {
        assertFalse(TemperatureConverter.isExtremeTemperature(20));
    }

    @Test
    void testBoundaryValues() {
        assertFalse(TemperatureConverter.isExtremeTemperature(-40));
        assertFalse(TemperatureConverter.isExtremeTemperature(50));
    }
}
