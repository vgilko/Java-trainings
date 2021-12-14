import java.util.Random;

/*Написать программу, которая будет рандомно заканчиваться одним из трёх исключений. (
    для исключений необходимо смоделировать ситуации)
*/

public class Task3 {
    public static void calculateArraySum() {
        int[] array = new int[100];
        int sum = 0;
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            array[i] = rand.nextInt();
        }

        for (int i = 0; i <= 100; i++) {
            sum += array[i];
        }

        System.out.printf("Сумма элементов массива: %d", sum);

    }

    public static class Printer {
        private String name;
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void print() {
            printString(name);
        }
    
        private void printString(String s) {
            System.out.println(s + " (" + s.length() + ")");
        }
    }


    public static void exc3() {
        exc3();
    }

    public static void exc2() {
        Printer p = new Printer();
        p.print();
    }
    

    public static void main(String[] args) {
        Random rand = new Random();
        int value = rand.nextInt() % 3;

        if (value == 0) {
            calculateArraySum();
        } else if (value == 1) {
            exc2();
        } else {
            exc3();
        }
    }
}
