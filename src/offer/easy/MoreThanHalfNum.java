package offer.easy;

public class MoreThanHalfNum {
    public static int MoreThanHalfNum(int[] array) {
        int count = 0;
        int now = array[0];
        for (int num : array) {
            if (count == 0) {
                now = num;
            }
            if (now == num) {
                ++count;
            } else {
                --count;
            }
        }
        return now;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 2, 2, 1, 2, 2, 4, 3};
        System.out.println(MoreThanHalfNum(a));
    }
}
