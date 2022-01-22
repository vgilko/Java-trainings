package Week4.Task1.tests;

import Week4.Task1.implementations.Ball;
import Week4.Task1.implementations.Box;
import Week4.Task1.implementations.Cylinder;
import Week4.Task1.implementations.Pyramid;
import Week4.Task1.interfaces.Shape;

import java.util.Random;

public class Tests {
    static void testAdding () {
        Box box = new Box(100000);
        Shape shape;
        Random random = new Random();

        double sum = 0;
        do {
            int number = random.nextInt(3);

            if (number == 0)
                shape = new Pyramid(100, 120);
            else if (number == 1)
                shape = new Ball(12);
            else
                shape = new Cylinder(12, 12);

            System.out.println("Сгенерирован: " + shape);
            sum += shape.getVolume();
        } while (box.add(shape));

        System.out.printf("\nОбщий объем созданных фигур: %f\n", sum);
        System.out.printf("Общий объем созданных фигур, не учитывая последнюю: %f\n", sum - shape.getVolume());
        System.out.println(box.getShapes());
    }

    public static void main(String[] args) {
        testAdding ();
    }
}
