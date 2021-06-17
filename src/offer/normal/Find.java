package offer.normal;

public class Find {
    public static boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        for (int[] arr : array) {
            if (arr == null && arr[0] > target) {
                continue;
            }
            for (int i : arr) {
                if (i > target) {
                    continue;
                }
                if (i == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = null;
        ;
        Find(16, arr);
    }
}
