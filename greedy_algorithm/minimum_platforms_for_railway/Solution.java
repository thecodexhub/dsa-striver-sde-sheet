package greedy_algorithm.minimum_platforms_for_railway;

import java.util.Arrays;

public class Solution {

    public static int countPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int max = 0, count = 0;
        for (int i = 0, j = 0; i < arr.length && j < dep.length;) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
                max = Math.max(max, count);
            } else {
                count--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 1800};

        int platforms = countPlatforms(arr, dep);
        System.out.println(platforms);
    }
}
