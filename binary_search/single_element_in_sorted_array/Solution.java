package binary_search.single_element_in_sorted_array;

public class Solution {
    public static int singleNonDuplicate(int[] arr) {
        int low = 0, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == arr[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7};
        int result = singleNonDuplicate(arr);

        System.out.println(result);
    }
}
