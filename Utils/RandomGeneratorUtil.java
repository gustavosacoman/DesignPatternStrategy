package Utils;

import java.util.Random;
public class RandomGeneratorUtil {
    
    private static final Random randomGenerator = new Random();

    public static int generateRandomInt(int bound) {
    return randomGenerator.nextInt(bound);
    }
}
