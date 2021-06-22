package offer.normal;

public class JumpFloor {
    public static int jumpFloor(int target) {
        int a = 1, b = 1;
        for (int i = 2; i < target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
//    public static int jumpFloor(int target) {
//        if (target == 1) {
//            return 1;
//        }
//        if (target == 2) {
//            return 2;
//        }
//        return jumpFloor(target - 1) + jumpFloor(target - 2);
//    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(3));
    }
}
