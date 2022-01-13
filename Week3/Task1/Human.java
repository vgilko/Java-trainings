package Week3.Task1;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Week3.Task1.Util;

import static Week3.Task1.Util.isAllDigit;

public class Human implements Comparable {
    private String name;
    private int age;
    private Util.Gender gender;
    private ArrayList<String> phoneBook;

    public ArrayList<String> getPhoneBook() {
        return phoneBook;
    }


    public void addPhone (String phone) {
        if (phone != null) {
            if (!isAllDigit(phone)) {
                throw new IllegalArgumentException("Номер телефона не должен содержать ничего кроме цифр. Ошибочный номер: " + phone);
            }

            phoneBook.add(phone);
        }

    }


    public void addPhones (List<String> phones) {
        if (phones != null) {
            List<String> invalidPhones = getInvalidPhones(phones);

            if (!invalidPhones.isEmpty())
                throw new IllegalArgumentException("Неправильный формат номеров:\n" + invalidPhones);

            phoneBook.addAll(phones);
        }
    }

    List<String> getInvalidPhones (List<String> phones) {
        if (phones != null) {
            return phones.stream()
                            .filter(x -> !isAllDigit(x))
                            .peek(System.out::println)
                            .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public Util.Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    Human (String name, int age, Util.Gender gender) {
        phoneBook = new ArrayList<>();

        if (name == null)
            throw new IllegalArgumentException("Имя не задано.");

        if (age < 0)
            throw new IllegalArgumentException("Возраст не может быть отприцательным.");

        if (gender == null)
            throw new IllegalArgumentException("Пол не задан.");

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    Human (String name, int age, Util.Gender gender, List<String> phones) { // можно ли повторяющийся код как-то убрать?
        phoneBook = new ArrayList<>();

        if (name == null)
            throw new IllegalArgumentException("Имя не задано.");

        if (age < 0)
            throw new IllegalArgumentException("Возраст не может быть отприцательным.");

        if (gender == null)
            throw new IllegalArgumentException("Пол не задан.");

        if (phones != null) {
            addPhones(phones);
        } else {
            phoneBook = new ArrayList<>();
        }

        this.name = name;
        this.age = age;
        this.gender = gender;


    }

    @Override
    public String toString () {
        return name + " | " + gender.toString() + " | " + age;
    }

    @Override
    public int compareTo(Object human) {
        if (human == null)
            throw new NullPointerException();

        int result = this.getName().compareTo(((Human) human).getName());

        if (result == 0) {

            int ageComparison = 0;

            if (age > ((Human) human).getAge()) {
                ageComparison = 1;
            } else if (age < ((Human) human).getAge()) {
                ageComparison = -1;
            }

            String nameAndGenderFirst = (name + gender.ordinal()) + (-ageComparison);
            String nameAndGenderSecond = (((Human) human).getName() + ((Human) human).getGender().ordinal()) + ageComparison;

            result =  nameAndGenderFirst.compareTo(nameAndGenderSecond);
        }

        return result;
    }
}
