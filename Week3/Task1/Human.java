package Week3.Task1;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Week3.Task1.enums.Gender;

import static Week3.Task1.Util.isAllDigit;

public class Human implements Comparable {
    private String name;
    private int age;
    private Gender gender;
    private ArrayList<String> phoneBook;

    public Human(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        phoneBook = new ArrayList<>();
    }

    public Human (String name, int age, Gender gender, List<String> phones) {
        this (name, age, gender);

        addPhones(phones);
    }

    public ArrayList<String> getPhoneBook() {
        return phoneBook;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
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
            if (hasInvalidPhones(phones))
                throw new IllegalArgumentException("Неправильный формат номеров.");

            phoneBook.addAll(phones);
        }
    }

    boolean hasInvalidPhones (List<String> phones) {
        if (phones != null)
            return phones.stream()
                        .filter(x -> !isAllDigit(x))
                        .peek(x -> System.out.println("Неправильный номер: " + x))
                        .count() != 0;

        return false;
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
