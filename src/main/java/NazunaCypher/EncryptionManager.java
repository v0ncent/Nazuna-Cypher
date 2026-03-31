package NazunaCypher;

import java.util.Random;

public final class EncryptionManager {
    private final StringBuilder seed = new StringBuilder();

    public EncryptedData encrypt(String plainText, int iterations) {
        final int bound = 101;
        final Random seeder = new Random(bound);

        int code = seeder.nextInt(bound);

        for (int i = 0; i < iterations; i++) {
            plainText = seedToFunction(code, plainText, EncryptionFunctions.Mode.ENCRYPT);
            seed.append(code);

            code = seeder.nextInt();
        }

        return new EncryptedData(seed.toString(), plainText);
    }

    private String seedToFunction(int code, String data, EncryptionFunctions.Mode mode) {
        switch (code) {
            case 1:
                return EncryptionFunctions.swapFirstAndLast(mode, data);
            case 2:
                return  EncryptionFunctions.reverse(data);
                

        }

        return data;
    }

    public String getSeed() {
        return seed.toString();
    }

    public record EncryptedData(String seed, String data) {
    }
}
