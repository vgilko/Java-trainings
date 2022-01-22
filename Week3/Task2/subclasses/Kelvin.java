package Week3.Task2.subclasses;

import Week3.Task2.interfaces.Convert;
import Week3.Task2.super_class.Degree;

public class Kelvin extends Degree implements Convert<Kelvin> {

    public Kelvin(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public Kelvin convert(Celsius degree) {
        return new Kelvin(degree.getTemperature() + 273.15);
    }

    @Override
    public void getDegree() {
        System.out.printf("Температура в градусах кельвина: %f", temperature);
    }
}
