package offer.easy;

import java.util.Arrays;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
