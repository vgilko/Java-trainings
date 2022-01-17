package Week3.Task3.implementations;

import Week3.Task3.interfaces.SolidOfRevolution;

public class Cylinder implements SolidOfRevolution {
    private final double radius,
                            height;

    private final double volume;

    public Cylinder(double radius, double height) {
        if (radius < 0)
            throw new IllegalArgumentException("Радиус не может быть отрицательным.");
        if (height < 0)
            throw new IllegalArgumentException("Высота цилиндра не может быт отрицательной.");

        this.radius = radius;
        this.height = height;

        volume = Math.PI * radius * radius * height;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getVolume();
    }
}
