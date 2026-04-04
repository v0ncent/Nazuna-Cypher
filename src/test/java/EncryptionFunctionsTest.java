import NazunaCypher.EncryptionFunctions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EncryptionFunctions")
class EncryptionFunctionsTest {

    // -------------------------------------------------------------------------
    // swapFirstAndLast
    // -------------------------------------------------------------------------
    @Nested
    @DisplayName("swapFirstAndLast()")
    class SwapFirstAndLast {

        @Test
        @DisplayName("swaps first and last characters of a normal string")
        void swapsFirstAndLast() {
            assertEquals("HELLOWORLD".charAt(9) + "ELLOWORL" + "HELLOWORLD".charAt(0),
                    // cleaner to just spell it out:
                    "DELLOWORLH", EncryptionFunctions.swapFirstAndLast("HELLOWORLD"));
        }

        @Test
        @DisplayName("two-character string swaps both characters")
        void twoCharString() {
            assertEquals("BA", EncryptionFunctions.swapFirstAndLast("AB"));
        }

        @Test
        @DisplayName("single character string returns same character")
        void singleChar() {
            assertEquals("A", EncryptionFunctions.swapFirstAndLast("A"));
        }

        @Test
        @DisplayName("string with identical first and last returns unchanged")
        void sameFirstAndLast() {
            assertEquals("ABCDA", EncryptionFunctions.swapFirstAndLast("ABCDA"));
        }

        @Test
        @DisplayName("is self-inverse — applying twice returns original")
        void selfInverse() {
            String original = "HELLOWORLD";
            assertEquals(original,
                    EncryptionFunctions.swapFirstAndLast(
                            EncryptionFunctions.swapFirstAndLast(original)));
        }

        @Test
        @DisplayName("preserves string length")
        void preservesLength() {
            String input = "ABCDE";
            assertEquals(input.length(), EncryptionFunctions.swapFirstAndLast(input).length());
        }
    }

    // -------------------------------------------------------------------------
    // reverse
    // -------------------------------------------------------------------------
    @Nested
    @DisplayName("reverse()")
    class Reverse {

        @Test
        @DisplayName("reverses a normal string")
        void reversesString() {
            assertEquals("OLLEH", EncryptionFunctions.reverse("HELLO"));
        }

        @Test
        @DisplayName("single character string returns same character")
        void singleChar() {
            assertEquals("A", EncryptionFunctions.reverse("A"));
        }

        @Test
        @DisplayName("two-character string reverses correctly")
        void twoCharString() {
            assertEquals("BA", EncryptionFunctions.reverse("AB"));
        }

        @Test
        @DisplayName("palindrome returns itself")
        void palindrome() {
            assertEquals("RACECAR", EncryptionFunctions.reverse("RACECAR"));
        }

        @Test
        @DisplayName("is self-inverse — applying twice returns original")
        void selfInverse() {
            String original = "HELLOWORLD";
            assertEquals(original,
                    EncryptionFunctions.reverse(
                            EncryptionFunctions.reverse(original)));
        }

        @Test
        @DisplayName("preserves string length")
        void preservesLength() {
            String input = "ABCDE";
            assertEquals(input.length(), EncryptionFunctions.reverse(input).length());
        }
    }

    // -------------------------------------------------------------------------
    // swapTopBottom
    // -------------------------------------------------------------------------
    @Nested
    @DisplayName("swapTopBottom()")
    class SwapTopBottom {

        @Test
        @DisplayName("even-length string — swaps top and bottom rows correctly")
        void evenLength() {
            // "ABCD" -> matrix [A,B] / [C,D] -> swap -> [C,D] / [A,B] -> "CDAB"
            assertEquals("CDAB", EncryptionFunctions.swapTopBottom("ABCD"));
        }

        @Test
        @DisplayName("odd-length string — even portion is swapped, last char unchanged")
        void oddLength() {
            // "ABCDE" -> evenBound=4, matrix [A,B] / [C,D] -> swap -> "CDAB" + "E"
            assertEquals("CDABE", EncryptionFunctions.swapTopBottom("ABCDE"));
        }

        @Test
        @DisplayName("odd-length string — leftover character stays at end")
        void oddLengthLeftoverPreserved() {
            String result = EncryptionFunctions.swapTopBottom("ABCDE");
            assertEquals('E', result.charAt(result.length() - 1));
        }

        @Test
        @DisplayName("two-character string swaps both characters")
        void twoCharString() {
            assertEquals("BA", EncryptionFunctions.swapTopBottom("AB"));
        }

        @Test
        @DisplayName("single character string returns same character")
        void singleChar() {
            assertEquals("A", EncryptionFunctions.swapTopBottom("A"));
        }

        @Test
        @DisplayName("is self-inverse on even-length — applying twice returns original")
        void selfInverseEven() {
            String original = "HELLOWORLD";
            assertEquals(original,
                    EncryptionFunctions.swapTopBottom(
                            EncryptionFunctions.swapTopBottom(original)));
        }

        @Test
        @DisplayName("is self-inverse on odd-length — applying twice returns original")
        void selfInverseOdd() {
            String original = "HELLOWORLD!";
            assertEquals(original,
                    EncryptionFunctions.swapTopBottom(
                            EncryptionFunctions.swapTopBottom(original)));
        }

        @Test
        @DisplayName("preserves string length on even input")
        void preservesLengthEven() {
            String input = "ABCDEF";
            assertEquals(input.length(), EncryptionFunctions.swapTopBottom(input).length());
        }

        @Test
        @DisplayName("preserves string length on odd input")
        void preservesLengthOdd() {
            String input = "ABCDE";
            assertEquals(input.length(), EncryptionFunctions.swapTopBottom(input).length());
        }
    }
}