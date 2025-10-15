package Utils;

import java.util.Random;
public class RandomGeneratorUtil {
    
    public static int generateRandomInt(int bound) {
        long seed = System.currentTimeMillis();
        Random randomGenerator = new java.util.Random(seed);
        return randomGenerator.nextInt(bound);
    }
}
