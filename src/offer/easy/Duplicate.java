package offer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangshiqi
 * @DateTime: 2021/6/17 17:12
 * @Description:
 */
public class Duplicate {
    public int duplicate(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) {
            if (map.containsKey(i)) {
                return i;
            } else {
                map.put(i, 0);
            }
        }
        return -1;
    }
}
