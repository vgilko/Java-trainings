package Week3.Task2.subclasses;

import Week3.Task2.interfaces.Convert;
import Week3.Task2.super_class.Degree;

public class Fahrenheit extends Degree implements Convert<Fahrenheit> {
    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public Fahrenheit convert(Celsius degree) {
        return new Fahrenheit(degree.getTemperature() * 1.8 + 32);
    }

    @Override
    public void getDegree() {
        System.out.printf("Температура в градусах фаренгейта: %f", temperature);
    }
}
