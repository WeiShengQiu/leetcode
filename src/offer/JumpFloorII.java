package offer;

import com.sun.tools.javac.Main;

public class JumpFloorII {
    public int jumpFloorII(int target) {
        return 1 << (target - 1); // 做移乘二 右移除二
    }

    public static void main(String[] args) {
        System.out.println(2 << 2);
    }
}
