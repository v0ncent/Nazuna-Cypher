package NazunaCypher;

public final class EncryptionFunctions {
    public enum Mode {
        ENCRYPT,
        DECRYPT
    }

    public static String swapFirstAndLast(Mode mode, String input) {
        final char[] letters = input.toCharArray();

        final char firstLetter;
        final char lastLetter;

        if (mode == Mode.ENCRYPT) {
            firstLetter = letters[0];
            lastLetter = letters[letters.length - 1];

            letters[0] = lastLetter;
            letters[letters.length - 1] = firstLetter;
        } else {
            firstLetter = letters[letters.length - 1];
            lastLetter = letters[0];

            letters[0] = firstLetter;
            letters[letters.length - 1] = lastLetter;
        }

        final StringBuilder result = new StringBuilder();
        for (char letter : letters) {
            result.append(letter);
        }

        return result.toString();
    }

    public static String reverse(String input) {
        final char[] letters = input.toCharArray();
        final StringBuilder result = new StringBuilder();

        for (int i = letters.length - 1; i >= 0; i--) {
            result.append(letters[i]);
        }

        return result.toString();
    }

}
