package offer.normal;

import java.util.ArrayList;
import java.util.List;

public class ReOrderArray {
    public int[] reOrderArray(int[] array) {
        List<Integer> j = new ArrayList<>();
        List<Integer> o = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                o.add(i);
            } else {
                j.add(i);
            }
        }
        j.addAll(o);
        return j.stream().mapToInt(Integer::valueOf).toArray();
    }
}
