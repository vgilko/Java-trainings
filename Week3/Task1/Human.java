package Week3.Task1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import Week3.Task1.enums.Gender;

import static Week3.Task1.Util.isAllDigit;

public class Human implements Comparable<Human> {
    private final String name;
    private final int age;
    private final Gender gender;
    private final List<String> phoneBook;

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

    public List<String> getPhoneBook() {
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


    @Override
    public String toString () {
        return name + " | " + gender.toString() + " | " + age;
    }


    @Override
    public int compareTo(Human human) {
        if (human == null)
            throw new NullPointerException();

        return Comparator.comparing(Human::getGender).reversed()
                            .thenComparing(Human::getAge).reversed()
                            .thenComparing(Human::getName)
                            .compare(this, human);
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

}
