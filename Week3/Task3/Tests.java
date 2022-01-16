package Week3.Task3;

import java.util.Random;

public class Tests {
    static void testAdding () {
        Box box = new Box(100000);
        Shape shape;
        Random random = new Random();

        do {
            int number = random.nextInt(3);

            if (number == 0)
                shape = new Pyramid(100, 120);
            else if (number == 1)
                shape = new Ball(12);
            else
                shape = new Cylinder(12, 12);

            System.out.println("Сгенерирован: " + shape);

        } while (box.add(shape));

        System.out.println(box.getShapes());
    }

    public static void main(String[] args) {
        testAdding ();
    }
}
