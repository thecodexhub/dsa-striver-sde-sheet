package binary_search.nth_root_of_a_number;

public class Solution {

    // Returns 2 when mid is higher than answer expected.
    // Returns 1 when mid is the answer.
    // Returns 0 when mid is lower than answer expected.
    public static int validateRoot(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public static int findNthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (high + low) / 2;
            int res = validateRoot(mid, n, m);

            if (res == 1) return mid;

            if (res == 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 7, m = 2187;
        int answer = findNthRoot(n, m);
        System.out.println(answer);
    }
}
