package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> intList = new ArrayList<>();
            int m = sc.nextInt();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                intList.add(sc.nextInt());
            }
            Collections.sort(intList);
            List<Integer> sumList = new ArrayList<>(16);
            for (int i = 0; i < m; i++) {
                sumList.add(i, intList.get(i));
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < (n / m); j++) {
                    int k = i + m * (j + 1);
                    if (k < intList.size()) {
                        sumList.set(i, sumList.get(i) + intList.get(k));
                    }
                }
            }
            Collections.sort(sumList);
            System.out.println(sumList.get(sumList.size() - 1));
        }
    }
}
