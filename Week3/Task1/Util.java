package Week3.Task1;

public class Util {
    public static boolean isAllDigit (String input) {
        if (input == null) {
            return false;
        }

        return input.trim()
                .chars()
                .allMatch(Character::isDigit);
    }
}
