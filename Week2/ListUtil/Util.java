package Week2.ListUtil;

import java.beans.IntrospectionException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Util {

    /**
     * Ищет первое число больше введенного
     *
     * @param values список с данными
     * @param valueToFind число для поиска
     * @return valueToFind если число не найдено, иначе NoSuchElementException.
     *
     * @throws IllegalArgumentException если список пустой или неинициализированный.
     * */
    public static int findFirstOverValue (List<Integer> values, int valueToFind) throws IllegalArgumentException, NoSuchElementException {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Невозможно обработать пустой или неинициализированный список.");
        }

        int result = values.stream().filter(x -> x > valueToFind).findFirst().get();
        System.out.println(result);

        return result;
    }

    /**
     * Ищет все числа больше введенного
     *
     * @param values список с данными
     * @param valueToFind число для поиска
     * @return пустой список, если число не найдено; иначе первое число больше заданного.
     *
     * @throws IllegalArgumentException если список пустой или неинициализированный.
     * */
    public static List<Integer> findAllOverValue (List<Integer> values, int valueToFind) throws IllegalArgumentException {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Невозможно обработать пустой или неинициализированный список.");
        }

        List<Integer> result = IntStream.range(0, values.size()).filter(i -> values.get(i) > valueToFind).mapToObj(values::get).sorted().collect(Collectors.toList());

        System.out.println(result);

        return result;
    }


    /**
     * Ищет среднее значение по списку
     *
     * @param values список с данными

     * @return среднее значение элементов списка
     *
     * @throws IllegalArgumentException если список пустой или неинициализированный.
     * */
    public static double getListAverage (List<Integer> values) throws IllegalArgumentException {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Невозможно обработать пустой или неинициализированный список.");
        }

        return IntStream.range(0, values.size()).map(values::get).average().getAsDouble();// average().getAsDouble();
    }


    /**
     * Умножает каждое число на коэффициент и ищет сумму
     *
     * @param values список с данными
     * @param coefficient множитель

     * @return сумму всех значений, уееличенных в coefficient раз
     *
     * @throws IllegalArgumentException если список пустой или неинициализированный.
     * */
    public static long getSumOfProportionallyEnlarged (List<Integer> values, int coefficient) throws IllegalArgumentException {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Невозможно обработать пустой или неинициализированный список.");
        }

        return (long) IntStream.range(0, values.size()).map(values::get).sum() * coefficient;
    }


    /**
     * Ищет заданное число в списке
     *
     * @param values список с данными
     * @param valueToFind число для поиска
     *
     * @return заданное число, иначе NoSuchElementException
     *
     * @throws IllegalArgumentException если список пустой или неинициализированный.
     * */
    public static int findValue (List<Integer> values, int valueToFind) throws IllegalArgumentException, NoSuchElementException {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Невозможно обработать пустой или неинициализированный список.");
        }

        return values.stream().filter(x -> x == valueToFind).findAny().get();
    }


    /**
     * Ищет заданное число в списке
     *
     * @param values список с данными
     * @param valueToFind число для поиска
     *
     * @return заданное число, иначе 0
     *
     * @throws IllegalArgumentException если список пустой или неинициализированный.
     * */
    public static int getValue (List<Integer> values, int valueToFind) throws IllegalArgumentException {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Невозможно обработать пустой или неинициализированный список.");
        }

        Optional<Integer> result = values.stream().filter(x -> x == valueToFind).findFirst();

        return result.orElse(0);
    }
}
