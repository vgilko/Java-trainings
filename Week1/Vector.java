package Week1;

import java.util.Random;

public class Vector {
    private final double x, y, z;
    private double length;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getLength() {
        return length;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        calculate_length();
    }

    private void calculate_length() {
        length = Math.sqrt(x*x + y*y + z*z);
    }

    public double scalarProduct(Vector another) {
        return x*another.getX() + y* another.getY() + z*another.getZ();
    }

    public static Vector[] generateRandomVectors(int amount) throws RuntimeException {
        if (amount < 0) {
            throw new RuntimeException("Количество векторов в массиве не может быть отрицательным числом.");
        }

        Vector[] vectors = new Vector[amount];
        Random rand = new Random();

        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        }

        return vectors;
    }


    @Override
    public String toString() {
        return String.valueOf(x) + ' ' + y + ' ' + z;
    }
}