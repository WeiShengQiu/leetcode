package huawei;

import java.util.*;

public class Main {
    public static boolean isLongPressedName(String name, String typed) {
        // 还可以写若干特殊情况
        if (Objects.isNull(typed) || "".equals(typed)) {
            return false;
        }
        String[] names = name.split("");
        for (int i = 0; i < names.length; i++) {
            // 判断是否存在对应的字符，有就去除，没有返回false
            int last = typed.lastIndexOf(names[i]);
            int first = typed.indexOf(names[i]);
            if (last > -1 && typed.startsWith(names[i])) {
                typed = typed.substring(first + 1);
            } else {
                return false;
            }
        }
        // 能完全遍历完说明满足需求
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isLongPressedName("name", "nnaammee"));
        System.out.println(isLongPressedName("namee", "nnaamme"));
        System.out.println(isLongPressedName("name", "name"));
        System.out.println(isLongPressedName("naemmm", "naemmm"));
    }
}
