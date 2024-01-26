package org.example;

import java.util.Objects;

public class ConverterLogic {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }

    public static double performConversion(String labelText1, String labelText2, double value) {
        if (Objects.equals(labelText1, "FAHRENHEIT") && Objects.equals(labelText2, "CELSIUS")) {
            return fahrenheitToCelsius(value);
        } else if (Objects.equals(labelText1, "CELSIUS") && Objects.equals(labelText2, "FAHRENHEIT")) {
            return celsiusToFahrenheit(value);
        } else if (Objects.equals(labelText1, "CELSIUS") && Objects.equals(labelText2, "KELVIN")) {
            return celsiusToKelvin(value);
        } else if (Objects.equals(labelText1, "FAHRENHEIT") && Objects.equals(labelText2, "KELVIN")) {
            return fahrenheitToKelvin(value);
        } else if (Objects.equals(labelText1, "KELVIN") && Objects.equals(labelText2, "CELSIUS")) {
            return kelvinToCelsius(value);
        } else if (Objects.equals(labelText1, "KELVIN") && Objects.equals(labelText2, "FAHRENHEIT")) {
            return kelvinToFahrenheit(value);
        }
        // Handle other cases if needed
        return value; // Return the original value if no conversion is needed
    }
}
