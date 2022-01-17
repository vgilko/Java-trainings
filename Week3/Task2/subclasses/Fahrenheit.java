package Week3.Task2.subclasses;

import Week3.Task2.interfaces.Convert;
import Week3.Task2.super_class.Degree;

public class Fahrenheit extends Degree implements Convert {
    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public <T extends Degree> T convert(Celsius degree) {
        return (T) new Fahrenheit(degree.getTemperature() * 1.8 + 32);
    }

    @Override
    public void getDegree() {
        System.out.printf("Температура в градусах фаренгейта: %f", temperature);
    }
}
