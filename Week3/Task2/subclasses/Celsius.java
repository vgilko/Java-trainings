package Week3.Task2.subclasses;

import Week3.Task2.interfaces.Convert;
import Week3.Task2.super_class.Degree;

public class Celsius extends Degree implements Convert<Celsius> {
    private final double temperature;

    public double getTemperature () {
        return temperature;
    }

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void getDegree() {
        System.out.printf("Температура в градусах цельсия: %f", temperature);
    }

    @Override
    public Celsius convert(Celsius temperature) {
        return temperature;
    }
}
