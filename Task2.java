/**2.Создать класс, который описывает вектор (в трёхмерном пространстве). У него должны быть:

конструктор с параметрами в виде списка координат x, y, z 
метод, вычисляющий длину вектора. 
метод, вычисляющий скалярное произведение 
статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N. 
 * 
*/

public class Task2 {

    public static void main(String[] args) {
        Vector vec = new Vector(0,0,0);
        System.out.println(vec.length());
        System.out.println(vec.getCoordinates());

        Vector another = new Vector(1,-1,1);
        System.out.println(vec.scalarProduct(another));


        Vector[] v = Vector.generateRandomVectors(123);

        for (Vector val : v) {
            System.out.println(val);
        }
    }
}
