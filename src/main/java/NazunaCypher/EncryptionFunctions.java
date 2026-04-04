package NazunaCypher;

public final class EncryptionFunctions {
    public static String swapFirstAndLast(String input) {
        final char[] letters = input.toCharArray();

        final char firstLetter;
        final char lastLetter;

        firstLetter = letters[0];
        lastLetter = letters[letters.length - 1];

        letters[0] = lastLetter;
        letters[letters.length - 1] = firstLetter;

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

    public static String swapTopBottom(String input) {
        final char[] letters = input.toCharArray();
        final int length = letters.length;

        final int differenceToEven = (length % 2 != 0) ? 1 : 0;
        final int evenBound = length - differenceToEven;
        final int columns = evenBound / 2;

        // Build 2 x N matrix from the even-bound portion only
        char[][] matrix = new char[2][columns];
        for (int i = 0; i < evenBound; i++) {
            matrix[i / columns][i % columns] = letters[i];
        }

        // Swap row 0 and row 1 column
        for (int i = 0; i < columns; i++) {
            char temp = matrix[0][i];
            matrix[0][i] = matrix[1][i];
            matrix[1][i] = temp;
        }

        // Flatten matrix back into result, then append leftover tail as-is
        char[] result = new char[length];
        int idx = 0;
        for (char[] row : matrix) {
            for (char c : row) {
                result[idx++] = c;
            }
        }

        // Append any leftover characters unchanged at the end
        for (int i = evenBound; i < length; i++) {
            result[idx++] = letters[i];
        }

        return new String(result);
    }

}
