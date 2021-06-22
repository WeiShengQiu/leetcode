package offer.normal;

public class RectCover {
    public int rectCover(int target) {
        if (target <= 2) {
            return target;
        }
        // 反向递推
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

//    public int rectCover(int target) {
//        if (target <= 2) {
//            return target;
//        }
//        return rectCover(target - 1) + rectCover(target - 2);
//    }
}
