package Week3.Task2;

public class Kelvin extends Degree implements Convert{

    Kelvin (double temperature) {
        this.temperature = temperature;
    }

    @Override
    public <T extends Degree> T convert(Celsius degree) {
        return (T) new Kelvin(degree.getTemperature() + 273.15);
    }

    @Override
    void getDegree() {
        System.out.printf("Температура в градусах кельвина: %f", temperature);
    }
}
