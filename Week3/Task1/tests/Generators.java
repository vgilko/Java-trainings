package Week3.Task1.tests;

import Week3.Task1.Human;
import Week3.Task1.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generators {
    static List<String> generatePhones (int amount) {
        final boolean WITH_INVALID_PHONES = false;
        final int GENERATION_BOUND = WITH_INVALID_PHONES ? 12 : 10;

        Random random = new Random();
        List<String> phones = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            StringBuilder phone = new StringBuilder();

            for (int phoneIdx = 0; phoneIdx < 12; phoneIdx++) {
                phone.append((char)('0' + random.nextInt(GENERATION_BOUND)));
            }

            phones.add(phone.toString());
        }

        return phones;
    }

    static Human generateHuman () {
        Random random = new Random();

        StringBuilder name = new StringBuilder();

        int nameLength = random.nextInt(30) + 10;
        for (int nameIdx = 0; nameIdx < nameLength; nameIdx++) {
            name.append((char)('a' + random.nextInt(26)));
        }
        return new Human(name.toString(), random.nextInt(80), Gender.values()[random.nextInt(2)]);
    }


    static List<Human> generateHumanList (int amount) {
        List<Human> list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            list.add(generateHuman());
        }

        return list;
    }

    static List<Human> generateHumanListWithPhones (int amount) {
        Random random = new Random();
        List<Human> list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Human human = generateHuman();
            human.addPhones(generatePhones(random.nextInt(11)));
            list.add(human);

        }

        return list;
    }

}
