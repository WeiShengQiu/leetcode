package offer.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/17 17:32
 * @Description:
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = A[i];
            A[i] = 1;
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                B[i] *= A[j];
            }
            A[i] = temp;
        }
        return B;
    }
}
