package Week3.Task1;


public class Human implements Comparable {
    private String name;
    private int age;
    private Util.Gender gender;

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
