package Week3.Task2.tests;

import Week3.Task2.subclasses.Celsius;
import Week3.Task2.subclasses.Fahrenheit;
import Week3.Task2.subclasses.Kelvin;

public class Tests {
    public static void testConvert () {
        Celsius[] celsius = new Celsius[] {
                new Celsius(0),
                new Celsius(100),
                new Celsius(-100),
                new Celsius(-1),
                new Celsius(1),
                new Celsius(1.00000001),
        };

        Kelvin kelvin = new Kelvin(0);
        Fahrenheit fahrenheit = new Fahrenheit(0);

        for (Celsius cel : celsius) {
            System.out.printf("В цельсиях: %f\n", cel.getTemperature());
            System.out.printf("В кельвинах: %f\n", kelvin.convert(cel).getTemperature());
            System.out.printf("В фаренгейтах: %f\n", fahrenheit.convert(cel).getTemperature());
            System.out.println("-------");
        }
    }

    public static void main(String[] args) {
        testConvert();
    }
}
