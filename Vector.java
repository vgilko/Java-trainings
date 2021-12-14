import java.util.Random;

public class Vector extends Object{
    private double x, y, z;
    private double length;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        calculate_length();
    }

    
    private void calculate_length() {
        length = Math.sqrt(x*x + y*y + z*z);
    }

    /** Возвращает массив координат в формате {x,y,z}
     */
    public double[] getCoordinates() {
        return new double[] {x,y,z};
    }

    

    public double length() {
        return length;
    }

    public double scalarProduct(Vector another) {
        double[] anotherVectorCoords = another.getCoordinates();
        double product = x*anotherVectorCoords[0] + y*anotherVectorCoords[1] + z*anotherVectorCoords[2];

        return product;
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
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(' ').append(y).append(' ').append(z);
        return sb.toString();
    }
}