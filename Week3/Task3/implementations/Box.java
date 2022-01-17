package Week3.Task3.implementations;

import Week3.Task3.interfaces.Shape;

import java.util.ArrayList;

public class Box implements Shape {
    private final double volume;
    private double currentVolume;

    private final ArrayList<Shape> shapes;

    public Box(double boxVolume) {
        if (boxVolume < 0)
            throw new IllegalArgumentException("Объем коробки не может быть отрицательным.");

        volume = boxVolume;
        shapes = new ArrayList<>();
    }

    public boolean add (Shape shape) {
        if (getVolumeRemains () - shape.getVolume() <= 0)
            return false;

        shapes.add(shape);
        currentVolume += shape.getVolume();
        return true;
    }


    @Override
    public double getVolume() {
        return volume;
    }

    public double getVolumeRemains () {
        return getVolume() - currentVolume;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
