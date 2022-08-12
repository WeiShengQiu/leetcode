package huawei;

import java.util.Arrays;

public class Main3 {
    /**
     * 版本比大小
     *
     * @param version1 版本1
     * @param version2 版本2
     * @return 返回code码
     */
    public static int compare(String version1, String version2) {
        int[] v1 = transInt(version1.split("\\."));
        int[] v2 = transInt(version2.split("\\."));
        boolean who = v1.length > v2.length;
        int maxLength = who ? v1.length : v2.length;
        if (who) {
            v2 = Arrays.copyOf(v2, maxLength);
        } else {
            v1 = Arrays.copyOf(v1, maxLength);
        }
        for (int i = 0; i < maxLength; i++) {
            if (v1[i] > v2[i]) {
                return 1;
            } else if (v1[i] < v2[i]) {
                return -1;
            } else {
                continue;
            }
        }
        return 0;
    }

    /**
     * 数组转换
     *
     * @param str string数组
     * @return 转换后的int数组
     */
    public static int[] transInt(String[] str) {
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(compare("0.1", "1.1"));
        System.out.println(compare("1.0.1", "1"));
        System.out.println(compare("7.5.2.4", "7.5.3"));
        System.out.println(compare("1.01", "1.001"));
        System.out.println(compare("1.0", "1.0.0"));
    }
}
