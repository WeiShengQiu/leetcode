package test;

import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static Integer math(String str) {
        str = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
        String a = str.substring(0, str.indexOf(" "));
        str = str.substring(str.indexOf(" ") + 1, str.length());
        String b = str.substring(0, str.indexOf(" "));
        str = str.substring(str.indexOf(" ") + 1, str.length());
        String c = str;

        int x = 0;
        int y = 0;
        int sum = 0;
        switch (a) {
            case "mul":
                try {
                    x = Integer.parseInt(b);
                } catch (Exception e) {
                    x = math(b);
                }
                try {
                    y = Integer.parseInt(c);
                } catch (Exception e) {
                    y = math(c);
                }
                sum = x * y;
                break;
            case "add":
                try {
                    x = Integer.parseInt(b);
                } catch (Exception e) {
                    x = math(b);
                }
                try {
                    y = Integer.parseInt(c);
                } catch (Exception e) {
                    y = math(c);
                }
                sum = x + y;
                break;
            case "sub":
                try {
                    x = Integer.parseInt(b);
                } catch (Exception e) {
                    x = math(b);
                }
                try {
                    y = Integer.parseInt(c);
                } catch (Exception e) {
                    y = math(c);
                }
                sum = x - y;
                break;
            case "div":
                try {
                    x = Integer.parseInt(b);
                } catch (Exception e) {
                    x = math(b);
                }
                try {
                    y = Integer.parseInt(c);
                } catch (Exception e) {
                    y = math(c);
                }
                if (y == 0) {
                    System.out.println("error");
                    return null;
                }
                sum = x / y;
                if (x % y != 0 && sum < 0) {
                    sum = sum - 1;
                }

                break;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Integer sum = math(str);
        if (!Objects.isNull(sum)) {
            System.out.println(sum);
        }

    }
}
