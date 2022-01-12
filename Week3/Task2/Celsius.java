package Week3.Task2;

public class Celsius extends Degree{
    private final double temperature;

    public double getTemperature () {
        return temperature;
    }

    Celsius (double temperature) {
        this.temperature = temperature;
    }

    @Override
    void getDegree() {
        System.out.printf("Температура в градусах цельсия: %f", temperature);
    }
}
