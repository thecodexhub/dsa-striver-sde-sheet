package greedy_algorithm.fractional_knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static double findMaximumValue(int n, int w, int[] values, int[] weights) {
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, (a, b) -> (int) (b.getValue() / b.getWeight()) - (int) (a.getValue() / a.getWeight()));
        double maxValue = 0;
        int currentWeight = 0, i = 0;

        List<Item> addedItems = new ArrayList<>();

        while (currentWeight < w && i < n) {
            int remainingWeight = w - currentWeight;
            int nextWeight = items[i].getWeight();

            if (remainingWeight > nextWeight) {
                maxValue += items[i].getValue();
                currentWeight += items[i].getWeight();
                addedItems.add(new Item(items[i].getValue(), items[i].getWeight()));
            } else {
                double valueCanBeAdded = (items[i].getValue() / items[i].getWeight()) * remainingWeight;
                maxValue += valueCanBeAdded;
                currentWeight += remainingWeight;
                addedItems.add(new Item(valueCanBeAdded, remainingWeight));
            }
            i++;
        }

        System.out.println(addedItems);
        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = {100, 60, 122, 200};
        int[] weights = {20, 10, 50, 50};

        double result = findMaximumValue(values.length, 90, values, weights);
        System.out.println(result);
    }
}

class Item {
    private final double value;
    private final int weight;

    Item(double value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public double getValue() {
        return this.value;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}
