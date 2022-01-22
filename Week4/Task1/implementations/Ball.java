package Week4.Task1.implementations;

import Week4.Task1.interfaces.SolidOfRevolution;

public class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        if (radius < 0)
            throw new IllegalArgumentException("Радиус не может быть меньше нуля.");

        this.radius = radius;

        this.volume = 4 / 3.f * Math.PI * radius * radius * radius;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getVolume();
    }
}
