package Week4.Task1.implementations;

import Week4.Task1.interfaces.Shape;

public class Pyramid extends Shape {
    private final double baseSquare;
    private final double height;
    private final double volume;

    public Pyramid(double baseSquare, double height) {
        if (baseSquare < 0)
            throw new IllegalArgumentException("Площадь основания пирамиды не может быть отрицательной.");
        if (height < 0)
            throw new IllegalArgumentException("Высота пирамиды нне может быть не может быть отрицательной.");

        this.baseSquare = baseSquare;
        this.height = height;

        this.volume = 1/3f * baseSquare * height;
    }


    @Override
    public double getVolume() {
        return volume;
    }

    public double getBaseSquare() {
        return baseSquare;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + getVolume();
    }
}
