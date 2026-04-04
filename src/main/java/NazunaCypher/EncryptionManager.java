package NazunaCypher;

import java.util.HashMap;
import java.util.Random;

public final class EncryptionManager {
    private final StringBuilder seed = new StringBuilder();

    private final HashMap<Integer, Integer> usedCodes = new HashMap<>();

    public EncryptedData encrypt(String plainText, int iterations) {
        final int bound = 101;
        final Random seeder = new Random(bound);

        int code = seeder.nextInt(bound);

        for (int i = 0; i < iterations; i++) {
            plainText = seedToFunction(code, plainText);
            seed.append(code);

            do {

                code = seeder.nextInt();

            } while (usedCodes.get(code) != null);

            usedCodes.put(code, code);
        }

        return new EncryptedData(seed.toString(), plainText);
    }

    private String seedToFunction(int code, String data) {
        switch (code) {
            case 1:
                return EncryptionFunctions.swapFirstAndLast(data);
            case 2:
                return  EncryptionFunctions.reverse(data);

            case 3:
                return  EncryptionFunctions.swapTopBottom(data);
        }

        return data;
    }

    public String getSeed() {
        return seed.toString();
    }

    public record EncryptedData(String seed, String data) {
    }
}
