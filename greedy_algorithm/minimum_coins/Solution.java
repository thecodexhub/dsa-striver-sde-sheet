package greedy_algorithm.minimum_coins;

public class Solution {

    public static int minimumCoins(int value) {
        if (value < 1) return 0;

        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int result = 0, index = denominations.length - 1;

        while (value > 0) {
            if (denominations[index] > value) {
                index--;
                continue;
            }

            int coinsNeeded = value / denominations[index];
            result += coinsNeeded;

            value -= coinsNeeded * denominations[index];
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int value = 49;
        int coins = minimumCoins(value);

        System.out.println(coins);
    }
}
