package greedy_algorithm.assign_cookies;

import java.util.Arrays;

public class Solution {

    public static int findSatisfiedChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length, m = s.length, i = 0, j = 0;
        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] greed = {1, 5, 3, 3, 4};
        int[] size = {4, 2, 1, 2, 1, 3};

        int answer = findSatisfiedChildren(greed, size);
        System.out.println(answer);
    }
}
