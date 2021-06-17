package offer.easy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/17 15:57
 * @Description:
 */
public class IsContinuous {
    public static boolean IsContinuous(int[] numbers) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int[] cnt = new int[14];

        for (int num : numbers) {
            cnt[num]++;
            if ((num != 0 && cnt[num] > 1) || (num == 0 && cnt[num] > 4)) {
                return false;
            }
            if (num == 0) {
                continue;
            }
            low = Math.min(num, low);
            high = Math.max(num, high);
        }
        return high - low < 5;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 7, 0};
        Arrays.sort(arr);
        System.out.println(IsContinuous(arr));

    }
}
