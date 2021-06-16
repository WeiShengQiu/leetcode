package offer.easy;

public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            int temp = dp[i - 1] + array[i];
            if (temp > array[i]) {
                dp[i] = temp;
            } else {
                dp[i] = array[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, -1, 8, -3, 2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
