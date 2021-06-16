package offer.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        String[] strings = str.split("");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) {
                map.put(strings[i], i);
            } else {
                map.put(strings[i], -1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
