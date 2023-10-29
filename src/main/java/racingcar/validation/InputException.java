package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public final class InputException {

    public static String carNameValidation(final String input) {
        blank(input);
        containsBlank(input);
        noCarName(input);
        carNameLengthOver(input);
        carNameDuplicate(input);

        return input;
    }

    public static String numberValidation(final String input) {
        blank(input);
        notNumber(input);
        underZero(input);

        return input;
    }

    private static void blank(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Blank Input");
        }
    }

    private static void containsBlank(final String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("Contains Blank Input");
        }
    }

    private static void noCarName(final String input) {
        if (input.matches("^,.*") || input.matches(".*,$")) {
            throw new IllegalArgumentException("No Car Name");
        }
    }

    private static void carNameLengthOver(final String input) {
        for (String carName : input.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car Name Length Over");
            }
        }
    }

    private static void carNameDuplicate(final String input) {

        final Set<String> uniqueCarName = new HashSet<>();

        for (String carName : input.split(",")) {
            if (!uniqueCarName.add(carName)) {
                throw new IllegalArgumentException("Car Name Duplicated");
            }
        }
    }

    private static void notNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Not a Number");
        }
    }

    private static void underZero(final String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("Under Zero");
        }
    }
}
