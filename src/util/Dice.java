package util;

import java.util.Random;
public class Dice {
    private static final Random random = new Random();

    public static int roll(int sides){
        return random.nextInt(sides) + 1;
    }
}
