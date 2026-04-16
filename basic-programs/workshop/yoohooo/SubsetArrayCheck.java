package yoohooo;

import java.util.HashMap;
import java.util.Map;

public class SubsetArrayCheck {

    private static boolean isSubset(int[] mainArray, int[] candidateSubset) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int value : mainArray) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        for (int value : candidateSubset) {
            int count = frequency.getOrDefault(value, 0);
            if (count == 0) {
                return false;
            }
            frequency.put(value, count - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5};

        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 2, 3};

        boolean result1 = isSubset(arr1, arr2);
        boolean result2 = isSubset(arr3, arr4);

        System.out.println("arr2 is subset of arr1: " + result1);
        System.out.println("arr4 is subset of arr3: " + result2);
    }
}
