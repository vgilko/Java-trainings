package Week3.Task2;

public class Fahrenheit extends Degree implements Convert {
    Fahrenheit (double temperature) {
        this.temperature = temperature;
    }

    @Override
    public <T extends Degree> T convert(Celsius degree) {
        return (T) new Fahrenheit(degree.getTemperature() * 1.8 + 32);
    }

    @Override
    void getDegree() {
        System.out.printf("Температура в градусах фаренгейта: %f", temperature);
    }
}
