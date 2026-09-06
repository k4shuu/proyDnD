package util;

import java.util.Random;
public class Dice {
    private static final Random random = new Random();

    public static int advantageRoll(int sides) {
        int roll1 = random.nextInt(sides) + 1;
        int roll2 = random.nextInt(sides) + 1;
        return Math.max(roll1, roll2);
    }

    public static int disadvantageRoll(int sides) {
        int roll1 = random.nextInt(sides) + 1;
        int roll2 = random.nextInt(sides) + 1;
        return Math.min(roll1, roll2);
    }

    public static int roll(int n, int sides) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += random.nextInt(sides) + 1;
        }
        return total;
    }

    public static int roll(int sides) {
        return random.nextInt(sides) + 1;
    }
}
