package huawei;


/**
 * 给定一个升序整型数组nums[]，长度length，再给定一个目标值target，需要从数组中使用二分查找法查找此值，如果能够找到，返回数组下标，否则返回-1
 */
public class Main4 {
    public static int find(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 10};
        System.out.println(find(arr, 9));
    }
}
