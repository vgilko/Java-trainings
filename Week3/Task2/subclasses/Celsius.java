package Week3.Task2.subclasses;

import Week3.Task2.super_class.Degree;

public class Celsius extends Degree {
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
}
